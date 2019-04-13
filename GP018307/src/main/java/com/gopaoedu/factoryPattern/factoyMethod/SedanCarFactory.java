package com.gopaoedu.factoryPattern.factoyMethod;

import com.gopaoedu.factoryPattern.Car;
import com.gopaoedu.factoryPattern.SedanCar;

/**
 * 汽车工厂
 */
public class SedanCarFactory implements CarFactory {

    @Override
    public Car create() {
        return new SedanCar();
    }
}
