package com.gopaoedu.decoratorPattern.battercake;

/**
 * 具体实现类：子类，继承父类，并重写抽象方法
 */
public class BaseBattercake extends Battercake {

    /**
     * 主要商品名称
     * @return
     */
    @Override
    protected String getMsg() {
        return "武大郎烧饼";
    }

    /**
     * 价格
     * @return
     */
    @Override
    protected int getPrice() {
        return 8;
    }
}
