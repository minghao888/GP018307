package com.gopaoedu.adapterPattern.loginAdapter.adapters;

import com.gopaoedu.adapterPattern.loginAdapter.ResultMsg;

/**
 * token登陆适配器
 */
public class LoginForTokenAdapter implements LoginAdapter {
    /**
     *判断传入的类是否匹配当前类，用来判断是否兼容
     * @param adapter
     * @return
     */
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
