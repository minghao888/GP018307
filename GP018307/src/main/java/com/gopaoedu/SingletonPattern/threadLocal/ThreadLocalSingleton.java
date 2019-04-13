package com.gopaoedu.SingletonPattern.threadLocal;

/**
 * 线程内的单例模式（伪单例，多数据源切换的时候可以使用）
 *      每个线程一个单例对象，多个线程使用对各单例对象
 */
public class ThreadLocalSingleton {
    //1.私有化构造
    private ThreadLocalSingleton(){}
    //2.创建ThreadLocal线程内单例
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        //每个线程进来就创建一个ThreadLocalSingleton对象
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    //3.返回当前线程的ThreadLocalSingleton对象
    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();  //使用get()方法直接返回当前ThreadLocalSingleton单例对象
    }
}
