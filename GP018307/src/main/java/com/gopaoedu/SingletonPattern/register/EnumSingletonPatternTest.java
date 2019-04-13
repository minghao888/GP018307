package com.gopaoedu.SingletonPattern.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 枚举单例
 *     通常在通用API中使用
 */
public class EnumSingletonPatternTest {

    public static void main(String[] args) {

        //获取枚举对象
        EnumSingletonPattern instancce = EnumSingletonPattern.getInstance();
        EnumSingletonPattern instancce2 = EnumSingletonPattern.getInstance();

        System.out.println(instancce.getData());
        System.out.println(instancce2.getData());
        //两个枚举是一个对象  true
        System.out.println(instancce2.getData() ==instancce.getData());


        //通过序列化测试枚举对象是否是单例
        try {
            EnumSingletonPattern instance1 = null;

            EnumSingletonPattern instance2 = EnumSingletonPattern.getInstance();
            instance2.setData(new Object());

            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (EnumSingletonPattern) ois.readObject();
            ois.close();

            System.out.println(instance1.getData());
            System.out.println(instance2.getData());
            //true
            System.out.println(instance1.getData() == instance2.getData());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
