package com.gupaoedu.framework.beans.support;

import com.gupaoedu.framework.beans.config.MHBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description: 对限定的对象进行定位和加载
 * @Auther: MingHao
 * @CreateDate: 10:58 2019/4/12
 * @Version: 1.0
 */
public class MHBeanDefinitionReader {

    /**
     * 存放扫描以后类的全路径（类名）
     */
    private List<String> registyClasses = new ArrayList<String>();

    /**
     * 定义加载的Properties配置文件
     */
    Properties config = new Properties();

    /**
     * 定义需要扫描的配置文件路径
     */
    private final String SCAN_PACKAGE = "scanPackage";
    
    
    /**
     * 1.构造函数获取配置信息
     * @author Mr.Ming
     * @date 2019/4/12 
     * @param configlocations
     * 注：获取资源文件需要为流文件的时候就使用getResourceAsStream(),
     *    如果仅仅获取资源文件，则可以用getResource()。
     *    jar包下的资源文件必须用getResourceAsStream()，否则出现空指针
     **/
    public MHBeanDefinitionReader(String... configlocations) {
        //通过url定位找到其对应的文件，然后转为流文件
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configlocations[0].replace("classpath:", ""));
        //将流文件转为Properties对象
        try {
            this.config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //扫描包
        doScanner(this.config.getProperty(SCAN_PACKAGE));

    }

   

    /**
     * 2.扫描配置文件路径下面的所有类
     * @param scanPackage 扫描的路径
     *                    
     * 注：获取资源文件需要为流文件的时候就使用getResourceAsStream(),
     *    如果仅仅获取资源文件，则可以用getResource()。
     *    jar包下的资源文件必须用getResourceAsStream()，否则出现空指针
     */
    private void doScanner(String scanPackage){
        //获取url
        URL resource = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        //url转换为file文件
        File classPath = new File(resource.getFile());
        //遍历当前文件目录的所有文件
        for (File file : classPath.listFiles()) {
            //判断当前是一个文件夹
            if(file.isDirectory()){
                doScanner(scanPackage+"."+file.getName());
            }else{
                //判断当前文件是不是.class文件
                if(!file.getName().endsWith(".class")){
                    continue;
                }
                //需要被实例化的所有类的全类名
                String className = scanPackage +"."+file.getName().replaceAll(".class","");
                //加入集合中
                this.registyClasses.add(className);
            }
        }
    }

    /**
     * 定义获取配置文件的方法，有可能其他地方会用到
     * @author Mr.Ming
     * @date 2019/4/12
     * @return
     **/
    public Properties getConfig(){
        return this.config;
    }


    /**
     * 3.把配置文件扫描到的信息转化为MHBeandefinition对象，便于以后IOC操作方便
     * @author Mr.Ming
     * @date 2019/4/12
     * @return 返回扫描包以后需要实例化的对象的封装信息：MHBeanDefinition对象
     **/
    public List<MHBeanDefinition> loadBeanDefinitions(){
        //创建集合，存储封装对象
        List<MHBeanDefinition> result = new ArrayList<MHBeanDefinition>();

        try {
            //遍历所有扫描类集合，进行封装
            for (String className : this.registyClasses) {
                Class<?> beanClass = Class.forName(className);
                //判断当前是接口，就不能实例化，用它的实现类来实例化
                if(beanClass.isInterface()){continue;}

                /**
                 * Spring中的@Service注解是一个接口对应一个实现类，不可能一个接口对应多个实现类
                 * IOC中 获取所有的接口只是拿到了接口的名称，把它的名称作为key，方便后期自动注入
                 * 在DI：自动注入中 不管是接口还是对象名、首字母小写、自定义名称、接口，都是指定的同一个实现类（普通类对象）
                 *
                 */

                /**
                 * beanName有三种情况:
                 * 1、默认是类名首字母小写
                 * 2、自定义名字
                 * 3、接口注入
                 *
                 * 以下是：1、默认是类名首字母小写
                 */
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()),beanClass.getName()));

                /**
                 * 获取当前类的所有接口类，并封装成对象（取所有的接口只是拿到了接口的名称，把它的名称作为key，方便后期自动注入）
                 * 以下是：3、接口注入（仅仅是封装对象，还没有到注入）
                 */
                for (Class<?> i : beanClass.getInterfaces()) {
                    result.add(doCreateBeanDefinition(i.getName(),beanClass.getName()));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }


    /**
     * 对象封装
     * @author Mr.Ming
     * @date 2019/4/12
     * @param factoryBeanName 类名
     * @param beanClassName 类全路径名
     * @return 返回封装好的对象
     **/
    public MHBeanDefinition doCreateBeanDefinition(String factoryBeanName,String beanClassName){
        MHBeanDefinition beanDefinition = new MHBeanDefinition();
        //设置对象名称
        beanDefinition.setBeanClassName(beanClassName);
        //设置工厂对象名称
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }


    //如果类名本身是小写字母，确实会出问题
    //但是我要说明的是：这个方法是我自己用，private的
    //传值也是自己传，类也都遵循了驼峰命名法
    //默认传入的值，存在首字母小写的情况，也不可能出现非字母的情况

    //为了简化程序逻辑，就不做其他判断了，大家了解就OK
    //其实用写注释的时间都能够把逻辑写完了
    private String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        //之所以加，是因为大小写字母的ASCII码相差32，
        // 而且大写字母的ASCII码要小于小写字母的ASCII码
        //在Java中，对char做算学运算，实际上就是对ASCII码做算学运算
        chars[0] += 32;
        return String.valueOf(chars);
    }

    //4.

}
