package com.gopaoedu.decoratorPattern.passport.upgrade;

import com.gopaoedu.decoratorPattern.passport.old.ISigninService;
import com.gopaoedu.decoratorPattern.passport.old.ResultMsg;

public class SiginForThirdService implements ISiginForThirdService {

    private ISigninService iSigninService;

    public SiginForThirdService(ISigninService iSigninService) {
        this.iSigninService = iSigninService;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return new ResultMsg(3,"123","222");
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return null;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return this.iSigninService.regist(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return this.iSigninService.login(username,password);
    }
}
