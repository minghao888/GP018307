package com.gopaoedu.abserverPattern.jdkObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 老师类
 *
 * 观察者  （一对多中的多）
 *
 * 观察者必须实现  implements Observer
 */
public class Teacher implements Observer {

    public Teacher(String name) {
        this.name = name;
    }

    //定义当前类的名称，方便使用，意义不大
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param o  被观察的对象
     * @param arg 当前接收到的内容
     */
    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer)o;
        Question question = (Question)arg;
        System.out.println("==================");
        System.out.println(this.name+"老师,您好!");
        System.out.println("您收到一个来自：”"+question.getUserName()+"”的提问，问题内容如下：");
        System.out.println(question.getContext()+"提问者："+question.getUserName());

    }
}
