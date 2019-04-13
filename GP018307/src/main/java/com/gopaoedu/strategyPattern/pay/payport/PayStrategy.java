package com.gopaoedu.strategyPattern.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略管理
 *  管理所有的支付方式
 *
 *  使用单例+工厂+
 */
public class PayStrategy {

    //1.创建静态集合，存放所有的支付渠道
    private static Map<String,Payment> payStrategy = new HashMap<>();

    //2.定义所有的支付渠道
    public static final String ALI_PAY = "AliPay";  //支付宝
    public static final String WECHAT_PAY = "WechatPay";  //微信
    public static final String UNION_PAY = "UnionPay";  //银联
    public static final String JD_PAY = "JD_Pay";  //支付宝
    public static final String DEFAULT_PAY = "ALI_PAY";  //默认支付宝

    //3.静态块对所有支付渠道进行管理，存放到map容器中去
    static{
        payStrategy.put(ALI_PAY,new AliPay());
        payStrategy.put(WECHAT_PAY,new Wechat());
        payStrategy.put(UNION_PAY,new UnionPay());
        payStrategy.put(JD_PAY,new JDPay());
    }

    /**
     * 4.通过客户的选择方式，返回不同的支付渠道
     * @param payKey  客户选择的支付方式
     * @return
     */
    public static Payment getPayStrategy(String payKey){
        //判断客户选择的方式是否存在当前的支付渠道中
        if(payStrategy.containsKey(payKey)){
            //存在，就返回客户指定的渠道支付
            return payStrategy.get(payKey);
        }else{
            //不存在，就返回默认的支付渠道
            return payStrategy.get(ALI_PAY);
        }
    }

}
