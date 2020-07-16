package com.boss.learning.springdemo.service.impl;

import com.boss.learning.springdemo.dao.UserDao;
import com.boss.learning.springdemo.service.ISysService;

public class SysServiceImpl implements ISysService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public long getToken() {
        System.out.println(userDao);
        return System.currentTimeMillis();
    }
}
