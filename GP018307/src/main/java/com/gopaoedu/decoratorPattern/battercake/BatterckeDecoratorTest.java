package com.gopaoedu.decoratorPattern.battercake;

/**
 * 装饰器模式，测试类
 */
public class BatterckeDecoratorTest {

    public static void main(String[] args) {
        /**
         * 创建煎饼对象
         */
        Battercake Battercake = new BaseBattercake();
        System.out.println("购买了："+Battercake.getMsg() +",一共花费："+Battercake.getPrice());

        /**
         * 给煎饼加一个鸡蛋
         */
        //把煎饼传入
        ABattercakeDecorator aBattercakeDecorator = new EggDecorator(Battercake);
        System.out.println("购买了："+aBattercakeDecorator.getMsg() +
                ",一共花费："+aBattercakeDecorator.getPrice() +
                ",打包费："+aBattercakeDecorator.dabao());
        /**
         * 再给加了鸡蛋的煎饼加一个香肠
         */
        //把煎饼+鸡蛋传入
        aBattercakeDecorator = new SausageDecorator(aBattercakeDecorator);
        System.out.println("购买了："+aBattercakeDecorator.getMsg() +
                ",一共花费："+aBattercakeDecorator.getPrice() +
                ",打包费："+aBattercakeDecorator.dabao());

    }
}
