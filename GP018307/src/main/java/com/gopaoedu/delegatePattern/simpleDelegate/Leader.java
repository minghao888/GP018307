package com.gopaoedu.delegatePattern.simpleDelegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 经理
 */
public class Leader {

    private Map<String,IEmployee> map = new HashMap<>();

    /**
     * 构造方法，将经理的所有员工信息整理出来，方便老板安排工作时候的任务配分
     */
    public Leader() {
        map.put("搭建架构", new EmployeeA());
        map.put("维护数据库",new EmployeeB());
    }

    /**
     * 经理的干活方法 —— 其实是委派（分配任务）
     * @param command
     */
    public void distribution(String command){
        map.get(command).doing().doing(command);
    }
}
