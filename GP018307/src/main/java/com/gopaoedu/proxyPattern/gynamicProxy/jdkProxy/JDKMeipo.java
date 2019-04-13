package com.gopaoedu.proxyPattern.gynamicProxy.jdkProxy;

import com.gopaoedu.proxyPattern.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 媒婆。动态的代理类 必须实现InvocationHandler这个jdk的代理接口，否则无法实现动态代理
 */
public class JDKMeipo implements InvocationHandler {

    /**
     * 1.定义被代理类的接口对象，
     */
    private Object person;

    /**
     * 2.创建动态代理对象
     * @param person 传入需要被代理（增强）的对象  必须是当前接口的实现类才可以
     * @return
     */
    public Object getInstance(Object person){
        //赋值
        this.person = person;
        //获取类类型
        Class<? extends Object> clazz = person.getClass();
        //返回当前接口类的实现类的动态代理 ，传入当前类路径和实现的所有接口类getClassLoader，getInterfaces，this
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    /**
     * 3.
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object love = method.invoke(this.person,args);
        after();
        return love;
    }


    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备办事");
    }
}
