package com.gopaoedu.decoratorPattern.battercake;

/**
 * 装饰器，副类（加香肠效果）
 * 给主类装饰效果
 *
 * 具体装饰类
 */
public class SausageDecorator extends BattercakeDecorator {
    /**
     * 通过构造，将原有的 Battercake 对象传入，赋值给当前对象，
     * 使得当前Battercake对象有了之前的所有功能
     *
     * @param battercake
     */
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    /**
     * 在原来的煎饼上面加一根香肠
     * @return
     */
    @Override
    protected String getMsg() {
        String sausage = "+一根香肠";
        return super.getMsg() +sausage;
    }

    /**
     * 再付香肠的钱
     * @return
     */
    @Override
    protected int getPrice() {
        int money = 5;
        return super.getPrice()+money;
    }

    /**
     * 打包费
     * @return
     */
    @Override
    protected int dabao() {
        int dabao = 6;
        return super.dabao()+dabao;
    }


}
