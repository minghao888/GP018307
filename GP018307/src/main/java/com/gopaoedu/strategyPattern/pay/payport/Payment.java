package com.gopaoedu.strategyPattern.pay.payport;

import com.gopaoedu.strategyPattern.pay.PayResult;

/**
 * 支付渠道以及支付
 *  抽象类，定义抽象方法，每个支付去掉名称和当前需要支付的金额
 */
public abstract class Payment {

    /**
     * 支付渠道名称
     * @return
     */
    public abstract String getName();

    /**
     * 当前订单需要支付的金额（金额是模拟的所以是固定的）
     * @param uid
     * @return
     */
    public abstract double getMoney(String uid);

    /**
     * 支付
     * @param uid
     * @param money
     * @return
     */
    public PayResult pay(String uid,double money){
        //判断金额
        if(getMoney(uid) > money){
            //支付中
            //.......
            //支付完毕，返回支付结果
             return new PayResult("500",getName()+":支付失败","余额不足");
        }else {
            //支付中
            //.......
            //支付完毕，返回支付结果
            return new PayResult("200",getName()+":支付成功","支付金额:"+money);
        }
    }

}
