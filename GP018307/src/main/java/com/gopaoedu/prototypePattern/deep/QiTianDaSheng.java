package com.gopaoedu.prototypePattern.deep;

import java.io.*;
import java.util.Date;

/**
 * 深克隆（实现Cloneable + 序列化）
 *
 * 齐天大圣，继承猴子父类，
 *      拔一根猴毛就克隆出一个一模一样的孙悟空，
 * 实现JDK的克隆接口
 * 实现序列化接口，深克隆的目的就是将对象使用字节码（流的形式）进行重新组装
 *
 *
 * 注：也可以不实现Cloneable的方法，直接序列化，也是一样的深克隆
 */
public class QiTianDaSheng extends Monkey implements Cloneable,Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 只有孙悟空才有金箍棒，不是所有猴子才有金箍棒
     *
     * Discription:[深度复制方法,需要对象及对象所有的对象属性都实现序列化]
     */
    public JinGuBang jinGuBang;

    /**
     * 给当前对象初始化赋值
     */
    public QiTianDaSheng() {
        this.jinGuBang = new JinGuBang();
        this.birthday = new Date();
        this.height = 150;
        this.weight = 60;
    }

    /**
     * 重写 Cloneable的克隆方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //调用深克隆方法
        return this.deepClone();
    }

    /**
     * 深克隆方法，将对象写出到流中（字节码中），再重新读取
     *
     * 深克隆特点：
     *      将对象和对象里面的属性对象等等全部是新对象新地址
     * @return
     */
    public Object deepClone(){

        // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            //写出指定对象即可，这里的this代表当前对象，再其他场景中就写出其他对象即可
            objOut.writeObject(this);

            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream objIn = new ObjectInputStream(in);
            QiTianDaSheng copy = (QiTianDaSheng)objIn.readObject();
            //猴子的生日不一样，重新给
            copy.birthday = new Date();
            //深克隆对象返回
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * 浅克隆特点：
     *      签克隆及对象为新对象，对象里面的属性为引用传递
     * @param target  传入对象，将此对象进行浅克隆
     * @return
     */
    public Object shallowClone(QiTianDaSheng target){
        /**
         * 浅克隆：创建新对象，属性还是用原对象的属性
         */
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.birthday = target.birthday;
        qiTianDaSheng.weight = target.weight;
        qiTianDaSheng.jinGuBang = target.jinGuBang;
        //返回新对象
        return qiTianDaSheng;
    }

}
