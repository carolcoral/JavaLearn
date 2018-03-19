package cn.xdl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.xdl.entity.Dept;

@Repository//扫描
public class JdbcDeptDao implements DeptDao{

	@Autowired//注入
	private JdbcTemplate template;
	
	@Override
	public List<Dept> findAll() {
		String sql = "select * from dept";
		RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<Dept>(Dept.class);
		List<Dept> list = template.query(sql, rowMapper);
		return list;
	}

}
