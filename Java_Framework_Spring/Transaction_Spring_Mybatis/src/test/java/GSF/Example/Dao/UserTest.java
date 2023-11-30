package GSF.Example.Dao;

import GSF.Example.Pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void TestTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");

        User userById = userDaoImpl.getUserById(28);
        System.out.println(userById);
    }
}
