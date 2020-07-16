package com.boss.learining.springaop.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object srcObject;

    public Object newInstance(Object srcObject) {
        this.srcObject = srcObject;
        return Proxy.newProxyInstance(srcObject.getClass().getClassLoader(), srcObject.getClass().getInterfaces(), this);

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法调用前");
        Object result = method.invoke(srcObject, args);
        System.out.println("方法调用后");
        return result;
    }
}
