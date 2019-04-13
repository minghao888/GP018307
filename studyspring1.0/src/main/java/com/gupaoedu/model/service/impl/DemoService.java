package com.gupaoedu.model.service.impl;

import com.gupaoedu.model.service.IDemoService;
import com.gupaoedu.mvcframework.annotation.MHService;

/**
 * 核心业务逻辑
 */
@MHService
public class DemoService implements IDemoService {

	@Override
	public String get(String name) {
		return name+"edit: hi "+name;
	}

}
