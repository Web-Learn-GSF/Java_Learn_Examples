package com.example.Service;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("执行User的add方法");
    }

    @Override
    public void delete() {
        System.out.println("执行User的delete方法");
    }

    @Override
    public void update() {
        System.out.println("执行User的update方法");
    }

    @Override
    public void search() {
        System.out.println("执行User的search方法");
    }
}
