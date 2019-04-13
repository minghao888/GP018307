package com.gopaoedu.factoryPattern.abstractFactory;

/**
 * python课程的小工厂
 */
public class PythonCourseFactory implements CourseFactory{
    /**
     * Python笔记类型
     * @return
     */
    @Override
    public INote creatINote() {
        return new PythonNote();
    }

    /**
     * Python录制类型
     * @return
     */
    @Override
    public IVideo createIVdieo() {
        return new PythonVideo();
    }
}
