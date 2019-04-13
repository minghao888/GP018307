package com.gopaoedu.abserverPattern.guavaObserver;

import com.google.common.eventbus.EventBus;

/**
 * 使用guava实现观察者模式  测试
 */
public class GuavaObserverTest {

    public static void main(String[] args) {
        //创建消息总线
        EventBus eventBus = new EventBus();
        //创建发送对象
        GuavaObserver guavaObserver = new GuavaObserver();
        GuavaObserver2 guavaObserver2 = new GuavaObserver2();

        //创建需要发送的消息
        UserModel userModel = new UserModel();
        userModel.setUserName("张三");
        userModel.setPassword("123456");
        userModel.setAge("25");
        userModel.setContext("今天学习了使用guava实现观察者模式！");

        //将消息发送的对象注册到消息总线里面
        eventBus.register(guavaObserver);
        eventBus.register(guavaObserver2);

        //发送消息，并传参
        //只要参数类型是 UserModel  不管有多少个@Subscribe注解的方法，都会被同时调用
        eventBus.post(userModel);
        //只会调用参数是String 的 @Subscribe注解的方法
        eventBus.post("zhangsan");

    }

}
