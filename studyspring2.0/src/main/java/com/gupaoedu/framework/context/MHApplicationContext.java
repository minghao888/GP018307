package com.gupaoedu.framework.context;

import com.gupaoedu.framework.beans.config.MHBeanDefinition;
import com.gupaoedu.framework.beans.support.MHBeanDefinitionReader;
import com.gupaoedu.framework.beans.support.MHDefaultListableBeanFactory;
import com.gupaoedu.framework.core.MHBeanFactory;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: MingHao
 * @CreateDate: 10:04 2019/4/12
 * @Version: 1.0
 */
public class MHApplicationContext extends MHDefaultListableBeanFactory implements MHBeanFactory {

    /**
     * 配置文件路径数组
     * @return
     **/
    private String[] configlocations;
    /**
     * 读取和扫描配置文件对象
     */
    private MHBeanDefinitionReader reader;


    /**
     *  初始化获取配置文件来源，同时加载IOC
     * @author Mr.Ming
     * @date 2019/4/12 
     * @param configlocations
     **/
    public MHApplicationContext(String... configlocations) {
        this.configlocations = configlocations;
        //执行IOC
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * refresh() 整个spring开始工作的方法
     * @author Mr.Ming
     * @date 2019/4/12
     **/
    @Override
    public void refresh() throws Exception {
        //1.定位，根据MHApplicationContext对象的构造 定位配置文件
        reader = new MHBeanDefinitionReader(this.configlocations);
        //2.加载，加载配置文件，扫描相关的类，并将扫描的类封装成指定对象 MHBeanDefinition
        List<MHBeanDefinition> mhBeanDefinitions = reader.loadBeanDefinitions();
        //3.注册，把配置信息放到容器里面（伪IOC容器）
        doRegisterBeanDefinition(mhBeanDefinitions);
        //4.把不是延迟加载的类，需要初始化
        doAutowrited();

    }


    /**
     * 注册，把配置信息放到容器里面（伪IOC容器）
     *
     * 容器：super.beanDefinitionMap集合
     * @author Mr.Ming
     * @date 2019/4/12
     * @param mhBeanDefinitions
     * @return
     **/
    private void doRegisterBeanDefinition(List<MHBeanDefinition> mhBeanDefinitions) throws Exception{
        //for循环添加在伪IOC容器中
        for (MHBeanDefinition mhBeanDefinition : mhBeanDefinitions) {
            //判断当前工厂对象名称是否已存在，存在则抛出异常
            if(super.beanDefinitionMap.containsKey(mhBeanDefinition.getFactoryBeanName())){
                throw new RuntimeException("The" + mhBeanDefinition.getFactoryBeanName() + "is exists!");
            }
            //存储注册信息BeanDefinition 到 beanDefinitionMap集合中
            super.beanDefinitionMap.put(mhBeanDefinition.getFactoryBeanName(),mhBeanDefinition);
        }
        //IOC初始化完毕
    }


    /**
     * 将不是延迟加载的类，需要初始化
     * @author Mr.Ming
     * @date 2019/4/12
     **/
    private void doAutowrited() {
        //遍历所有存储注册信息集合，对所有封装对象进行判断
        for (Map.Entry<String, MHBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            //判断不是延迟加载 isLazyInit = false;
            if(!beanDefinitionEntry.getValue().isLazyInit()){
                //立即实例化
                getBean(beanName);
            }
        }
    }



    /**
     * 注入
     * DI 依赖注入，从这里开始，通过读取BeanDefinition中的信息
     * 然后，通过反射机制创建一个实例并返回
     *
     * Spring做法是，不会吧最原始的对象放出去，会用一个BeanWrapper来进行一次包装
     * 装饰器模式：
     *      1.保留原来的OOP关系
     *      2.需要对它进行亏站，增强（为了以后AOP打基础）
     * @author Mr.Ming
     * @date 2019/4/12
     * @param beanName
     * @return
     **/
    @Override
    public Object getBean(String beanName) {
        //将初始化和注入分开，方便嵌套注入

//        //1、初始化
//        instantiateBean(beanName,new GPBeanDefinition());
//        //class A{ B b;}
//        //class B{ A a;}
//        //先有鸡还是先有蛋的问题，一个方法是搞不定的，要分两次
//
//        //2、注入
//        populateBean(beanName,new GPBeanDefinition(),new GPBeanWrapper());

        return null;
    }





}
