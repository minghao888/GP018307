package com.gupaoedu.mvcframework.v2.servlet;

import com.gupaoedu.mvcframework.annotation.MHAutowired;
import com.gupaoedu.mvcframework.annotation.MHController;
import com.gupaoedu.mvcframework.annotation.MHRequestMapping;
import com.gupaoedu.mvcframework.annotation.MHService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 模拟springMVC中的dispacherServlet
 * 对初始化容器进行加载，对前端请求执行相应的方法
 */
public class MHDispacherServlet extends HttpServlet{

    /**
     *  保存application.properties配置文件钟得内容
     */
    private Properties properties = new Properties();
    /**
     * 保存所有扫描的类名
     */
    private List<String> classNames = new ArrayList<String>();
    /**
     * 传说中的IOC容器，存放类名和实例化出来的对象
     */
    private Map<String,Object> ioc = new HashMap<String,Object>();

    /**
     * 保存url和Method的一对一映射关系
     */
    private Map<String,Method> handlerMapping = new HashMap<String,Method>();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            this.doDispach(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定，调用
     * @param req
     * @param resp
     */
    private void doDispach(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取绝对路径
        String url = req.getRequestURI();
        //获取相对路径
        String contextPath = req.getContextPath();

        url = url.replaceAll(contextPath,"").replaceAll("/+","/");

        //判断请求的url在handlermapping中不存在
        if(!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 not found!!!");
        }
        //获取请求的方法
        Method method = this.handlerMapping.get(url);

        /**
         * 获取到类的名称，通过当前请求的方法
         * 然后去IOC容器中获取对象
         * 类名首字母小写
         */
        String simpleName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());

        //获取前台传入的所有参数，每个参数都是一个数组（有可能同一个参数有个多：name="ss"&name="ff"）
        Map<String,String[]> parameterMaps = req.getParameterMap();

        //获取方法的形参类型
        Class<?>[] parameterTypes = method.getParameterTypes();

        method.invoke(this.ioc.get(simpleName),req,resp,parameterMaps.get("name")[0]);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件、
            //通过名称，得到真正的配置文件
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        doLoadConfig(contextConfigLocation);

        //2.扫描相关的注解类（controller，service,dao 层） 配置文件中会指定扫描的路径（下面的所有类）
        String scanPackage = this.properties.getProperty("scanPackage");   //通过key获取Properties对象中的值
        doScanner(scanPackage);
        //3.初始化扫描到的类，并将它们放到IOC容器中（实例化容器）
        doInstanceIOC();
        //4.完成依赖注入（给IOC容器中的对象里面的属性）
        doAutoWired();
        //5.初始化HandlerMapping（Controller请求的映射）
        initHandlerMapping();
    }

    /**
     * 初始化url和method一对一关系映射
     */
    private void initHandlerMapping() {
        //判断为空，直接返回
        if(this.ioc.isEmpty()){return;}
        //遍历，判断ioc容器中是否存在Controller层的注解，加入到handlerMapping中
        for (Map.Entry<String, Object> entry : this.ioc.entrySet()) {
            //获取当前对象的类类型，进行判断
            Class<?> clazz = entry.getValue().getClass();
            //判断当前对象中不存在@MHController注解，就返回继续循环
            if(!clazz.isAnnotationPresent(MHController.class)){continue;}

            //定义url路径
            String baseUrl = "";
            //判断Controller类上面是否存在Requestmapping注解
            if(clazz.isAnnotationPresent(MHRequestMapping.class)){
                //获取路径@MHRequestmapping("/user")
                MHRequestMapping request = clazz.getAnnotation(MHRequestMapping.class);
                baseUrl = "/"+request.value();
            }

            //遍历所有的public方法，寻找方法上面的@MHRequestMapping
            for (Method method : clazz.getMethods()) {
                //判断存在Requestmapping注解
                if(method.isAnnotationPresent(MHRequestMapping.class)){
                    //获取路径@MHRequestmapping("/add")
                    MHRequestMapping request = method.getAnnotation(MHRequestMapping.class);
                    //路径拼接获取最终路径，并且将多余的“/” 转为一个“/”
                    String url  =(baseUrl +"/"+ request.value()).replaceAll("/+","/");

                    //将请求的url和调用的method方法
                    this.handlerMapping.put(url,method);

                    System.out.println("mapping:"+url+","+method);

                }
            }

        }

    }

