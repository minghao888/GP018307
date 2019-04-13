package com.gupaoedu.framework.beans;

/**
 * @Description:
 * @Auther: MingHao
 * @CreateDate: 10:32 2019/4/12
 * @Version: 1.0
 */
public class MHBeanWrapper {

    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public MHBeanWrapper(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    public Object getWrappedInstance() {
        return wrappedInstance;
    }
    // 返回代理以后的Class
    // 可能会是这个 $Proxy0
    public Class<?> getWrappedClass() {
        return this.wrappedInstance.getClass();
    }
}
