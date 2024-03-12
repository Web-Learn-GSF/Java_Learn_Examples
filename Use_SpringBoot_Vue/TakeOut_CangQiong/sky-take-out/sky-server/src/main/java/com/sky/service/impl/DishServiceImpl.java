package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.exception.DataAlreadyExistsException;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetMealDishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;
    @Autowired
    private SetMealDishMapper setMealDishMapper;

    /**
     * 新增菜品
     * @param dishDTO
     */
    // 涉及到多个表的操作，需要开启事务，保证一致
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);

        // 先确定系统中是否已经有该菜品
        Dish dishByName = dishMapper.getDishByName(dishDTO.getName());
        if (dishByName != null){
            throw new DataAlreadyExistsException(MessageConstant.Dish_Name_EXISTS);
        }

        // 数据库中没有该数据，继续添加
        // 向菜品表插入一条数据
        dishMapper.insert(dish);

        // 获取菜品的主键值
        Long dishId = dish.getId();
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && !flavors.isEmpty()){
            // 向口味数据中插入菜品id
            flavors.forEach(dishFlavor -> dishFlavor.setDishId(dishId));

            // 向口味表中插入n条数据
            dishFlavorMapper.insertBatch(flavors);
        }
    }

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        Page<DishVO> page = dishMapper.pageQuery(dishPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据菜品id，批量删除菜品信息
     * @param ids
     */
    @Transactional
    public void deleteBatch(List<Long> ids) {
        // 判断是否有在起售中的菜品
        Integer number = dishMapper.countOnSaleDish(ids);
        if (number != 0){
            throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
        }

        // 判断菜品是否有被套餐关联
        List<Long> setmealIds = setMealDishMapper.getSetmealIdsByDishIds(ids);
        if (setmealIds != null && !setmealIds.isEmpty()){
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }

        // 删除菜品表中的数据
        dishMapper.batchDeleteById(ids);

        // 删除口味表中的数据
        dishFlavorMapper.batchDeleteByDishId(ids);

    }

    /**
     * 根据id查询菜品和关联的口味数据
     * @param id
     * @return
     */
    public DishVO getByIdWithFlavor(Long id) {
        // 查询菜品表
        Dish dish = dishMapper.getById(id);

        // 查询菜品id查询口味表
        List<DishFlavor> dishFlavorList = dishFlavorMapper.getByDishId(id);

        // 封装为VO
        DishVO dishVO = new DishVO();
        BeanUtils.copyProperties(dish, dishVO);
        dishVO.setFlavors(dishFlavorList);

        // 返回数据
        return dishVO;
    }

    /**
     * 更新菜品数据及其关联的口味数据
     * @param dishDTO
     */
    @Transactional
    public void updateDishWithFlavor(DishDTO dishDTO) {
        // 更新菜品数据
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        // 先确定系统中是否已经有该菜品
        // 1、根据菜品id查询菜品原名
        Dish dishOrigin = dishMapper.getById(dishDTO.getId());
        // 2、根据菜品名字查询数据库是否有菜品信息
        Dish dishByName = dishMapper.getDishByName(dish.getName());
        if (dishByName != null && !dishOrigin.getName().equals(dishByName.getName())){
            throw new DataAlreadyExistsException(MessageConstant.Dish_Name_EXISTS);
        }

        dishMapper.update(dish);

        // 删除口味数据
        List<Long> ids = new ArrayList<>();
        ids.add(dish.getId());
        dishFlavorMapper.batchDeleteByDishId(ids);

        // 新增修改后的口味数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && !flavors.isEmpty()){
            // 向口味数据中插入菜品id
            flavors.forEach(dishFlavor -> dishFlavor.setDishId(dishDTO.getId()));

            // 向口味表中插入n条数据
            dishFlavorMapper.insertBatch(flavors);
        }
    }

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    public List<Dish> list(Long categoryId) {
        Dish dish = Dish.builder()
                .categoryId(categoryId)
                .status(StatusConstant.ENABLE)
                .build();
        return dishMapper.list(dish);
    }

    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    public List<DishVO> listWithFlavor(Dish dish) {
        List<Dish> dishList = dishMapper.list(dish);

        List<DishVO> dishVOList = new ArrayList<>();

        for (Dish d : dishList) {
            DishVO dishVO = new DishVO();
            BeanUtils.copyProperties(d,dishVO);

            //根据菜品id查询对应的口味
            List<DishFlavor> flavors = dishFlavorMapper.getByDishId(d.getId());

            dishVO.setFlavors(flavors);
            dishVOList.add(dishVO);
        }
        return dishVOList;
    }

    /**
     * 菜品的起售和停售
     * @param status
     * @param id
     */
    public void startOrStop(Integer status, Long id) {
        dishMapper.startOrStop(status, id);
    }
}
