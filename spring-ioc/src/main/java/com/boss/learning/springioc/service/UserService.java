package com.boss.learning.springioc.service;


import com.boss.learning.springioc.bean.User;
import com.boss.learning.springioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Service
@Component
@Scope("prototype")
public class UserService {
    @Autowired
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
    @PostConstruct
    public void init() {
        System.out.println("UserService初始化了");
    }
    @PreDestroy
    public void destory() {
        System.out.println("UserService销毁了");
    }
}
