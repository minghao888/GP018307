package com.gopaoedu.factoryPattern.abstractFactory;

/**
 * java视频
 */
public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
