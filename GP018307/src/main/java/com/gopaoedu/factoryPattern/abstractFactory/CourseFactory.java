package com.gopaoedu.factoryPattern.abstractFactory;

/**
 * 抽象工厂
 *     1.工厂里面存在很多小工厂
 *     2.工厂里面存在很多生产各种类型的产品（大类）
 *      2.1小工厂里面也生产各种类型的产品（小类）
 *      2.2小类型里面为实际操作
 *
 *      注意：抽象工厂可一直往下工厂，最后一层为实际操作
 */

/**
 * 课程工厂
 */
public interface CourseFactory {
    /**
     * 课程工厂的笔记类型
     * @return
     */
    INote creatINote();

    /**
     * 课程工厂的视频类型
     * @return
     */
    IVideo createIVdieo();

}

























