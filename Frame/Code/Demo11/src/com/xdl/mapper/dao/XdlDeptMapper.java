package com.xdl.mapper.dao;

import java.util.List;

import com.xdl.bean.XdlDept;

public interface XdlDeptMapper {
     XdlDept   findDeptById(int id);
     List<XdlDept>  listAll();
     int   addDept(XdlDept dept);
}
