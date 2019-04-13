package com.gopaoedu.factoryPattern.abstractFactory;

/**
 * Python视频
 */
public class PythonVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制Pyhton视频");
    }
}
