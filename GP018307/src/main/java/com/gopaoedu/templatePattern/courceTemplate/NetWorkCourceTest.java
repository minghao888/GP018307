package com.gopaoedu.templatePattern.courceTemplate;

/**
 * 模板模式测试类
 *
 */
public class NetWorkCourceTest {
    public static void main(String[] args) {
        NetWorkCource javaCource = new JavaCource(false);
        javaCource.createCource();

        System.out.println();

        NetWorkCource bidataCource = new JavaCource(true);
        bidataCource.createCource();
    }
}
