package com.boss.learning.springioc;

import com.boss.learning.springioc.bean.User;
import com.boss.learning.springioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.boss.learning");
        for (int i = 0; i < 3; i++) {
            UserService userService = context.getBean(UserService.class);
            System.out.println(userService);
            User user = new User();
            user.setName("ggs");
            userService.saveUser(user);
        }
        ((AnnotationConfigApplicationContext) context).close();


    }
}
