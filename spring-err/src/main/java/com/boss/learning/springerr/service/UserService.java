package com.boss.learning.springerr.service;

import com.boss.learning.springerr.bean.User;
import com.boss.learning.springerr.common.MyExceptionCode;
import com.boss.learning.springerr.common.MyThrowsException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void saveUser(User user) {
        if (user.getName().indexOf("#") != -1) {
            MyThrowsException.throwErr(MyExceptionCode.USER_NAME_EXCEPTION);
        }
        if (user.getAge() < 0 || user.getAge() > 100) {
            MyThrowsException.throwErr(MyExceptionCode.USER_AGE_SCOPE_EXCEPTION);
        }

        System.out.println("saveUser:" + user.getName());

    }

    public void updateUser(User user) {
        System.out.println("updateUser:" + user);
    }
}
