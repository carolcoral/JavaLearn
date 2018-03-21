package cn.xdl.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	private SomeInterceptor some;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(some).addPathPatterns("/compute.do");
	}
	
}
