package com.gopaoedu.delegatePattern.simpleDelegate;

/**
 * 员工接口类
 */
public interface IEmployee {
    IEmployee doing(String command);
    IEmployee doing();
}
