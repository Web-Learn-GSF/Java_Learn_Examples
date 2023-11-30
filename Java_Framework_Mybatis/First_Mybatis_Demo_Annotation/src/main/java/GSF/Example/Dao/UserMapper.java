package GSF.Example.Dao;

import GSF.Example.Pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from learn_mybatis.user")
    List<User> getUserList();

    //方法存在多个参数，所有的参数前面前面必须加上 @Param("") 注解
    @Select("select * from learn_mybatis.user where id=#{id}")
    User getUserByID(@Param("id") int id);

    @Insert("insert into learn_mybatis.user(id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser(User user);

    @Insert("insert into learn_mybatis.user(id,name,pwd) values(#{user_id},#{user_name},#{user_pwd})")
    int addUserByMap(Map<String, Object> map);

    @Update("update learn_mybatis.user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from learn_mybatis.user where id=#{uid}")
    int deleteUser(@Param("uid") int id);
}
