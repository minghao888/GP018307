package com.gupaoedu.framework.context.support;

/**
 * @Description: IOC容器的顶层设计
 * @Auther: MingHao
 * @CreateDate: 10:28 2019/4/12
 * @Version: 1.0
 */
public abstract class MHAbstractApplicationContext {
    /**
     * 抽象方法，提供给子类重写
     * @author Mr.Ming
     * @date 2019/4/12
     * @return
     **/
    public void refresh() throws Exception{}
}
