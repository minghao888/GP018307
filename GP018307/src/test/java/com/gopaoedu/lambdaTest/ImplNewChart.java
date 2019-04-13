package com.gopaoedu.lambdaTest;

public class ImplNewChart implements NewChart {
    @Override
    public void test() {
        //直接调用接口中的默认方法，可以重写，也可以重写
        this.test2();
    }


    public static void main(String[] args) {
        ImplNewChart asda =  new ImplNewChart();
        asda.test();
    }
}
