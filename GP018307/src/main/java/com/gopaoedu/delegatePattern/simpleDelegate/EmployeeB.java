package com.gopaoedu.delegatePattern.simpleDelegate;

/**
 * 员工A
 */
public class EmployeeB implements IEmployee{
    @Override
    public IEmployee doing(String command) {
        System.out.println("我是员工A，我擅长数据库，开始工作："+command);
        return this;
    }

    @Override
    public IEmployee doing() {
        System.out.println("我是员工A，我日常工作是DBA");
        return this;
    }
}
