package com.gopaoedu.abserverPattern.events.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 观察者，监听器
 */
public class EventLisenter {

    /**
     * 使用hashMap来存放注册的所有事件（存放所有观察者）
     */
    protected Map<String,Event> events = new HashMap<>();

    /***
     * 事件名称和一个对象来触发事件
     * @param eventType 触发的时间字符串
     * @param target 参数: 事件触发，要通知谁
     */
    public void addLisenter(String eventType,Object target){
        try {
            this.addLisenter(eventType,
                    target,
                    target.getClass().getMethod("on"+toUpperFirstCase(eventType),Event.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将事件存入到观察的包装类中，并且注册到map集合中
     * @param eventType
     * @param target
     * @param method
     */
    public void addLisenter(String eventType, Object target, Method method){
    this.events.put(eventType,new Event(target,method));
    }


    /**
     * 通过事件名称获取集合中的对象
     * @param trigger
     */
    protected void trigger(String trigger){
        //判断当前集合中是否存在此事件
        if(!this.events.containsKey(trigger)){
            return;
        }

        Event event = this.events.get(trigger);
        event.setTrigger(trigger);
        trigger(event);
    }

    //触发
    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        //发起回调
        if(event.getCallback() != null){
            try {
                //用反射调用它的回调函数
                event.getCallback().invoke(event.getTarget(),event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //逻辑处理的私有方法，首字母大写
    private String toUpperFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}
