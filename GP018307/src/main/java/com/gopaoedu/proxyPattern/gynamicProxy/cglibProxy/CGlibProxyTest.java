package com.gopaoedu.proxyPattern.gynamicProxy.cglibProxy;

import java.lang.reflect.Method;

/**
 * CGlib动态代理测试类
 */
public class CGlibProxyTest {


    public static void main(String[] args) {
        Object instance = new CGlibMeipo().getInstance(Customer.class);
        try {
            Method method = instance.getClass().getMethod("findLove", new Class[]{});
            method.invoke(instance, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
