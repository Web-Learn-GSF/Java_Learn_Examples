package com.example.Proxy;

import com.example.Service.UserService;

public class UserServiceProxy implements UserService {

    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void add() {
        System.out.println("在add方法前执行前置通知");
        target.add();
        System.out.println("在add方法后执行后置通知");
    }

    @Override
    public void delete() {
        System.out.println("在delete方法前执行前置通知");
        target.delete();
        System.out.println("在delete方法后执行后置通知");
    }

    @Override
    public void update() {
        System.out.println("在update方法前执行前置通知");
        target.update();
        System.out.println("在update方法后执行后置通知");
    }

    @Override
    public void search() {
        System.out.println("在search方法前执行前置通知");
        target.search();
        System.out.println("在search方法后执行后置通知");
    }
}
