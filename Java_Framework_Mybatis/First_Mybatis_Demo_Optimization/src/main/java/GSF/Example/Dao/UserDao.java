package GSF.Example.Dao;

import GSF.Example.Pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();


    // 根据id查询用户
    User getUserById(int id);


    //插入一个用户
    int addUser(User user);

    // 用map的方式插入用户
    int addUserByMap(Map<String, Object> map);

    //修改用户
    int updateUser(User user);


    //删除一个用户
    int deleteUser(int id);

}
