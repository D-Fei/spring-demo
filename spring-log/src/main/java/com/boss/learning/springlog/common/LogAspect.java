package com.boss.learning.springlog.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.boss.learning.springlog.service.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object log(ProceedingJoinPoint joinPoint) {
        long startToken = System.currentTimeMillis();

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();
        String operate = "";
        String desc = "";
        Method[] methods = joinPoint.getTarget().getClass().getMethods();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                MyLog myLog = method.getAnnotation(MyLog.class);
                operate = myLog.action();
                desc = myLog.desc();
                break;
            }
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long respTime = System.currentTimeMillis() - startToken;

        Map logMap = new HashMap();
        logMap.put("time", time);
        logMap.put("className", className);
        logMap.put("methodName", methodName);
        logMap.put("args", args);
        logMap.put("operate", operate);
        logMap.put("desc", desc);
        logMap.put("result", result);
        logMap.put("respTime", respTime);

        System.out.println("logMap:" + logMap);
        return result;
    }
}
