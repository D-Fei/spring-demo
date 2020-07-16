package com.boss.learning.springdemo.common;

import com.boss.learning.springdemo.service.UserService;

public class BeanFactory {
    //单例模式-饿汉模式
    /*private static UserService userService = new UserService();*/

    private static UserService userService;

    static {
        try {
            userService = (UserService) Class.forName("com.boss.learning.springdemo.service.UserService").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UserService getUserService() {
        /*return new UserService();*/
        return userService;
    }
}
