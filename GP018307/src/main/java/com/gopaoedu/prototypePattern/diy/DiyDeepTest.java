package com.gopaoedu.prototypePattern.diy;

public class DiyDeepTest {

    public static void main(String[] args) {

        /**
         * 使用工具类进行原型模式克隆
         */
        //深克隆：序列化
        UserInfo userInfo = new UserInfo();
        DiyDeepUtils div = new DiyDeepUtils();
        UserInfo user = (UserInfo)div.deepClone(userInfo);
        System.out.println("深克隆对象是否相等"+ (userInfo ==user));
        System.out.println("深克隆对象的属性是否相等"+ (userInfo.getList()==user.getList()));

        //浅克隆
        UserInfo userInfo2 = new UserInfo();
        UserInfo userInfo1 = div.shallowClone(userInfo2);
        System.out.println("浅克隆对象是否相等"+ (userInfo2 ==userInfo1));
        System.out.println("浅克隆对象的属性是否相等"+ (userInfo2.getList()==userInfo1.getList()));


        /**
         * 实现Cloneable接口，达到原型模式的“深克隆”
         */
        //深克隆：Conleable接口
        UserInfo userInfo3 = new UserInfo();
        UserInfo userInfo4 = new UserInfo();
        try {
            userInfo4 = (UserInfo)userInfo3.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Cloneable接口的克隆对象是否相等"+ (userInfo3 ==userInfo4));
        System.out.println("Cloneable接口的克隆对象的属性是否相等"+ (userInfo3.getList()==userInfo4.getList()));


    }
}
