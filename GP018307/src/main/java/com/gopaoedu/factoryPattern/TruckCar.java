package com.gopaoedu.factoryPattern;

/**
 * 卡车
 */
public class TruckCar implements Car {

    @Override
    public void run() {
        System.out.println("卡车装货，跑得贼慢！");
    }

    @Override
    public void horn() {
        System.out.println("卡车声音贼大，贼吵！");
    }
}
