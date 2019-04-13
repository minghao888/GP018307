package com.gopaoedu.proxyPattern.gynamicProxy.cglibProxy;

/**
 * 客户类，此类不做任何要求，CGlib是继承此类进行代理的。不是jdkProxy那样使用的此类必须实现一个接口
 */
public class Customer {


    public int findLove() {
        System.out.println("儿子要求： 肤白貌美大长腿！");
        return 0;
    }
}
