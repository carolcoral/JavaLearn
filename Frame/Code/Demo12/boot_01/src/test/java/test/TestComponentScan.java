package test;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import cn.xdl.MyBootApplication;
import cn.xdl.dao.DeptDao;

public class TestComponentScan {

	public static void main(String[] args) {
		ApplicationContext ac = 
			SpringApplication.run(MyBootApplication.class);//@Configuration+@Bean
		DeptDao deptDao = ac.getBean("deptDao",DeptDao.class);
		deptDao.save();
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		System.out.println(dbcp);
	}

}
