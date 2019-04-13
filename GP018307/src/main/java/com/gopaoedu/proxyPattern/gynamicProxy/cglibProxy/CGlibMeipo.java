package com.gopaoedu.proxyPattern.gynamicProxy.cglibProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用CGlib进行动态代理
 * 继承MethodInterceptor接口  引入cglib-nodep  jar包
 */
public class CGlibMeipo implements MethodInterceptor {

    /**
     * 这是代理的目标类
     * @param clazz
     * @return
     */
    public Object getInstance(Class<?> clazz){
        //相当于Proxy，代理
        Enhancer enhancer = new Enhancer();
        //设置目标类
        enhancer.setSuperclass(clazz);
        //设置代理类
        enhancer.setCallback(this);
        //创建代理类的工具类，返回
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       //前置增强
        before();

        //使用动态代理，调用父类的方法（Customer类是被CGlib自动生成的类所继承的，所以此时CGlib类必须调用父类的方法）
        Object obj = methodProxy.invokeSuper(o, objects);

        //后置增强
        after();

        return obj;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备办事");
    }
}
