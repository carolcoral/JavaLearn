package cn.xdl.dao;

import java.util.ArrayList;
import java.util.List;

import cn.xdl.entity.Dept;

public class JdbcDeptDao implements DeptDao {

	public List<Dept> loadAll() {
		List<Dept> list = new ArrayList<Dept>();
		Dept dept = new Dept();
		dept.setDeptno(10);
		dept.setDname("Java");
		dept.setLoc("北京");
		list.add(dept);
		
		Dept dept1 = new Dept();
		dept1.setDeptno(20);
		dept1.setDname("PHP");
		dept1.setLoc("北京");
		list.add(dept1);
		
		Dept dept2 = new Dept();
		dept2.setDeptno(30);
		dept2.setDname("Python");
		dept2.setLoc("北京");
		list.add(dept2);
		return list;
	}

}
