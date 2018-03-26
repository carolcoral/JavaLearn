package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xdl.MyBootApplication;
import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MyBootApplication.class})
//@ContextConfiguration(classes={MyBootApplication.class})
public class TestDeptDao {

	@Autowired
	private DeptDao deptDao;
	
	@Test
	public void test1(){
		List<Dept> list = deptDao.loadAll();
		for(Dept dept:list){
			System.out.println(dept.getDeptno()+" "+dept.getDname());
		}
	}
	
}
