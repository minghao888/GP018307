package com.gopaoedu.proxyPattern.staticProxy.dbroute.db;

/**
 * ThreadLocal线程内单例模式（存放多数据源）
 *      作用：切换多数据源
 */
public class DynamicDataSourceEntity {

    //1.定义默认数据源
    public final static String DEFAULT_SOURCE = null;

    //2.创建Threadlocal线程内单例
    private final static ThreadLocal<String> local = new ThreadLocal<>();

    //3.单例模式的私有构造
    public DynamicDataSourceEntity() {
    }

    //4.定义获取当前线程单例的方法
    public static String get(){
        return local.get();
    }

    //5.重置为默认数据源
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }


    //多数据库选择
    //DB_2017 数据库
    //DB_2018 数据库
    //DB_2019 数据库

    //6.设置数据源
    public static void set(String source){
        local.set(source);
    }

    //7.设置数据源2
    public static void set(int year){
        local.set("DB_"+year);
    }

}
