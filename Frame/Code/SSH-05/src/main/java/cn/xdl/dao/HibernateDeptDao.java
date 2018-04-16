package cn.xdl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.xdl.entity.Dept;

@Repository("deptDao")
public class HibernateDeptDao implements DeptDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Dept> selectAll() {
		List list = hibernateTemplate.find("from Dept");
		return list;
	}

	public void save(Dept dept) {
		hibernateTemplate.save(dept);
	}

	public Dept selectById(int id) {
		Dept dept = hibernateTemplate.load(Dept.class, id);
		return dept;
	}

}
