package com.boss.learning.springlog.service;

import com.boss.learning.springlog.common.MyLog;
import org.springframework.stereotype.Service;

@Service
public class SysService {
    @MyLog(action = "获取当前时间戳")
    public Long getToken() {
        Long timeStamp = System.currentTimeMillis();
        System.out.println(timeStamp);
        return timeStamp;
    }
}
