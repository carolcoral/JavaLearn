package com.xdl.mapper.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdl.bean.XdlDept;

@Repository("xdlDeptMapper")
public class XdlDeptMapperOracleImp implements XdlDeptMapper {
	@Autowired
    private  SqlSessionTemplate   sqlSessionTemplate;
	@Override
	public XdlDept findDeptById(int id) {
		return sqlSessionTemplate.selectOne("findDeptById", id);
	}

	@Override
	public List<XdlDept> listAll() {
		return sqlSessionTemplate.selectList("com.xdl.mapper.dao.XdlDeptMapper.listAll");
	}

	@Override
	public int addDept(XdlDept dept) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("addDept", dept);
	}

}
