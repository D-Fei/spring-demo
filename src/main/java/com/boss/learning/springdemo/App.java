package com.boss.learning.springdemo;

import com.boss.learning.springdemo.bean.Student;
import com.boss.learning.springdemo.bean.User;
import com.boss.learning.springdemo.common.BeanFactory;
import com.boss.learning.springdemo.service.UserService;
import com.boss.learning.springdemo.service.impl.SysServiceImpl;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        /**
         * 最原始的方法，实例化和调用
         */
        /*User user = new User();
        user.setName("帅哥");
        UserService userService = new UserService();
        userService.saveUser(user);*/
        /**
         * 利用工厂来创建实例，一次实例化
         */
        /*User user = new User();
        user.setName("帅哥");
        UserService userService = BeanFactory.getUserService();
        userService.saveUser(user);*/

        /**
         * 工厂，多次实例化
         * 工厂启用饿汉模式后在调用
         * 第三次利用反射机制来实例化
         */
//        for (int i = 0; i < 3; i++) {
//            User user = new User();
//            user.setName("帅哥");
//            UserService userService = BeanFactory.getUserService();
//            System.out.println(userService);
//            userService.saveUser(user);
//        }
//        beanFactoryDemo();
//        applicationContextDemo();
//        sysServiceDemo();
//        scopeDemo();
        studentDemo();
    }

    public static void beanFactoryDemo() {
        org.springframework.beans.factory.BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService userService = (UserService) beanFactory.getBean("userService");
        User user = new User();
        user.setName("帅哥");
        userService.saveUser(user);
    }

    public static void applicationContextDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setName("帅哥");
        userService.saveUser(user);
    }

    public static void sysServiceDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SysServiceImpl sysService = (SysServiceImpl) applicationContext.getBean("sysService");
        System.out.println(sysService.getToken());
    }

    public static void scopeDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (int i = 0; i < 3; i++) {
            UserService userService = (UserService) applicationContext.getBean("userService");
            System.out.println(userService);
            User user = new User();
            user.setName("帅哥");
            userService.saveUser(user);
        }
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    public static void studentDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getName() + "," + student.getAge() + "," + Arrays.asList(student.getAdress()));
    }
}
