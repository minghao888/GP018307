package com.gopaoedu.prototypePattern.deep;

import java.io.Serializable;

/**
 * 孙悟空的金箍棒（猴子没有，只有孙悟空有）
 *
 * 序列化
 */
public class JinGuBang implements Serializable {

    private static final long SerialVersionUID  = 1L;

    public float h = 100;
    public float d = 10;

    public void big(){
        this.d *= 2;
        this.h *= 2;
    }

    public void small(){
        this.d /= 2;
        this.h /= 2;
    }
}
