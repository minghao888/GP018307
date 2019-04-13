package com.gopaoedu.factoryPattern;

/**
 * 轿车
 */
public class SedanCar implements Car{
    @Override
    public void run() {
        System.out.println("轿车跑得贼快！");
    }

    @Override
    public void horn() {
        System.out.println("轿车鸣笛，路人礼让！");
    }


}
