package com.gopaoedu.factoryPattern.abstractFactory;

/**
 * Python笔记
 */
public class PythonNote implements INote{


    @Override
    public void edit() {
        System.out.println("写Pyhton笔记");
    }

    @Override
    public void look() {
        System.out.println("看Pyhton笔记");
    }
}
