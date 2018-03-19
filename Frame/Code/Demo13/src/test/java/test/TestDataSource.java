package test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.xdl.MyBootApplication;
import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;
import cn.xdl.entity.Emp;
import cn.xdl.entity.Student;
import cn.xdl.mapper.EmpDao;
import cn.xdl.mapper.StudentDao;

public class TestDataSource {
	
	
	@Test
	public void test1() throws SQLException{
		ApplicationContext ac = 
			SpringApplication.run(MyBootApplication.class);
		DataSource ds = ac.getBean("myDataSource",DataSource.class);
		System.out.println(ds.getConnection());
		System.out.println(ds);
		JdbcTemplate template = ac.getBean("jdbcTemplate",JdbcTemplate.class);
		System.out.println(template);
		DeptDao deptDao = ac.getBean("jdbcDeptDao",DeptDao.class);
		List<Dept> list = deptDao.findAll();
		for(Dept dept:list){
			System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLoc());
		}
		//empDao
		EmpDao empDao = ac.getBean("empDao",EmpDao.class);
		List<Emp> list1 = empDao.findAll();
		for(Emp e:list1){
			System.out.println(e.getEmpno()+" "+e.getEname());
		}
		//studentDao
		StudentDao stuDao = 
			ac.getBean("studentDao",StudentDao.class);
		List<Student> list2 = stuDao.loadAll();
		for(Student s:list2){
			System.out.println(s.getNo()+" "+s.getName()+" "+s.getSex());
		}
	}
	
}
