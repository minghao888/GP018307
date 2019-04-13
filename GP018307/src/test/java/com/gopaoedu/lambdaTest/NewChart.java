package com.gopaoedu.lambdaTest;

public interface NewChart {


    void test();

    public default void test2(){
        System.out.println("我是java新特性，默认方法，所有子类直接调用！");
    }
}
