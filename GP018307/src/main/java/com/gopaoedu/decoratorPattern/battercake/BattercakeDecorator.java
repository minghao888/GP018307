package com.gopaoedu.decoratorPattern.battercake;

/**
 * 装饰器模式，主类
 * 此类为装饰器的主类
 *
 * 装饰类
 *
 * 继承装饰器的抽象类（ABattercakeDecorator）（装饰器抽象类又继承了Battercake）
 *
 */
public abstract class BattercakeDecorator extends ABattercakeDecorator {

    /**
     * 定义接口父类
     *  //静态代理，委派
     */
    private Battercake battercake;    //主类定义父类接口即可，副类继承主类后直接使用

    /**
     * 通过构造，将原有的 Battercake 对象传入，赋值给当前对象，
     * 使得当前Battercake对象有了之前的所有功能
     * @param battercake
     */
    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    /**
     * 当前结果，使用父类的结果（也就是构造器传入的对象）
     * @return
     */
    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }


    /**
     * 当前结果，使用父类的结果（也就是构造器传入的对象）
     * @return
     */
    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }

    /**
     * 打包费
     * @return
     */
    @Override
    protected int dabao() {
        return 5;
    }
}
