package com.gopaoedu.adapterPattern.loginAdapter;

import com.gopaoedu.adapterPattern.loginAdapter.adapters.*;

/**
 * 登陆适配器类
 *      结合策略模式、工厂模式、适配器模式
 *
 * 使用适配器完成新的登陆方式，同时能完美和老的登陆方式达到冲突
 *
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone, LoginForTelAdapter.class);
    }

    /**
     * 使用注册的方式登陆项目（老方法，调用父亲类原来的接口）
     * @param username
     * @param passport
     * @return
     */
    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        /**
         * 使用注册方式登陆，就直接调用原来的接口，
         * 达到适配器的效果，在不影响原来的代码上增加新功能
         */
        super.regist(username,passport);
        return super.login(username,passport);
    }



    /**
     * 使用适配器模式将新的登陆项目方式，进行统一登陆判断，
     *      传入  Class<? extends LoginAdapter> 类的作用：用于传参的定义要求，为了代码规范
     * @param id  传入ID
     * @param clazz  传入继承/实现 LoginAdapter 类的子类
     * @return
     */
    private ResultMsg processLogin(String id, Class<? extends LoginAdapter> clazz){
        try {
            //newInstace 实例化对象，使用接口统一接收（适配器不一定使用接口，使用接口的原因只是为了规范和方便统一接收）
            LoginAdapter loginAdapter = clazz.newInstance();
            //判断传过来的适配器是否与当前需要处理的逻辑对应（其实Class<? extends LoginAdapter> 已经帮忙判断了，只是多加一层）
            if (loginAdapter.support(loginAdapter)) {
                //调用对应的登陆方法，实现各自的登陆
                return loginAdapter.login(id,loginAdapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

}
