package com.gopaoedu.decoratorPattern.battercake;

/**
 * 装饰器，副类(加鸡蛋效果)
 * 给主类做装饰效果
 *
 * 具体装饰类
 */
public class EggDecorator extends BattercakeDecorator {




    /**
     * 通过构造，将原有的 Battercake 对象传入，赋值给当前对象，
     * 使得当前Battercake对象有了之前的所有功能
     *
     * @param battercake
     */
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    /**
     * 在主类的基础上添加装饰
     * 再煎饼的上面加一个煎蛋
     * @return
     */
    @Override
    protected String getMsg() {
        String egg = "+一个鸡蛋";
        return super.getMsg() + egg;
    }

    /**
     * 付煎蛋的钱
     * @return
     */
    @Override
    protected int getPrice() {
        int money = 2;
        return super.getPrice()+ money;
    }

    @Override
    protected int dabao() {
        int dabao = 5;
        return super.dabao() +dabao;
    }


}
