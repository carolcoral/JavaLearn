package cn.xdl.dao;

import org.springframework.stereotype.Repository;

@Repository("deptDao")
public class JdbcDeptDao implements DeptDao{

	@Override
	public void save() {
		System.out.println("采用JDBC技术添加一个部门信息");
	}

}
