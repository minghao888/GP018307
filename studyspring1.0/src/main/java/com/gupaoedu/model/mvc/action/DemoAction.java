package com.gupaoedu.model.mvc.action;

import com.gupaoedu.model.service.IDemoService;
import com.gupaoedu.mvcframework.annotation.MHAutowired;
import com.gupaoedu.mvcframework.annotation.MHController;
import com.gupaoedu.mvcframework.annotation.MHRequestMapping;
import com.gupaoedu.mvcframework.annotation.MHRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//虽然，用法一样，但是没有功能
@MHController
@MHRequestMapping("/demo")
public class DemoAction {

  	@MHAutowired
	private IDemoService demoService;

	/**
	 *  /query.*   测试请求参数的正则模式
	 * @param req
	 * @param resp
	 * @param name
	 */
	@MHRequestMapping("/query.*")
	public void query(HttpServletRequest req, HttpServletResponse resp,
					  @MHRequestParam("name")String name){
//		String result = demoService.get(name);
		String result = "My name is " + name;
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试int类型
	 * @param req
	 * @param resp
	 * @param a
	 * @param b
	 */
	@MHRequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@MHRequestParam("a") Integer a, @MHRequestParam("b") Integer b){
		try {
			resp.getWriter().write(a + "+" + b + "=" + (a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试double类型
	 * @param req
	 * @param resp
	 * @param a
	 * @param b
	 */
	@MHRequestMapping("/reduce")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@MHRequestParam("a") Double a, @MHRequestParam("b") Double b){
		try {
			resp.getWriter().write(a + "-" + b + "=" + (a - b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试不使用response返回，
	 * 使用返回方法的返回值返回
	 * @param req
	 * @param resp
	 * @param id
	 * @return
	 */
	@MHRequestMapping("/remove")
	public String remove(HttpServletRequest req,HttpServletResponse resp,
					   @MHRequestParam("id") Integer id){
		return ""+id;
	}

}
