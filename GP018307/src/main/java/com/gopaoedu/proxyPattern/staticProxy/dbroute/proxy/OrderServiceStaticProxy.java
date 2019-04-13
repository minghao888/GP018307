package com.gopaoedu.proxyPattern.staticProxy.dbroute.proxy;

import com.gopaoedu.proxyPattern.staticProxy.dbroute.IOrderService;
import com.gopaoedu.proxyPattern.staticProxy.dbroute.Order;
import com.gopaoedu.proxyPattern.staticProxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;

/**
 * OrderService 的静态代理
 *
 *  可以进行AOP前后增强
 */
public class OrderServiceStaticProxy implements IOrderService {

    //1.定义OrderService对象
    IOrderService orderService = null;

    //2.构造获取实现对象
    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }


    //3.设置工具包，进行时间转换
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");



    //4.执行带代理模式，在抵用orderService,insert() 方法前后进行增强操作（选择数据库和重置数据）
    @Override
    public int createOrder(Order order){
        //前置增强
        Long time = order.getCreateTime();
        Integer dbReoute = Integer.valueOf(yearFormat.format(time));
        DynamicDataSourceEntity.set(dbReoute); //设置数据源
        System.out.println("静态代理类自动分配到【DB_"+dbReoute+"】数据源处理数据");
        //指定操作
        orderService.createOrder(order);

        //后置增强
        DynamicDataSourceEntity.restore();  //还原数据源

        return 0;
    }

}
