package com.gupaoedu.framework.context;

/**
 * @Description: 通过解耦方式获得IOC容器的顶层设计
 *              通过一个监听器去扫描所有的类，只要实现了此接口，
 *              将自动调用setApplicationContext()方法，从而将IOC容器注入到目标类中
 * @Auther: MingHao
 * @CreateDate: 10:10 2019/4/12
 * @Version: 1.0
 */
public interface MHApplicationContextAware {
    void setApplicationContext(MHApplicationContext applicationContext);
}
