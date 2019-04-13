package com.gopaoedu.adapterPattern.powerAdapter;

/**
 * 220V电压
 */
public class AC220V {

    public int ouputAC220V(){
        int output = 220;
        System.out.println("输出电流："+output +"V");
        return output;
    }
}
