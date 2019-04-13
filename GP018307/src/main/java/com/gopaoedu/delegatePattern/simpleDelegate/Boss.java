package com.gopaoedu.delegatePattern.simpleDelegate;

/**
 * 老板
 */
public class Boss {

    //经理（老板找经理）
    Leader leader = new Leader();

    /**
     * 老板指定任务
     * @param command  干活的内容
     */
    public void command(String command){
        //指定经理干活
        leader.distribution(command);
    }
}
