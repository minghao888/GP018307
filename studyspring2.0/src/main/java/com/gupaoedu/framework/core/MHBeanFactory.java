package com.gupaoedu.framework.core;


/**
 * @Description: 单例工厂的顶层设计
 * @Auther: MingHao
 * @CreateDate: 9:45 2019/4/12
 * @Version: 1.0
 */
public interface MHBeanFactory {

    /**
     * 根据bbeanName从IOC容器中获取一个实例Bean
     * @author Mr.Ming
     * @date 2019/4/12
     * @param beanName
     * @return
     **/
    Object getBean(String beanName);
}
