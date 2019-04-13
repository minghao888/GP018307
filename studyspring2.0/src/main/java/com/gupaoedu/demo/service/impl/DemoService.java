package com.gupaoedu.demo.service.impl;

import com.gupaoedu.demo.service.IDemoService;
import com.gupaoedu.framework.annotation.MHService;

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
