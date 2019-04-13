package com.gopaoedu.adapterPattern.loginAdapter.adapters;

import com.gopaoedu.adapterPattern.loginAdapter.ResultMsg;

/**
 * 接口类用于所有适配器的方法规定，可以不需要此接口类，
 * 在其他登陆的适配器类中自己写下面两个方法即可，此处的定义接口仅仅只是为了不写漏
 */
public interface LoginAdapter {
    /**
     *判断传入的类是否匹配当前类，用来判断是否兼容
     * @param adapter
     * @return
     */
    boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}
