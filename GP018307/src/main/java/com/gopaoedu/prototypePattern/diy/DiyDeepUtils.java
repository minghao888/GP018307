package com.gopaoedu.prototypePattern.diy;

import java.io.*;

/**
 * 自定义克隆工具
 *      深克隆+浅克隆
 */
public class DiyDeepUtils {



    /**
     * 深克隆，直接通过流的形式进行克隆
     * //Discription:[深度复制方法,需要对象及对象所有的对象属性都实现序列化]　
     * @param object
     * @return
     */
    public Object deepClone(Object object){

        try {
            // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            //写出到流中
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(object);

            // 将流序列化成对象
            //从流中读取
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();
            //返回对象
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }



    }

    /**
     * 浅克隆，创建对象，对象中的属性值还是使用原来对象的
     * @param target
     * @return
     */
    public UserInfo shallowClone(UserInfo target){
        //创建新对象
        UserInfo user = new UserInfo();
        user.setHeight(target.getHeight());
        user.setList(target.getList());
        user.setName(target.getName());
        user.setSex(target.getSex());
        user.setWeight(target.getWeight());
        return user;
    }






}
