package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

public class TestDeptDao {
	
	@Test
	public void test1(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DeptDao deptDao = ac.getBean("deptDao",DeptDao.class);
		List<Dept> list = deptDao.selectAll();
		for(Dept dept:list){
			System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLoc());
		}
	}
	
}
