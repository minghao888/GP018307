package com.gopaoedu.strategyPattern.pay;

import com.gopaoedu.strategyPattern.pay.payport.PayStrategy;
import com.gopaoedu.strategyPattern.pay.payport.Payment;

/**
 * 订单类
 */
public class Order {

    private String uid;  //用户id
    private String orderId; //订单id
    private double money; //用户账户金额


    public Order(String uid, String orderId, double money) {
        this.uid = uid;
        this.orderId = orderId;
        this.money = money;
    }

    //此时支付，减少了if....else    switch  语句的判断，直接从 支付渠道策略管理类中获取

    /**
     * 选择默认支付渠道
     * @return
     */
    public PayResult pay(){
        return this.pay(PayStrategy.DEFAULT_PAY);
    }

    /**
     * 指定支付渠道进行支付
     * @param payKey
     * @return
     */
    public PayResult pay(String payKey){
        //获取支付渠道
        Payment payStrategy = PayStrategy.getPayStrategy(payKey);
        System.out.println("支付中.....");
        System.out.println("选择："+payStrategy.getName()+"进行支付。");
        //返回支付结果给 结果对象
        PayResult pay = payStrategy.pay(this.uid, this.money);
        return pay;
    }

}


//1.测试类调用订单类，通过构造创建传入 用户ID，订单号，以及用户当前金额
//2.选择支付方式，并订单类调用支付接口
//3.通过支付方式后向 支付渠道策略管理类 获取支付的对象
//4.获取到支付对象以后，调用支付接口，并传入用户id和当前账户的金额,支付对象进行判断,当前账户余额是否足够支付
//5. 返回支付情况  toString()  打印