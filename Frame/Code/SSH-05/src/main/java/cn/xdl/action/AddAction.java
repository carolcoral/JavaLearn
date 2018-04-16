package cn.xdl.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

@Controller
@Transactional
public class AddAction {
	
	private Dept dept;//∂‘”¶dept.dname°¢dept.loc


	@Autowired
	private DeptDao deptDao;
	
	public String execute(){
		deptDao.save(dept);
		System.out.println(dept.getDname());
		return "success";
	}
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
