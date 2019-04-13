package com.gopaoedu.SingletonPattern.hungry;

/**
 * 恶汉静态单例模式
 */
public class HungryStaticSingleton {
    //1.私有构造
    private HungryStaticSingleton(){}

    //2.定义单例对象
    private static HungryStaticSingleton hungryStaticSingleton;

    //3.静态块创建单例对象
    static{
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    //4.返回单例
    public static HungryStaticSingleton getInstance(){

        return hungryStaticSingleton;
    }

}
