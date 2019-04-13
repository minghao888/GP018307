package com.gopaoedu.strategyPattern.promotion;

/**
 * 优惠券
 */
public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPomotion() {
        System.out.println("领取优惠券,课程的价格直接减优惠券面值抵扣");
    }
}
