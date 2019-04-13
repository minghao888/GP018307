package com.gopaoedu.SingletonPattern.lazy;

import com.gopaoedu.SingletonPattern.ExectorThread;
import com.gopaoedu.SingletonPattern.hungry.HungrySingleton;
import com.gopaoedu.SingletonPattern.hungry.HungryStaticSingleton;

import java.lang.reflect.Constructor;

/**
 * 懒汉模式的测试方法
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        //多线程测试懒汉单例
        Thread thread = new Thread(new ExectorThread());
        thread.start();
        Thread thread2 = new Thread(new ExectorThread());
        thread2.start();
        Thread thread3 = new Thread(new ExectorThread());
        thread3.start();


        //获取单例对象
        Object o1 = LazySingletonPattern.getInstance();

        //通过反射测试懒汉单例模式  两者再进行对比
        try {
            //1.获取对象的类类型
            Class<?> clazz = LazySingletonPattern.class;
            //获取构造
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
            //私有构造强制访问
            declaredConstructor.setAccessible(true);
                //通过反射创建对象会报错，因为再懒汉单例对象的私有构造做了对象是否存在的判断
            Object o2 = declaredConstructor.newInstance();

            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o2 == o1);
        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
