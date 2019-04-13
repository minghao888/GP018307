package com.gopaoedu.strategyPattern.pay.payport;

public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    public double getMoney(String uid) {
        return 120.5;
    }
}
