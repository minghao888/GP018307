package com.gopaoedu.prototypePattern.deep;

public class DeepCloneTest {
    public static void main(String[] args) {
        //深克隆
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        try {
            QiTianDaSheng clone = (QiTianDaSheng)qiTianDaSheng.clone();
            //false
            System.out.println("深克隆两个对象是否相等："+ (clone == qiTianDaSheng));
            System.out.println("深克隆两个对象的属性是否相等："+ (clone.jinGuBang == qiTianDaSheng.jinGuBang));
            System.out.println("深克隆两个对象的属性是否相等："+ (clone.height == qiTianDaSheng.height));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();

        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng o = (QiTianDaSheng)q.shallowClone(q);
        //false
        System.out.println("浅克隆两个对象是否相等："+ (q == o));
        System.out.println("浅克隆两个对象的属性是否相等："+ (q.jinGuBang == o.jinGuBang));
        System.out.println("浅克隆两个对象的属性是否相等："+ (q.height == o.height));





    }
}
