package com.boss.learining.springaop.common;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CflibProxy implements MethodInterceptor {

    private Object srcObject;

    public Object newInstance(Object srcObject) {
        this.srcObject = srcObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.srcObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = method.invoke(this.srcObject, objects);

        return result;
    }
}
