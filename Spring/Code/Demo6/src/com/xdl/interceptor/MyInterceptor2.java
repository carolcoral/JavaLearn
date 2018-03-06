package com.xdl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor2  afterCompletion... ");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor2  postHandle... ");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, 
		HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("MyInterceptor2  preHandle... ");
		return  true;
	}

}
