package com.gopaoedu.strategyPattern.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * 促销策略类
 *     销策 +工厂+单例  模式
 */
public class PromotionStrategyFactory {

    //1.定义静态map容器项目启动，加载所有策略对象到容器中
    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    //2.使用内部类，定义所有活动策略的实现类的kay
    private interface PromotionKay{
        String COUPON = "COUPON";    //优惠券
        String CASHBACK = "CASHBACK";  //返现活动
        String GROUPBUY = "GROUPBUY";  //拼团优惠
        String EMPTY = "EMPTY";  //不打折  默认
    }

    //3.静态块加载所有活动策略类
    static{
        PROMOTION_STRATEGY_MAP.put(PromotionKay.COUPON,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKay.CASHBACK,new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKay.GROUPBUY,new GroupbuyStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKay.EMPTY,new EmptyStrategy());
    }

    /**
     * 4.获取通过选择进行返回对应的活动方案
     * @param promotionKay  传入选择的活动方案
     * @return
     */
    public static PromotionStrategy getPromotionStrategy(String promotionKay){
        //有对应的活动方案，就返回对应的活动方案
        if(PROMOTION_STRATEGY_MAP.containsKey(promotionKay)){
            return PROMOTION_STRATEGY_MAP.get(promotionKay);
        }else{   //没有对象的活动方案就不打折，按照原价来
            return PROMOTION_STRATEGY_MAP.get(PromotionKay.EMPTY);
        }
    }


}
