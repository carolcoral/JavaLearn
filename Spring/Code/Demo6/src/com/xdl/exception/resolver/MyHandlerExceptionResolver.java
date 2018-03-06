package com.xdl.exception.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
		HttpServletResponse arg1, Object arg2,
		Exception e) {
		ModelAndView mav = new ModelAndView();
		if( e  instanceof RuntimeException){
			 mav.setViewName("error2");
		}else if(e instanceof Exception){
			 mav.setViewName("error1");
		}
		return  mav;
	}

}
