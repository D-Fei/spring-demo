package com.boss.learining.springaop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.boss.learining.springaop.service.*.*(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before"+joinPoint.getSignature());
    }
    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after"+joinPoint.getSignature());
    }
    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("around" + joinPoint.getSignature());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around finish" + result);
    }
    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void err(JoinPoint joinPoint, Exception e) {
        System.out.println("err:" + joinPoint.getSignature() + "," + e.getMessage());
    }
}
