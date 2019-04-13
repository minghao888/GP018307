package com.gopaoedu.SingletonPattern.lazy;

/**
 * 静态内部类懒汉单例模式
 */
public class LazyInnerClassSingletonPattern {

    //1.私有构造，并判断当前单例是狗存在，避免被反射出过多个实例
    private LazyInnerClassSingletonPattern(){
        //判断内部类对象是否已经存在，因为getInstance()最终的是InnerHoder.LAZY 内部类的对象
        if(InnerHoder.LAZY !=null){
            throw new RuntimeException("单例对象，不允许创建多个实例！");
        }
    }

    /**
     * 2.静态内部类  初始化的时候不会被加载，调用的时候才会被加载
     */
    private static class InnerHoder{
        private static final LazyInnerClassSingletonPattern LAZY = new LazyInnerClassSingletonPattern();
    }

    //3.返回单例
    public static LazyInnerClassSingletonPattern getInstance(){
        /**
         * 第一次调用的时候才会去加载内部类中的对象进行创建，
         * 返回内部类的静态常量对象
         */
        return InnerHoder.LAZY;
    }

}
