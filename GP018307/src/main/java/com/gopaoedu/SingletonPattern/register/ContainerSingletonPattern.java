package com.gopaoedu.SingletonPattern.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器缓存法的单例模式
 *  Spring中的做法，就是用这种注册式单例(容器缓存的写法)
 *  讲对象放入ConcurrentHashMap中，并进行加锁判断，不存在，就通过反射创建对象添加，存在，就直接获取对象
 */
public class ContainerSingletonPattern {
    //1.私有化构造
    private ContainerSingletonPattern(){}

    //2.定义线程安全的静态ConcurrentHashMap
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    /**
     * 3.返回需要获取对象的单例
     * @param className  类全路径
     * @return
     */
    public static Object getInstance(String className){
        //3.1先对集合加锁，避免多线程被同时拿到，ConcurrentHashMap是它本身线程安全，但是不能代表是集合线程安全
        synchronized (ioc){
            //3.2判断集合中是否存在当前类全路径的对象是否存在
            //不存在就进入创建
            if(!ioc.containsKey(className)){
                Object obj = null;
                try {
                    //通过反射创建对象
                    obj = Class.forName(className).newInstance();
                    //添加到集合
                    ioc.put(className,obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //返回实例化对象
                return obj;
            }else{  //存在，就直接获取
                return ioc.get(className);
            }
        }

    }
}
