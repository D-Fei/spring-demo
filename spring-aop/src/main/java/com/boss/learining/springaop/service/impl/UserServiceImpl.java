package com.boss.learining.springaop.service.impl;

import com.boss.learining.springaop.bean.User;
import com.boss.learining.springaop.service.IUserService;

public class UserServiceImpl implements IUserService {
    public void saveUser(User user) {
        System.out.println("saveUser:" + user.getName());
    }
}
