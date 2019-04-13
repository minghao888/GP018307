package com.gopaoedu.strategyPattern.promotion;

/**
 * 优惠活动
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    /**
     * 参加/执行促销活动
     */
    public void excute(){
        promotionStrategy.doPomotion();
    }
}
