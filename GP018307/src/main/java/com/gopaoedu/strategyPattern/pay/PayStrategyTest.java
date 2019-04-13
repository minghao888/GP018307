package com.gopaoedu.strategyPattern.pay;

import com.gopaoedu.strategyPattern.pay.payport.PayStrategy;

/**
 *
 * 使用策略模式 模拟支付的策略
 */
public class PayStrategyTest {

    public static void main(String[] args) {
        // 创建订单，传入账户id  订单号   当前用户的金额
        Order order = new Order("123","12345466566454",20);
        PayResult pay = order.pay(PayStrategy.JD_PAY);
        //打印最终支付结果
        System.out.println(pay);
    }
}
