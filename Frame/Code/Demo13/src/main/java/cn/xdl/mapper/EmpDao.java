package cn.xdl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.xdl.entity.Emp;

public interface EmpDao {
	
	@Select("select * from emp")
	public List<Emp> findAll();
	
}
