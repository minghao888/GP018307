package com.gopaoedu.strategyPattern.promotion;

/**
 * 返现活动
 */
public class CashbackStrategy implements PromotionStrategy{
    @Override
    public void doPomotion() {
        System.out.println("返现促销,返回的金额转到支付宝账号");
    }
}
