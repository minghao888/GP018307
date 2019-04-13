package com.gopaoedu.templatePattern.courceTemplate;

/**
 * java课程，继承课程的模板类
 */
public class JavaCource extends NetWorkCource{


    public JavaCource(boolean needHomeWork) {
        this.needHomeWork = needHomeWork;
    }

    //定义是否需要完成课后作业
    private boolean needHomeWork = false;

    @Override
    protected void checkHomeWork() {
        System.out.println("检查java的课后作业");
    }

    @Override
    protected boolean needHomeWork() {
        return this.needHomeWork;
    }
}