    /**
     * 自动依赖注入
     * 给IOC容器中的对象中的属性对象赋值
     */
    private void doAutoWired() {
        //判断ioc容器为null，就直接返回
        if(this.ioc.isEmpty()){return;}

        //遍历ioc容器
        for (Map.Entry<String, Object> obj : this.ioc.entrySet()) {
            /**
             * 注入类的所有属性对象，不管是private,public,protected
             *  Declared 所有的，特定的 字段，包括private/protected/default
             *  正常来说，普通的OOP编程只能拿到public的属性
             */
            Field[] fields = obj.getValue().getClass().getDeclaredFields();
            //遍历当前对象中的所有对象属性（加@Autowired注解的）
            for (Field field : fields) {
                //判断当前属性没有添加自动注入的注解，就不进行容器注入
                if(!field.isAnnotationPresent(MHAutowired.class)){continue;}
                //拿到当前注解的对象
                MHAutowired autowired = field.getAnnotation(MHAutowired.class);
                //判断当前注解没有自定义beanName，就默认根据类型注入
                String beanName = autowired.value().trim();

                //判断为null,就获取类型名称
                if("".equals(beanName)){
                    //获取类型名称
                    beanName = field.getType().getName();
                }

                //强吻，就是修饰符是public以外的，
                // 只要添加了注解@MHAutowired都需要进行赋值
                field.setAccessible(true);


                /**
                 * 使用反射机制，给动态字段赋值
                 * 参数一：IOC的对象
                 * 参数二：DI注入的对象
                 *  他们都是放在IOC容器中的，所有有时候容易搞混淆
                 */
                try {
                    field.set(obj.getValue(),this.ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }

        }

    }

    /**
     * 初始化扫描到的类，并将它们放到IOC容器中（实例化容器）
     * 初始化，为DI(容器注入)做准备
     */
    private void doInstanceIOC() {
        //判断，存储扫描类的集合为null，那么就直接返回
        if(this.classNames.isEmpty()){return;}

        try {
            //遍历所有注解扫描的类
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);

                /**
                 * 判断添加注解的类才会进行初始化
                 * 此项目暂时仅仅之判断@MHController  @MHService
                 *
                 * clazz.isAnnotationPresent(MHController.class)   判断当前类中是否添加了指定的注解
                 */
                if(clazz.isAnnotationPresent(MHController.class)){
                    Object instance = clazz.newInstance();
                    //获取类名（单独类名）
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    //将类名和实例化对象存入ioc容器中
                    this.ioc.put(beanName,instance);
                }else if(clazz.isAnnotationPresent(MHService.class)){
                    //1.自定义的beanName
                    MHService service = clazz.getAnnotation(MHService.class);
                    //得到自定义的类名（例如：@Service("userSer")）
                    String beanName = service.value();

                    //2.默认类名首字母小写
                    if("".equals(beanName.trim())){   //判断自定义类名为空
                        //就赋值默认类名
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    this.ioc.put(beanName,instance);
                    
                    //3.根据类型自动赋值，投机取巧的方式（通过当前接口类的所有实现类）
                    for (Class<?> i : clazz.getInterfaces()) {
                        //判断当前类名是否已经存在ioc容器中，存在就抛出异常
                        if(this.ioc.containsKey(i.getName())){
                            throw new Exception("The “" + i.getName() + "” is exists!!");
                        }
                        //不存在，添加到ioc容器中
                        this.ioc.put(i.getName(),instance);
                    }
                }else{
                    continue;
                }




            }
        }catch (Exception e){
            e.printStackTrace();
        }






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



    /**
     * 扫描出相关的注解类
     * @param scanPackage
     */
    private void doScanner(String scanPackage) {
        //获取定义扫描的包路径路径，转换文件路径，并将“.” 替换为“/”
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        //获取路径文件夹
        File classpath = new File(url.getFile());
        //遍历当前文件夹下面的所有文件（递归）
        for (File file : classpath.listFiles()) {
            //判断是文件夹，就递归
            if(file.isDirectory()){
                doScanner(scanPackage+"."+file.getName());
            }else{  //不是文件夹，是文件
                //如果文件不是以.class结尾的，就直接continue    endsWith(".calss") : 判断是否以指字符串结尾
                if(!file.getName().endsWith(".class")){continue;}
                //获取类的全路径
                String className = scanPackage + "." + file.getName().replaceAll(".class", "");
                this.classNames.add(className);
            }
        }


    }

    /**
     * 1.加载配置文件
     * @param contextConfigLocation
     */
    private void doLoadConfig(String contextConfigLocation) {
        /**
         * 直接从类路径下，找到Spring主配置文件所在的路径
         * 并使用流的方式读取
         * 存放到properties对象中
         *
         * 相对于scanPackage=com.gupaoedu.demo 从文件中保存到了内存中
         */
        InputStream contextFis = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            this.properties.load(contextFis);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(contextFis != null){
                    contextFis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}


