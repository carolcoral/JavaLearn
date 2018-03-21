package cn.xdl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.xdl.entity.Dept;

public interface DeptDao {
	
	@Select("select * from dept")
	public List<Dept> loadAll();
	
	@Select("select * from dept where deptno=#{no}")
	public Dept loadById(int no);
	
}
