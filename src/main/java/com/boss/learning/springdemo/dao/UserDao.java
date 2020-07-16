package com.boss.learning.springdemo.dao;

import com.boss.learning.springdemo.bean.User;

public class UserDao {
    public void saveUser(User user) {
        System.out.println("saveUser储存到数据库");
    }
}
