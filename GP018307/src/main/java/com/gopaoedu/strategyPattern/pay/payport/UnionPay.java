package com.gopaoedu.strategyPattern.pay.payport;

public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联";
    }

    @Override
    public double getMoney(String uid) {
        return 250;
    }
}
