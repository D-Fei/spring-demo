package com.boss.learining.springaop;

import com.boss.learining.springaop.bean.User;
import com.boss.learining.springaop.common.CflibProxy;
import com.boss.learining.springaop.common.JDKProxy;
import com.boss.learining.springaop.service.IUserService;
import com.boss.learining.springaop.service.SysService;
import com.boss.learining.springaop.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        /*IUserService userService = new UserServiceImpl();
        IUserService userServiceProxy = (IUserService) jdkProxy.newInstance(userService);
        System.out.println("userServiceProxy:" + userServiceProxy);
        User user = new User();
        user.setName("ggs");
        userServiceProxy.saveUser(user);

        CflibProxy cflibProxy = new CflibProxy();
        IUserService userService = new UserServiceImpl();
        IUserService iUserServiceProxy = (IUserService) cflibProxy.newInstance(userService);
        System.out.println("iUserServiceProxy:" + iUserServiceProxy);
        User user = new User();
        user.setName("ggs");
        iUserServiceProxy.saveUser(user);

        SysService sysService = new SysService();
        System.out.println(sysService.getToken());
        SysService sysServiceProxy = (SysService) cflibProxy.newInstance(sysService);
        System.out.println(sysServiceProxy.getToken());*/
        SysService sysService = new SysService();
        SysService sysServiceProxy = (SysService) jdkProxy.newInstance(sysService);
        System.out.println(sysServiceProxy.getToken());


        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SysService sysService = context.getBean(SysService.class);
       sysService.getToken();
//        sysService.validate();*/
    }
}
