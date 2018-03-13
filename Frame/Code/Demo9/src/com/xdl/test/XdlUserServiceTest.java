package com.xdl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.service.XdlUserService;
import com.xdl.service.impl.XdlUserServiceImpl;

public class XdlUserServiceTest {

	public static void main(String[] args) {
		ApplicationContext  app  = 
			new  ClassPathXmlApplicationContext("applicationContext.xml");
		/* XdlUserService userService = app.getBean("userService",
			XdlUserService.class); */
		XdlUserServiceImpl userService = app.getBean("userService",
				XdlUserServiceImpl.class);
		System.out.println(userService.getClass());
		userService.login();
	}

}
