package com.gopaoedu.SingletonPattern.hungry;

/**
 * 恶汉模式的测试方法
 */
public class HungrySingletonTest {

    public static void main(String[] args) {
        //测试恶汉单例
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        HungrySingleton instance3 = HungrySingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance3);



        //测试恶汉静态单例
        HungryStaticSingleton staticSingleton = HungryStaticSingleton.getInstance();
        HungryStaticSingleton staticSingleton2 = HungryStaticSingleton.getInstance();
        HungryStaticSingleton staticSingleton3 = HungryStaticSingleton.getInstance();
        System.out.println(staticSingleton);
        System.out.println(staticSingleton2);
        System.out.println(staticSingleton3);

    }
}
