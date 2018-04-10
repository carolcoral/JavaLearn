package cn.xdl.action;

import java.util.List;

import cn.xdl.dao.DeptDao;
import cn.xdl.dao.JdbcDeptDao;
import cn.xdl.entity.Dept;

public class ListAction {
	
	private List<Dept> depts;

	public String execute(){
		DeptDao deptDao = new JdbcDeptDao();
		depts = deptDao.loadAll();
		return "success";
	}
	
	
	public List<Dept> getDepts() {
		return depts;
	}


	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}


}
