package com.example.Service;

import com.example.Dao.UserDao;
import com.example.Dao.UserDaoImpl;
import com.example.Dao.UserSqlImpl;

public class UserServiceImpl implements UserService {

    // 原先的代码实现
    //private UserDao userDao = new UserDaoImpl();

    // 新增Dao接口后的代码实现
    //private UserSqlImpl userDao = new UserSqlImpl();

    // 利用set实现
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void getUser() {
        userDao.getUser();
    }
}
