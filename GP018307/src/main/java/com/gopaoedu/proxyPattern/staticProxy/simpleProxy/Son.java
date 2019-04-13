package com.gopaoedu.proxyPattern.staticProxy.simpleProxy;

import com.gopaoedu.proxyPattern.Person;

/**
 * 儿子类
 */
public class Son implements Person {
    /**
     * 儿子找对象的方法和要求
     * @return
     */
    @Override
    public int findLove() {
        System.out.println("儿子要求： 肤白貌美大长腿！");
        return 0;
    }
}
