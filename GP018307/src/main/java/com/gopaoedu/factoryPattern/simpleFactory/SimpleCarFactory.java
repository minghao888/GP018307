package com.gopaoedu.factoryPattern.simpleFactory;

import com.gopaoedu.factoryPattern.Car;
import com.gopaoedu.factoryPattern.SedanCar;
import com.gopaoedu.factoryPattern.TruckCar;

/**
 * 简单汽车工厂
 *
 *   简单工厂的特点: 一个工厂搞定所有事情
 */
public class SimpleCarFactory {

    /**
     * 工厂方法，获得对应的卡车
     * @param name 定义标识，通过标识创建对应的对象
     * @return
     */
    public Car getCar(String name){
        if("SedanCar".equals(name)){
            return new SedanCar();
        }else if ("TruckCar".equals(name)){
            return new TruckCar();
        }
        return null;
    }

    /**
     * 工厂方法，获得对应的卡车
     * @param namepath 定义类的全路径，通过反射获取
     * @return
     */
    public Car getCar2(String namepath){
        try {
            Class<?> clazz = Class.forName(namepath);
            return (Car)clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * 工厂方法，获得对应的卡车
     * @param clazz 定义Car类的类类型，通过反射获取
     *        Class<? extends Car>：只要是继承 Car的子类的类类型都可以
     * @return
     */
    public Car getCar3(Class<? extends Car> clazz){
        try {
            return (Car)clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
