package com.gopaoedu.abserverPattern.jdkObserver;

import javax.management.Query;

/**
 * JDK观察者模式 测试类
 */
public class ObserverTest {

    public static void main(String[] args) {
        //获取被观察者对象
        GPer gper = GPer.getInstance();

        /**
         * 创建此次被观察要发布的信息
         */
        Question question = new Question();
        question.setUserName("张三");
        question.setContext("设计模式的使用场景");

        /**
         * 创建接收者（实际可能去了数据库）
         */
        Teacher mic = new Teacher("mic");
        Teacher tom = new Teacher("tom");
        //指定被观察者将信息发送给哪一个观者着
        gper.addObserver(tom);
        gper.addObserver(mic);
        //调用被观察者对象中发送信息的方法
        gper.publishQuestion(question);

    }
}
