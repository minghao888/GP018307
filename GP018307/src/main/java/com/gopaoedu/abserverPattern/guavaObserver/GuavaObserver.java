package com.gopaoedu.abserverPattern.guavaObserver;

import com.google.common.eventbus.Subscribe;

/**
 * 使用guava jar包实现观察者模式
 */
public class GuavaObserver {

    /**
     * 使用注解或者被观察者发送的信息(必须引入guava jar包)
     */
    @Subscribe
    public void getSubscribe(UserModel userModel){
        System.out.println("今天参加学习的学员为："+userModel.getUserName());
        System.out.println("年龄为："+userModel.getAge());
        System.out.println("学习内容为："+userModel.getContext());
    }

    /**
     * 是根据@Subscribe注解和参数类型决定传参，多个方法参数类型完全一直，那么就会被同时调用
     * @param userModel
     */
    @Subscribe
    public void gettest(UserModel userModel){
        System.out.println("今天参加学习的学员为："+userModel.getUserName());
        System.out.println("年龄为："+userModel.getAge());
        System.out.println("学习内容为："+userModel.getContext());
    }

    /**
     *
     * @param str
     */
    @Subscribe
    public void gettest(String str){
        System.out.println("今天参加学习的学员为："+str);
    }
}
