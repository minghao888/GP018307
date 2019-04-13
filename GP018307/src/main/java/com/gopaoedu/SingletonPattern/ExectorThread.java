package com.gopaoedu.SingletonPattern;

import com.gopaoedu.SingletonPattern.lazy.LazySingletonPattern;
import com.gopaoedu.SingletonPattern.register.ContainerSingletonPattern;
import com.gopaoedu.SingletonPattern.threadLocal.ThreadLocalSingleton;

/**
 * 多线程调用
 */
public class ExectorThread implements Runnable {
    @Override
    public void run() {
        //懒汉单例模式多线程测试
//        LazySingletonPattern lazySingletonPattern = LazySingletonPattern.getInstance();
//        System.out.println(Thread.currentThread().getName()+" : "+ lazySingletonPattern);

        // 容器缓存法的单例模式  spring常用模式
//        Object instance = ContainerSingletonPattern.getInstance("com.gopaoedu.SingletonPattern.Pojo");
//        Object instance2 = ContainerSingletonPattern.getInstance("com.gopaoedu.SingletonPattern.Pojo2");
//        Object instance3 = ContainerSingletonPattern.getInstance("com.gopaoedu.SingletonPattern.Pojo");
//        Object instance4 = ContainerSingletonPattern.getInstance("com.gopaoedu.SingletonPattern.Pojo2");
//        System.out.println(Thread.currentThread().getName()+"："+instance);
//        System.out.println(Thread.currentThread().getName()+"："+instance2);
//        System.out.println(Thread.currentThread().getName()+"："+instance3);
//        System.out.println(Thread.currentThread().getName()+"："+instance4);


        //ThreadLocal  线程内的单例模式（每个线程一个单例）
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+": "+instance);

    }
}
