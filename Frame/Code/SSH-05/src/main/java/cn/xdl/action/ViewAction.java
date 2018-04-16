package cn.xdl.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

@Controller
public class ViewAction {

	private int id;//input
	private Dept dept;//output
	
	@Autowired
	private DeptDao deptDao;
	
	public String execute(){
		dept = deptDao.selectById(id);
		return "success";
	}

	
	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
