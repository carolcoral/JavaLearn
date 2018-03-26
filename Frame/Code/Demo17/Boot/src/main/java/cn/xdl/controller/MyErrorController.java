package cn.xdl.controller;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyErrorController implements ErrorController{

	//自定义/error请求处理逻辑
	@RequestMapping("/error")
	public ModelAndView error(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");//error.html
		return mav;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
}
