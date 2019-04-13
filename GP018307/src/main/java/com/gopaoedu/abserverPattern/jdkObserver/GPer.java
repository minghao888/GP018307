package com.gopaoedu.abserverPattern.jdkObserver;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * JDK提供的一种观察者的实现方式，被观察者（一对多中的一）
 * JDK中的被观察者必须继承Observable
 *  单例模式
 */
public class GPer extends Observable {

    //单例模式私有构造
    private GPer() {
        if(gper != null){
            throw new RuntimeException("单例对象，不可以创建多个实例！");
        }
    }

    private static GPer gper = null;

    //单例模式，静态获取单例对象方法
    public static GPer getInstance(){
        if (null == gper){
            gper = new GPer();
        }
        return gper;
    }

    //定义名称，当前单例对象用于被观察者的名称
    private String name ="GPer生态园";

    public String getName() {
        return name;
    }

    /**
     * 被观察者发表信息，或者发送消息（一对一或一对多）
     */
    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+"在"+this.name+"上提交了一个问题");
        /**
         *设置changed == true, 如果changed == false,
         *那么notifyObservers(question);方法就没有办法将信息发送给Observer接口的update方法
         */
        setChanged();
        //notifyObservers方法，最终调用了Observer接口的 update方法（点进去看底层代码）
        notifyObservers(question);
    }
}
