package com.gopaoedu.strategyPattern.pay.payport;

/**
 * 阿里支付宝
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public double getMoney(String uid) {
        return 352.8;
    }
}
