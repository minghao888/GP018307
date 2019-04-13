package com.gopaoedu.SingletonPattern.serializble;

import java.io.Serializable;

/**
 * 反序列化破坏单例
 *      反序列化时导致单例被破坏 成多例
 */
public class SerializbleSingletonPattern implements Serializable {

    //序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private static final long SerialversionUID = 1L;

    //序列化就是说把内存中的状态通过转换成字节码的形式
    //从而转换一个IO流，写入到其他地方(可以是磁盘、网络IO)
    //内存中状态给永久保存下来了

    //反序列化
    //讲已经持久化的字节码内容，转换为IO流
    //通过IO流的读取，进而将读取的内容转换为Java对象
    //在转换过程中会重新创建对象new

    //1.私有化构造
    private SerializbleSingletonPattern(){
        //防止反射
        if(INSTANCE != null){
            throw new RuntimeException("单例对象，不允许创建多个实例！");
        }
    }

    //2.饿汉模式，类加载时初始化单例对象
    private static final SerializbleSingletonPattern INSTANCE = new SerializbleSingletonPattern();

    //3.返回单例
    public static SerializbleSingletonPattern getInstance(){
        return INSTANCE;
    }

    /**
     * 4.重新readResolve方法，对反序列化对象赋值为当前单例的唯一对象
     *  返回类型：Object
     */

    private Object readResolve(){
        return  INSTANCE;
    }


}
