package com.gopaoedu.adapterPattern.loginAdapter;

/**
 * 新增登录功能，使用适配器模式 达到不影响原来代码，从而对项目进行扩展
 *  测试类
 */
public class PassportForThirdAdapterTest {

    public static void main(String[] args) {
        IPassportForThird passportForThird = new PassportForThirdAdapter();
        passportForThird.loginForQQ("123");
    }
}
