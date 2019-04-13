package com.gopaoedu.strategyPattern.promotion;

/**
 * 无优惠
 */
public class EmptyStrategy implements PromotionStrategy{
    @Override
    public void doPomotion() {
        System.out.println("不打折，按照原价格执行");
    }
}
