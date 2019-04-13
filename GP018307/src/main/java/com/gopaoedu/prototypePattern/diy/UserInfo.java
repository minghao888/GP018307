package com.gopaoedu.prototypePattern.diy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义深克隆  实现序列化接口
 */
public class UserInfo implements Cloneable, Serializable {

    private static final long SerialVersionUID = 1L;

    public UserInfo() {
        this.name = "zhangsan";
        this.sex = "nan";
        this.height = 180;
        this.weight = 60;
        this.list = new ArrayList<>();
    }

    /**
     * 克隆自己
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        UserInfo userInfo = null;
        userInfo = (UserInfo)super.clone();
        return userInfo;
    }

    private String name;
    private String sex;
    private int height;
    private int weight;

    private List<?> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }






}
