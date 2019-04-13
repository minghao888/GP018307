package com.gopaoedu.decoratorPattern.passport.upgrade;

import com.gopaoedu.decoratorPattern.passport.old.ISigninService;
import com.gopaoedu.decoratorPattern.passport.old.ResultMsg;

/**
 * QQ登陆
 */
public class LoginForQQYanzheng extends SiginForThirdService {
    public LoginForQQYanzheng(ISigninService iSigninService) {
        super(iSigninService);
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        ResultMsg resultMsg = super.loginForQQ(id);
        resultMsg.setMsg("ssssss");
        return resultMsg;
    }

}
