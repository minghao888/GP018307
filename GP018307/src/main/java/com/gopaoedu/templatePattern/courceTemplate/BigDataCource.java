package com.gopaoedu.templatePattern.courceTemplate;

public class BigDataCource extends NetWorkCource {

    private boolean needHomeWork = false;
    public BigDataCource(boolean needHomeWork) {
        this.needHomeWork = needHomeWork;
    }

    @Override
    protected boolean needHomeWork() {
        return this.needHomeWork;
    }

    @Override
    protected void checkHomeWork() {
        System.out.println("检查大数据课后作业");
    }
}
