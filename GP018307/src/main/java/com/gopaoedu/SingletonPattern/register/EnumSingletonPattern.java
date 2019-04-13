package com.gopaoedu.SingletonPattern.register;

/**
 * 枚举单例
 *     通常在通用API中使用
 */
public enum EnumSingletonPattern {
    //定义枚举
    INSTANCCE;

    //定义属性（此属性就是我们需要存放是值）
    private Object data = new Object();

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingletonPattern getInstance(){
        return INSTANCCE;
    }
}
