package com.gopaoedu.factoryPattern.simpleFactory;

import com.gopaoedu.factoryPattern.Car;
import com.gopaoedu.factoryPattern.SedanCar;
import com.gopaoedu.factoryPattern.TruckCar;

public class SimpleCarFactoryTest {

    public static void main(String[] args) {
        SimpleCarFactory simpleCarFactory = new SimpleCarFactory();

        /**
         * 传入标识符，通过判断返回对象
         */
//        Car sedanCar = simpleCarFactory.getCar("SedanCar");
//        sedanCar.horn();
//        sedanCar.run();
//        sedanCar = simpleCarFactory.getCar("TruckCar");
//        sedanCar.horn();
//        sedanCar.run();


        /**
         * 传入全路径，通过反射返回对象
         */
//        Car car2 = simpleCarFactory.getCar2("com.gopaoedu.factoryPattern.SedanCar");
//        car2.horn();
//        car2.run();
//        car2 = simpleCarFactory.getCar2("com.gopaoedu.factoryPattern.TruckCar");
//        car2.horn();
//        car2.run();


        /**
         * 传入类类型，通过返回返回对象
         * 注：Class<? extends Car> 类类型的要求，否则编译报错
         */
        Car car3 = simpleCarFactory.getCar3(SedanCar.class);
        car3.horn();
        car3.run();
        car3 = simpleCarFactory.getCar3(TruckCar.class);
        car3.horn();
        car3.run();



    }
}
