package com.gopaoedu.SingletonPattern.lazy;

/**
 * 懒汉单例模式
 */
public class LazySingletonPattern {
    //1.私有化构造
    private LazySingletonPattern(){
        //判断实例是否存在，避免被反射强制性访问从而创建多个实例
        if(lazySingletonPattern != null){
            throw  new RuntimeException("不允许创建多个实例！");
        }
    }

    //2.私有化单例对象
    private static volatile LazySingletonPattern lazySingletonPattern = null;

    //3.返回单例，在方法中实现懒汉模式
    public static LazySingletonPattern getInstance(){
        //使用双重if + synchronized 进行线程安全和性能优化

        //判断没有初始化就进入if，有初始化就直接跳过，返回对象
        if(lazySingletonPattern == null){
            //加锁，保证多线程情况下只有一个线程进入进行实例化
            synchronized (LazySingletonPattern.class){
                //再次判断，保证之前是否有线程进来已经实例化了，如果有没有，再实例化
                if(lazySingletonPattern == null){
                    lazySingletonPattern = new LazySingletonPattern();
                }
            }
        }
        return lazySingletonPattern;
    }

}
