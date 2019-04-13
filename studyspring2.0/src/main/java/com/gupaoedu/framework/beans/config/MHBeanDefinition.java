package com.gupaoedu.framework.beans.config;

import lombok.Data;

/**
 * @description: 存储注册信息
 * @Auther: MingHao
 * @CreateDate: 10:18 2019/4/12
 * @Version: 1.0
 */
@Data
public class MHBeanDefinition {
    /**
     * 类名 com....
     */
    private String beanClassName;
    /**
     * 是否延迟加载  不延迟：ioc初始化以后就加载  延迟：调用getbean()加载
     */
    private boolean lazyInit = false;
    /**
     * 类实例化以后存到工厂的类名
     */
    private String factoryBeanName;
}
