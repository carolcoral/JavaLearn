package cn.xdl.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

@WebFilter(urlPatterns="/hello.do",filterName="somefilter")
public class SomeFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("-----doFilter------");
		chain.doFilter(request, response);//调用后续servlet\jsp等
		
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
