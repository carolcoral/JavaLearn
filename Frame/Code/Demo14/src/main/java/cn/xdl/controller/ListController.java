package cn.xdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

@Controller
public class ListController {
	
	@Autowired
	private DeptDao deptDao;
	
	@RequestMapping("/dept/list.do")
	public ModelAndView list(){
		List<Dept> list = deptDao.loadAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.getModel().put("depts", list);
		return mav;
	}
	
}
