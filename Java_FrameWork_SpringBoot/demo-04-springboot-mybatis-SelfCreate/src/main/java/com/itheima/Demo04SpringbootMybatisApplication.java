package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com")
@SpringBootApplication
public class Demo04SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo04SpringbootMybatisApplication.class, args);
    }

}
