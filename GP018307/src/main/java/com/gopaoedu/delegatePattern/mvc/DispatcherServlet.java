package com.gopaoedu.delegatePattern.mvc;

import com.gopaoedu.delegatePattern.mvc.controllers.MemberController;
import com.gopaoedu.delegatePattern.mvc.controllers.OrderController;
import com.gopaoedu.delegatePattern.mvc.controllers.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 相当于是项目经理的角色
 *
 *
 * 前端页面的请求相当于老板，dispatcharServlet相当于经理角色（委派者），controller相当于具体干活的
 * 工人
 */
public class DispatcherServlet extends HttpServlet{

    private List<Handler> handlerMapping = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        /**
         * init()方法初始化加载springmvc中所有controller
         */
        try {
            //加载MemberController
            Class<?> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler()
                    .setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberId", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json"));

            //加载OrderControllerClass
            Class<?> OrderControllerClass = OrderController.class;
            handlerMapping.add(new Handler()
                    .setController(OrderControllerClass.newInstance())
                    .setMethod(OrderControllerClass.getMethod("getOrderId", new Class[]{String.class}))
                    .setUrl("/web/getOrderById.json"));

            //加载SystemControllerClass
            Class<?> SystemControllerClass = SystemController.class;
            handlerMapping.add(new Handler()
                    .setController(SystemControllerClass.newInstance())
                    .setMethod(SystemControllerClass.getMethod("logOut", new Class[]{}))
                    .setUrl("/web/logOut.json"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        //1.获取用户请求的url,
        //      如果按照j2ee的标准，每个url对应一个servlet,url由浏览器输入
        String requestURI = req.getRequestURI();

        //2.Servlet拿到url以后，要做权衡（做判断和选择）
        //      根据用户的url，去找到这个url回应的某个方法


        //3.通过拿到的url再去handlerMapping（我们把它认为是策略常量） 进行查找
//        handlermapping.forEach(handler -> handler.getUrl().equals(requestURI));    lambda表达式没使用成功....
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if(requestURI.equals(h.getUrl())){
                handler = h;
                break;
            }
        }

        //4.将具体的请求人发分发给具体的Method(通过反射去调用其对应的方法)
        Object object = null;
        Method method = handler.getMethod();
        try {
            object = method.invoke(handler.getController(), req.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //5.获取到method的返回结果，使用resp返回给前端页面展示
        try {
            resp.getWriter().write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /**
     * 内部类
     */
    class Handler{

        private Object controller;   //存储Controller对象
        private Method method;     //存储对应的方法类类型
        private String url;        //存储请求的路径 url: /web/getOrderById.json

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
