package test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import cn.xdl.MyBootApplication;
import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

public class TestDataSource {
	
	@Test
	public void test1() throws SQLException{
		ApplicationContext ac = 
				SpringApplication.run(MyBootApplication.class);
		DataSource ds = ac.getBean("druid",DataSource.class);
		System.out.println(ds);
		System.out.println(ds.getConnection());
		DeptDao deptDao = ac.getBean("deptDao",DeptDao.class);
		List<Dept> list = deptDao.loadAll();
		for(Dept dept:list){
			System.out.println(dept.getDeptno()+" "+dept.getDname());
		}
	}
	
}
