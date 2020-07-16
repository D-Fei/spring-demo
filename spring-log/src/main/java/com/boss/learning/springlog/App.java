package com.boss.learning.springlog;

import com.boss.learning.springlog.bean.User;
import com.boss.learning.springlog.service.SysService;
import com.boss.learning.springlog.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        SysService sysService = context.getBean(SysService.class);
        User user = new User();
        user.setName("ggs");
        userService.saveUser(user);
        userService.updateUser(user);

        User user2 = userService.getUser();
        System.out.println("user2:" + user2.getName());
        sysService.getToken();
    }
}
