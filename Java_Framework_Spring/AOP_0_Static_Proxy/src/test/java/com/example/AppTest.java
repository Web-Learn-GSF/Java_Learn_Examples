package com.example;

import com.example.Proxy.UserServiceProxy;
import com.example.Service.UserServiceImpl;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{

    @Test
    public void Test(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.add();

        System.out.println("========================================================");

        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserServiceImpl());
        userServiceProxy.add();
    }
}