package com.gopaoedu.proxyPattern.staticProxy.simpleProxy;

import com.gopaoedu.proxyPattern.Person;

/**
 * 父亲类（代理类）
 */
public class Father implements Person {

    Person son = new Son();

    /**
     * 父亲给儿子物色对象，
     *  在儿子的要求前面和后面做一些操作（达到增强的效果 AOP）
     * @return
     */
    @Override
    public int findLove() {
        System.out.println("父亲物色对象");
        son.findLove();
        System.out.println("相亲饭吃得很顺利，准备扯证！");

        return 0;
    }
}
