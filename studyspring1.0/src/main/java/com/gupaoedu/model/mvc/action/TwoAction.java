package com.gupaoedu.model.mvc.action;


import com.gupaoedu.model.service.IDemoService;
import com.gupaoedu.mvcframework.annotation.MHAutowired;
import com.gupaoedu.mvcframework.annotation.MHController;
import com.gupaoedu.mvcframework.annotation.MHRequestMapping;
import com.gupaoedu.mvcframework.annotation.MHRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MHController
@MHRequestMapping("/two")
public class TwoAction {

	@MHAutowired
	private IDemoService demoService;

	@MHRequestMapping("/edit")
	public void edit(HttpServletRequest req,HttpServletResponse resp,
					 @MHRequestParam("name")String name){
		String result = demoService.get(name);
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
