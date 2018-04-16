package cn.xdl.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

@Controller
@Transactional(readOnly=true)
public class ListAction {
	
	private List<Dept> depts;

	@Autowired
	private DeptDao deptDao;
	
	public String execute(){
		depts = deptDao.selectAll();
		return "success";
	}
	
	
	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

}
