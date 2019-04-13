package com.gopaoedu.factoryPattern.factoyMethod;

import com.gopaoedu.factoryPattern.Car;

/**
 * 工厂方法模式(多态+多态)
 *      工厂方法模式特点：
 *          一个大工厂，分几个部门，
 *          部门里面再根据特性的不同，分为小部门
 */
public interface CarFactory {
    /**
     * 创建方法 （部门1）
     * @return
     */
    Car create();
}
