package com.gopaoedu.factoryPattern.abstractFactory;

/**
 * java课程小工厂
 */
public class JavaCourseFactory implements CourseFactory{

    /**
     * java笔记类型
     * @return
     */
    @Override
    public INote creatINote() {
        return new JavaNote();
    }

    /**
     * java录制类型
     * @return
     */
    @Override
    public IVideo createIVdieo() {
        return new JavaVideo();
    }
}
