package com.gupaoedu;

import com.gupaoedu.framework.context.MHApplicationContext;
import com.gupaoedu.framework.core.MHBeanFactory;

/**
 * @Description:
 * @Auther: MingHao
 * @CreateDate: 15:21 2019/4/12
 * @Version: 1.0
 */
public class ATest {
    public static void main(String[] args) {
        System.out.println(MHApplicationContext.class.getSimpleName());
        System.out.println(MHApplicationContext.class.getName());
    }
}
