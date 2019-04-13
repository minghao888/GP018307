package com.gopaoedu.decoratorPattern.passport;

import com.gopaoedu.decoratorPattern.passport.old.ResultMsg;
import com.gopaoedu.decoratorPattern.passport.old.SigninService;
import com.gopaoedu.decoratorPattern.passport.upgrade.ISiginForThirdService;
import com.gopaoedu.decoratorPattern.passport.upgrade.LoginForQQYanzheng;
import com.gopaoedu.decoratorPattern.passport.upgrade.SiginForThirdService;

public class DecoratorTest {

    public static void main(String[] args) {
        ISiginForThirdService iSiginForThirdService = new SiginForThirdService(new SigninService());
        iSiginForThirdService.login("sdfsfd","sfdsfs");



        iSiginForThirdService = new LoginForQQYanzheng(iSiginForThirdService);
        ResultMsg ss = iSiginForThirdService.loginForQQ("ss");

        System.out.println(ss.getMsg());
        System.out.println(ss.getCode());
        System.out.println(ss.getData());

    }

}
