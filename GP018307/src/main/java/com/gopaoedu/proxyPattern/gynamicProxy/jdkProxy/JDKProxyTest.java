package com.gopaoedu.proxyPattern.gynamicProxy.jdkProxy;

import com.gopaoedu.proxyPattern.Person;

import java.lang.reflect.Method;

/**
 * JDK动态代理测试方法
 */
public class JDKProxyTest {

    public static void main(String[] args) {

        //方式一：强转
        Person person = (Person) new JDKMeipo().getInstance(new Girl());
        person.findLove();

        //方式二：通过反射调用指定方法
        try {
            Object object =  new JDKMeipo().getInstance(new Girl());
            Method findLove = null;
            findLove = object.getClass().getMethod("findLove", new Class[]{});
            findLove.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
