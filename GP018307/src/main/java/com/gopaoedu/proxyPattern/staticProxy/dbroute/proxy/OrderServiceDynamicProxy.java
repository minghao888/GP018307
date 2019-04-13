package com.gopaoedu.proxyPattern.staticProxy.dbroute.proxy;

import com.gopaoedu.proxyPattern.staticProxy.dbroute.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * OrderService 的动态代理
 * 动态代理，的代理类必须实现InvocationHandler
 * 进行前后增强处理
 */
public class OrderServiceDynamicProxy implements InvocationHandler {


    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    //1.实现定义代理对象 Object  动态代理是可以给所有对象进行代理的
    private Object proxyObj = null;

    //2.获取代理对象
    public Object getInstance(Object object){
        this.proxyObj = object;
        //获取类类型
        Class<?>  clazz = proxyObj.getClass();

        //对代理对象进行动态代理，后台创建新的代理对象，进行返回
        //这句话就是动态代理的核心
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     * 动态代理的执行方法，可以进行前后增强处理
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //传入参数，前置判断
        befor(args[0]);
        //调用目标类的指定接口方法
        Object object = method.invoke(proxyObj, args);
        //后置增强
        after();

        return object;
    }

    private void after() {
        System.out.println("Proxy after method");
        //还原成默认的数据源
        DynamicDataSourceEntity.restore();
    }

    //object 应该是订单对象Order
    private void befor(Object object) {
        try {
            //进行数据源的切换
            System.out.println("Proxy before method");

            //约定优于配置
            //前置增强
            Long time = (Long) object.getClass().getMethod("getCreateTime").invoke(object);
            Integer dbReoute = Integer.valueOf(yearFormat.format(time));
            DynamicDataSourceEntity.set(dbReoute); //设置数据源
            System.out.println("静态代理类自动分配到【DB_"+dbReoute+"】数据源处理数据");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
