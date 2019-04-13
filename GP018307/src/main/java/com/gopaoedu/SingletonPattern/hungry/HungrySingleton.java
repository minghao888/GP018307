package com.gopaoedu.SingletonPattern.hungry;

/**
 * 恶汉单例模式
 *
 *     饿汉模式再类加载的时候就立即初始化，并创建单例对象
 *
 *     优点：
 *          1.没有任何的锁，执行效率非常高
 *          2.在用户体验上比懒汉式更好
 *          3.绝对的线程安全，在线程还没有出现的时候就初始化好了，不存在访问的安全问题
 *     缺点：
 *          1.类加载的时候就初始化，不管是否使用。  浪费资源
 *
 */
public class HungrySingleton {
    //1.私有构造
    private HungrySingleton(){}
    //2.初始化就创建对象
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    //3.返回单例
    public static HungrySingleton getInstance(){
        return  hungrySingleton;
    }
}
