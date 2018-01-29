package cn.xdl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化MyFilter对象");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter对象，开始过滤");
		//1.获取session对象
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		//2.获取当前用户的登陆信息
		String username = (String) session.getAttribute("username");
		//3.是否当前用户是否已经登陆
		if(username!=null){
			//代表当前的请求会执行后续的操作
			chain.doFilter(request, response);
		}else{
			//重定向到登陆页面
			res.sendRedirect("login.jsp");
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("销毁MyFilter对象");
	}
}
