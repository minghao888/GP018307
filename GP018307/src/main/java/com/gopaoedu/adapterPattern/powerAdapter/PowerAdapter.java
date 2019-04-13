package com.gopaoedu.adapterPattern.powerAdapter;

/**
 * 适配器模式：电压转换器
 */
public class PowerAdapter implements DC5V {

    private AC220V ac200v = null;

    public PowerAdapter(AC220V ac200v) {
        this.ac200v = ac200v;
    }

    /**
     * 适配器模式，将AC220V 转换成5V 进行输出给手机使用
     * @return
     */
    @Override
    public int outptuDC5V() {
        int adapterInput = ac200v.ouputAC220V();
        int adapteroutput = adapterInput / 44;
        System.out.println("使用PowerAdapter适配器，将AC"+adapterInput+"V电压转换成：DC"+adapteroutput+"V电压");
        return adapteroutput;
    }
}
