package com.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        student.show();

        System.out.println("====================================================================");

        Student student2 = (Student) context.getBean("student2");
        student2.show();
    }
}