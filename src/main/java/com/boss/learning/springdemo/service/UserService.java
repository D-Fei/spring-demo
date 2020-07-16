package com.boss.learning.springdemo.service;

import com.boss.learning.springdemo.bean.User;
import com.boss.learning.springdemo.dao.UserDao;

public class UserService {
    private UserDao userDao;
    //通过构造方法来注入
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
        System.out.println("saveUser:" + user.getName());
    }

    public UserService() {
        System.out.println("UserService创建了");
    }

    public void init() {
        System.out.println("UserService初始化了");
    }

    public void destory() {
        System.out.println("UserService销毁了");
    }
}
