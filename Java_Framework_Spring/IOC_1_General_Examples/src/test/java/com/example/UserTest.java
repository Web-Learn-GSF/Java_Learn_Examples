package com.example;

import com.example.Dao.UserDaoImpl;
import com.example.Dao.UserSqlImpl;
import com.example.Service.UserService;
import com.example.Service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test(){
        //// 原先的实现
        //UserService service = new UserServiceImpl();
        //service.getUser();

        //// 添加set后的实现
        //UserServiceImpl service = new UserServiceImpl();
        //
        //service.setUserDao( new UserDaoImpl() );
        //service.getUser();
        //
        //service.setUserDao( new UserSqlImpl() );
        //service.getUser();

        // 修改为IOC实现
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl serviceImpl = (UserServiceImpl) context.getBean("ServiceImpl");
        serviceImpl.getUser();

    }
}