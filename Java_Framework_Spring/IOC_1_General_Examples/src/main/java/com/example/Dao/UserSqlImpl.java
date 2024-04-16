package com.example.Dao;

public class UserSqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Sql获取用户数据");
    }
}
