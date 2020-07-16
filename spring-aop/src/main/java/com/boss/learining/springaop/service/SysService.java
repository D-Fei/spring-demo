package com.boss.learining.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class SysService {
    public Long getToken() {
        long time = System.currentTimeMillis();
        System.out.println("getToken:" + time);
        return time;
    }

    public void validate() {
        throw new NullPointerException("空指针异常");
    }
}
