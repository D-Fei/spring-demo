package com.boss.learning.springioc.dao;


import com.boss.learning.springioc.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void saveUser(User user) {
        System.out.println("saveUser储存到数据库");
    }
}
