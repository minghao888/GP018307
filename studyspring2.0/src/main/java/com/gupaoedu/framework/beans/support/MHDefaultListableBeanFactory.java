package com.gupaoedu.framework.beans.support;

import com.gupaoedu.framework.beans.config.MHBeanDefinition;
import com.gupaoedu.framework.context.support.MHAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Auther: MingHao
 * @CreateDate: 10:16 2019/4/12
 * @Version: 1.0
 */
public class MHDefaultListableBeanFactory extends MHAbstractApplicationContext{

    //存储注册信息的BeanDefinition
    public final Map<String, MHBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, MHBeanDefinition>();

}
