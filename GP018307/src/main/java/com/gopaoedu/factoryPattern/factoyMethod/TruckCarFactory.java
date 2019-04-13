package com.gopaoedu.factoryPattern.factoyMethod;

import com.gopaoedu.factoryPattern.Car;
import com.gopaoedu.factoryPattern.TruckCar;

/**
 * 卡车工厂
 */
public class TruckCarFactory implements CarFactory {

    @Override
    public Car create() {
        return new TruckCar();
    }
}
