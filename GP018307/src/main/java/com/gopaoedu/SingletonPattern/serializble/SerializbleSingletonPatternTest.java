package com.gopaoedu.SingletonPattern.serializble;

import java.io.*;

/**
 * 反序列化破坏单例 测试
 */
public class SerializbleSingletonPatternTest  {

    public static void main(String[] args) {
        //定义序列化单例对象
        SerializbleSingletonPattern s1 = null;
        //获取单例
        SerializbleSingletonPattern s2 = SerializbleSingletonPattern.getInstance();

        FileOutputStream fos = null;
        try {
            //写出文件持久化（序列化）
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            //读取文件到内存(反序列化)
            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //强转对象
            s1 = (SerializbleSingletonPattern)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
