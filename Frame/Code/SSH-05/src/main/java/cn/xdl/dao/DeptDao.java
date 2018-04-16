package cn.xdl.dao;

import java.util.List;

import cn.xdl.entity.Dept;

public interface DeptDao {
	
	public List<Dept> selectAll();
	
	public void save(Dept dept);
	
	public Dept selectById(int id);
	
}
