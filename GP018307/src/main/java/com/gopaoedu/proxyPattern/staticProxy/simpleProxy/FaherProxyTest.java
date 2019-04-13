package com.gopaoedu.proxyPattern.staticProxy.simpleProxy;

import com.gopaoedu.proxyPattern.Person;

/**
 *
 * 父亲作为静态代理的测试
 */
public class FaherProxyTest {

    public static void main(String[] args) {
        Person father = new Father();
        father.findLove();
    }
}
