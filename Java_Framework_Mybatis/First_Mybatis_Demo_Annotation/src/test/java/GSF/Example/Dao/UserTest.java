package GSF.Example.Dao;

import GSF.Example.Pojo.User;
import GSF.Example.Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserTest {
    @Test
    public void GetUserList() {
        // 官方建议用try...catch包裹，可以不用

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        try {
            UserMapper mapper = sqlsession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

    }


    @Test
    public void GetUserById() {
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserByID(2);
        System.out.println(user);

        sqlsession.close();
    }

    @Test
    public void AddUser() {
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        // 插入成功，返回值为1
        int flag = mapper.addUser(new User(20, "GSF", "qwerty"));
        System.out.println(flag);

        sqlsession.commit();
        sqlsession.close();

    }

    @Test
    public void AddUserByMap() {
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        // 插入成功，返回值为1
        HashMap<String, Object> map_obj = new HashMap<>();
        map_obj.put("user_id", 21);
        map_obj.put("user_name", "121212");
        map_obj.put("user_pwd", "zxcxvz");
        int flag = mapper.addUserByMap(map_obj);
        System.out.println(flag);

        sqlsession.commit();
        sqlsession.close();

    }

    @Test
    public void UpdateUser() {
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int flag = mapper.updateUser(new User(1, "123", "12345678"));
        System.out.println(flag);

        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void DeleteUser() {
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int flag = mapper.deleteUser(1);
        System.out.println(flag);

        sqlsession.commit();
        sqlsession.close();
    }

}
