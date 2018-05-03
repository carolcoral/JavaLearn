package com.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.entity.UserVo;
import com.xdl.service.UserService;

public class TestService {

	public static ApplicationContext context = null;
	
	static{
		context = new ClassPathXmlApplicationContext("spring-mysql-db.xml");
	}
	
	private UserService userService;
	
	@Before
	public void init(){
		userService = (UserService) context.getBean("userServiceImpl");
	}
	
	
	@Test
	public void testFindUser(){
		userService.findUser();
	}
	
	@Test
	public void testAddUser(){
		UserVo userVo = new UserVo();
		userVo.setUsername("test2");
		userVo.setPhone("18912341234");
		userService.addUser(userVo);
	}
	
	
}
