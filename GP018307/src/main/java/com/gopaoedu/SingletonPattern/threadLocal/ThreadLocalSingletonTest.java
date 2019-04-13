package com.gopaoedu.SingletonPattern.threadLocal;

import com.gopaoedu.SingletonPattern.ExectorThread;

/**
 * 线程内的单例模式 测试
 *
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
        //主线程调用（每个对象都是一样的）
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        //多线程调用(每个线程对象不一样)
        Thread thread = new Thread(new ExectorThread());
        thread.start();
        Thread thread2 = new Thread(new ExectorThread());
        thread2.start();
        Thread thread3 = new Thread(new ExectorThread());
        thread3.start();
    }

}
