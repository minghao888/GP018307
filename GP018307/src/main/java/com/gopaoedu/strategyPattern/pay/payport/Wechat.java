package com.gopaoedu.strategyPattern.pay.payport;

/**
 * 微信
 */
public class Wechat extends Payment{
    @Override
    public String getName() {
        return "微信";
    }

    @Override
    public double getMoney(String uid) {
        return 300;
    }
}
