package cn.xdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

@Controller
public class TemplateController {
	
	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private RedisTemplate<Object, Object> redis;
	
	@RequestMapping("/template/list.do")
	public ModelAndView list(){
		List list = null;
		//访问redis,加载缓存数据
		list = (List)redis.opsForValue().get("depts");
		//如果缓存没有，去数据库加载，并且将返回结果放入redis缓存
		if(list == null){
			list = deptDao.loadAll();
			redis.opsForValue().set("depts", list);
			System.out.println("从数据库缓存获取数据");
		}else{
			System.out.println("从Redis缓存获取数据");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.getModel().put("depts", list);
		return mav;
	}
	
	@RequestMapping("/template/view.do")
	public ModelAndView view(int no){
		//查询Redis缓存(dept_id或dept:id)
		Dept dept = (Dept)redis.opsForValue().get("dept:"+no);
		//如果没有，再查询数据库，并且存入缓存
		if(dept == null){
			dept = deptDao.loadById(no);
			redis.opsForValue().set("dept:"+no, dept);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("view");
		mav.getModel().put("dept", dept);
		return mav;
	}
	
}
