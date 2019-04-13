package com.gopaoedu.SingletonPattern.register;

import com.gopaoedu.SingletonPattern.ConcurrentExecutor;
import com.gopaoedu.SingletonPattern.ExectorThread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器缓存法的单例模式 测试
 */
public class ContainerSingletonPatternTest {

    public static void main(String[] args) {

//        //使用老师的发令枪进行测试
//        try {
//            long start = System.currentTimeMillis();
//            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
//                public void handler() {
//                    Object obj = ContainerSingletonPattern.getInstance("com.gopaoedu.SingletonPattern.Pojo");;
//                    System.out.println(System.currentTimeMillis() + ": " + obj);
//                }
//            }, 10,6);
//            long end = System.currentTimeMillis();
//            System.out.println("总耗时：" + (end - start) + " ms.");
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        //自己编写多线程测试
        Thread thread = new Thread(new ExectorThread());
        thread.start();
        Thread thread2 = new Thread(new ExectorThread());
        thread2.start();


    }
}
