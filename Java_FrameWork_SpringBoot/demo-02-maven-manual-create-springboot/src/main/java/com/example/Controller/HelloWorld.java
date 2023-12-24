package com.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/gsf_hello")
    public String hello(){
        return "hello, world，maven手动创建springboot项目，并添加依赖";
    }
}
