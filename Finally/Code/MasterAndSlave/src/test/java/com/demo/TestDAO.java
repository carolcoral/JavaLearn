package com.demo;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.dao.UserDAO;
import com.xdl.entity.UserVo;

public class TestDAO {

	public static ApplicationContext context = null;
	
	static{
		context = new ClassPathXmlApplicationContext("spring-mysql-db.xml");
	}
	
	private UserDAO userDAO;
	
	@Before
	public void init(){
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testFindAllUsers(){
		List<UserVo> list = userDAO.findUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getUsername());
			}
		}
//		System.out.println(list);
	}
	
	
	
}
