package com.gopaoedu.SingletonPattern.lazy;

import java.lang.reflect.Constructor;

/**
 * 静态内部类懒汉单例模式  测试
 */
public class LazyInnerClassSingletonPatternTest {

    public static void main(String[] args) {
        //获取内部类单例对象
//        LazyInnerClassSingletonPattern instance = LazyInnerClassSingletonPattern.getInstance();
//        LazyInnerClassSingletonPattern instance2 = LazyInnerClassSingletonPattern.getInstance();
//        LazyInnerClassSingletonPattern instance3 = LazyInnerClassSingletonPattern.getInstance();
//        System.out.println(instance);
//        System.out.println(instance2);
//        System.out.println(instance3);


        //通过反射测试静态内部类懒汉单例模式  两者再进行对比
        try {
            //1.获取对象的类类型
            Class<?> clazz = LazyInnerClassSingletonPattern.class;
            //获取构造
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            //私有构造强制访问
            c.setAccessible(true);
            //通过反射创建两个对象会报错，因为再内部类懒汉单例对象的私有构造做了对象是否存在的判断
            Object o1 = c.newInstance();
            Object o2 = c.newInstance();

            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o2 == o1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
