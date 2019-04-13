package com.gopaoedu.decoratorPattern.battercake;

/**
 * 基础抽象类/接口类都可以
 */
public abstract class Battercake {
    //主角，煎饼
    protected abstract String getMsg();
    //价格
    protected abstract int getPrice();
}
