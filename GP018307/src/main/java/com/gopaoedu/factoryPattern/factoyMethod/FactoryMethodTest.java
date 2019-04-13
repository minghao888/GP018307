package com.gopaoedu.factoryPattern.factoyMethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        CarFactory sedanCarFactory = new SedanCarFactory();
        sedanCarFactory.create().horn();
        sedanCarFactory.create().run();


        CarFactory truckCarFactory = new TruckCarFactory();
        truckCarFactory.create().horn();
        truckCarFactory.create().run();


    }
}
