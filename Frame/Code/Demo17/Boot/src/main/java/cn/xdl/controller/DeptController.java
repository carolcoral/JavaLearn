package cn.xdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;
import cn.xdl.entity.MyResult;

@RestController//@Controller+@ResponseBody
public class DeptController {
	
	@Autowired
	private DeptDao deptDao;
	
	@RequestMapping(value="/dept",method=RequestMethod.GET)
	public List<Dept> loadAll(){
		return deptDao.loadAll();
	}
	
	@RequestMapping(value="/dept/{id}",method=RequestMethod.GET)
	public MyResult loadDept(@PathVariable("id")int no){
		MyResult result = new MyResult();
		Dept dept = deptDao.loadById(no);
		if(dept == null){
			result.setStatus(0);
			result.setMsg("未找到符合条件记录");
		}else{
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(dept);
		} 
		return result;
	}

}
