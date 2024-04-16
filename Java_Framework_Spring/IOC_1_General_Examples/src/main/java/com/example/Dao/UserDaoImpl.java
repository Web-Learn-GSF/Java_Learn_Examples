package com.example.Dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Dao获取用户数据");
    }
}
