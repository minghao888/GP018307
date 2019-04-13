package com.gopaoedu.templatePattern.courceTemplate;

/**
 * 网络授课模板
 *   模板模式：会有一个或多个未实现的方法，而且这几个方法有固定的执行顺序
 *
 *   不需要子类重写的方法直接使用final，
 *   必须子类重写的方法，使用abstract抽象方法，
 *   需要子类微调的钩子，根据情况重写即可
 */
public abstract class NetWorkCource {
    /**
     * 创建课程的一套流程
     */
    protected final void createCource(){
        //1.发布预习资料
        this.postPreResource();
        //2.制作PPT课件
        this.createPPT();
        //3.在线直播
        this.liveVideo();
        //4.提交课件，课堂笔记
        this.postNote();
        //5.提交源码
        this.postSource();
        //6.布置作业，有些课程没有作业，有些课程有作业
        //      如果有作业的话检查作业，没有作业的话，就完成了
        if(needHomeWork()){
            checkHomeWork();
        }


    }

    protected abstract void checkHomeWork();

    /**
     * 钩子方法，做一个微调整，子类根据情况重写
     * @return
     */
    protected boolean needHomeWork() {
        //默认没有课后作业
        return false;
    }

    final void postSource() {
        System.out.println("上传课程源代码！");
    }

    final void postNote() {
        System.out.println("上传课程笔记和课件！");
    }

    final void liveVideo() {
        System.out.println("在线直播授课");
    }

    final void createPPT() {
        System.out.println("制作PPT课件");;
    }

    final void postPreResource() {
        System.out.println("分发预习资料！");
    }
}
