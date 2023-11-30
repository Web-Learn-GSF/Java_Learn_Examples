package GSF.Example.Dao;

import GSF.Example.Pojo.User;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class UserTest {
    @Test
    public void GetUserList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
        List<User> user = userDaoImpl.getUserList();
        System.out.println(user);
    }

    @Test
    public void GetUserById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
        User userById = userDaoImpl.getUserById(2);
        System.out.println(userById);
    }

    @Test
    public void AddUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
        int addUser = userDaoImpl.addUser(new User(25, "GSF", "qwerty"));
        System.out.println(addUser);
    }

    @Test
    public void AddUserByMap(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");

        // 插入成功，返回值为1
        HashMap<String, Object> map_obj = new HashMap<>();
        map_obj.put("user_id", 22);
        map_obj.put("user_name", "121212");
        map_obj.put("user_pwd", "zxcxvz");

        int addUserByMap = userDaoImpl.addUserByMap(map_obj);
        System.out.println(addUserByMap);
    }

    @Test
    public void UpdateUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
        int updateUser = userDaoImpl.updateUser(new User(25, "GSF-change", "qwerty"));
        System.out.println(updateUser);

    }

    @Test
    public void DeleteUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
        int updateUser = userDaoImpl.deleteUser(2);
        System.out.println(updateUser);
    }
}
