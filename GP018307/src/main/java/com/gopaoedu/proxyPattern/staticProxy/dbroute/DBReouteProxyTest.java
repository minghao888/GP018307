package com.gopaoedu.proxyPattern.staticProxy.dbroute;

import com.gopaoedu.proxyPattern.staticProxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.gopaoedu.proxyPattern.staticProxy.dbroute.proxy.OrderServiceStaticProxy;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 多数据源代理
 */
public class DBReouteProxyTest {

    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
            Date date = sdf.parse("2019/02/25");
            order.setCreateTime(date.getTime());

            //使用静态代理调用
//            IOrderService iOrderService = new OrderServiceStaticProxy(new OrderService());
//            iOrderService.createOrder(order);


            //使用动态代理调用(强转)
            IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
            //使用动态代理调用(反射)
            Object  instance = new OrderServiceDynamicProxy().getInstance(new OrderService());
            Method createOrder = instance.getClass().getMethod("createOrder", new Class[]{Order.class});
            createOrder.invoke(instance,order);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
