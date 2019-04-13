package com.gopaoedu.factoryPattern.abstractFactory;

/**
 * java笔记
 */
public class JavaNote implements INote{


    @Override
    public void edit() {
        System.out.println("写java笔记");
    }

    @Override
    public void look() {
        System.out.println("看java笔记");
    }
}
