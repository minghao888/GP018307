package com.gopaoedu.decoratorPattern.battercake;

/**
 *
 * 装饰类 接口，用于给装饰类新增功能
 * 继承基础类的接口，进行拓展
 */
public abstract  class ABattercakeDecorator extends Battercake  {

    /**
     * 添加打包费用
     * @return
     */
    protected abstract int dabao();


}
