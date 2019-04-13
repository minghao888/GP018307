package com.gopaoedu.proxyPattern.gynamicProxy.jdkProxy;


import com.gopaoedu.proxyPattern.Person;

/**
 * 女孩子找对象
 *
 * 必须继承一个接口（Person），
 * 这个接口再代理对象中会被创建，从而进行动态代理，
 * 否则无法进行动态代理
 */
public class Girl implements Person{

    /**
     * 找对象的方法
     * @return
     */
    @Override
    public int findLove() {
        return 0;
    }
}
