package com.boss.learning.springerr;

import com.boss.learning.springerr.bean.User;
import com.boss.learning.springerr.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("张三");
        user.setAge(120);
        userService.saveUser(user);
    }
}
