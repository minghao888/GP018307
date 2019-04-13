package com.gopaoedu.delegatePattern.simpleDelegate;

/**
 * 简单委派模式
 */
public class SimpleDelegateTest {

    public static void main(String[] args) {
        /**
         * 测试，boss给经理安排两个不同的任务
         */
        new Boss().command("搭建架构");
        new Boss().command("维护数据库");
    }
}
