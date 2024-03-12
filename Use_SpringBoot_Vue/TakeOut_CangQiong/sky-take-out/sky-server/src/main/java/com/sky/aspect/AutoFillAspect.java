package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import com.sky.exception.AutoFillException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 自定义切面类，统一为公共字段赋值
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut(){}

    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("公共字段自动填充...");

        // 获取方法签名对象
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法上的注解
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        // 获取注解的操作类型
        OperationType operationType = autoFill.value();

        // 获取当前目标方法的参数：要确保实体类对象在第一个参数的位置
        Object[] args = joinPoint.getArgs();

        // 上保险，做判断
        if (args == null || args.length ==0){
            return;
        }

        // 获取实体对象
        Object entity = args[0];

        // 赋值
        LocalDateTime localDateTime = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();

        if (operationType == OperationType.INSERT){

            try {
                // 获取Method方法
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                // 利用反射调用目标对象的方法
                setCreateTime.invoke(entity, localDateTime);
                setUpdateTime.invoke(entity, localDateTime);
                setCreateUser.invoke(entity, currentId);
                setUpdateUser.invoke(entity, currentId);

            } catch (Exception e) {
                log.error("公共字段自动填充失败【INSERT】：{}", e.getMessage());
                throw new AutoFillException("当前操作失败");
            }

        } else if (operationType == OperationType.UPDATE) {
            try {
                // 获取Method方法
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                // 利用反射调用目标对象的方法
                setUpdateTime.invoke(entity, localDateTime);
                setUpdateUser.invoke(entity, currentId);



            } catch (Exception e) {
                log.error("公共字段自动填充失败【UPDATE】：{}", e.getMessage());
                throw new AutoFillException("当前操作失败");
            }
        }
    }

}
