package com.boss.learning.springerr.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrAspect {
    @Pointcut("execution(* com.boss.learning.springerr.service.*.*(..))")
    public void pointCut() {
    }
    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void err(JoinPoint joinPoint,Exception e) {
//        System.out.println("err:" + e.getMessage());
        MyThrowsException.throwErr(e);
    }
}
