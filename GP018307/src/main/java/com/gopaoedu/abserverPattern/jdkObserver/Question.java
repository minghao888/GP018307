package com.gopaoedu.abserverPattern.jdkObserver;

/**
 * 信息对象，实体类
 */
public class Question {
    //提问者
    private String userName;
    //内容
    private String context;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
