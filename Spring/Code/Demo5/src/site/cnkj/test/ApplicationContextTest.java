package site.cnkj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.cnkj.dao.UserDao;

public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
		System.out.println(userDao.UserLogin("zhangfei", "zhangfei"));
	}

}
