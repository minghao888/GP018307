package com.gopaoedu.strategyPattern.promotion;



/**
 * 策略模式  测试类
 *
 */
public class PromotionStrategyTest {

    /**
     * 直接指定活动对象，进行参加活动
     * @param args
     */
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = new PromotionActivity(new CashbackStrategy());
//        promotionActivity.excute();
//        PromotionActivity promotionActivity2 = new PromotionActivity(new CouponStrategy());
//        promotionActivity2.excute();
//    }

    /**
     * 指定活动策略的方式获取对象
     * @param args
     */
//    public static void main(String[] args) {
//        String promotionKey = "GROUPBUY";
//        //通过策略工厂获取指定的活动对象
//        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
//        //拿到活动券以后，参加活动
//        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
//        promotionActivity.excute();
//    }


    /**
     * 简单工厂模式进行测试 策略模式
     * @param args
     */
    public static void main(String[] args) {
        //指定参加活动的方式
        String promotionKey = "COUPON";
        PromotionActivity promotionActivity = null;
        //判断活动对象，进行对应的参加活动
        if("GROUPBUY".equals(promotionKey)){
            promotionActivity = new PromotionActivity(new GroupbuyStrategy());
        }else if("COUPON".equals(promotionKey)){
            promotionActivity = new PromotionActivity(new CouponStrategy());
        }else if("CASHBACK".equals(promotionKey)){
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }else if("EMPTY".equals(promotionKey)){
            promotionActivity = new PromotionActivity(new EmptyStrategy());
        }else {
            return;
        }
        promotionActivity.excute();
    }

}
