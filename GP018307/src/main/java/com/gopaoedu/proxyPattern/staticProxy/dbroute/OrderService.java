package com.gopaoedu.proxyPattern.staticProxy.dbroute;

public class OrderService implements IOrderService{

    //如果使用Spring应该是自动注入的
    OrderDao orderDao = new OrderDao();


    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService 调用orderDao创建订单！");
        orderDao.insert(order);
        return 0;
    }
}
