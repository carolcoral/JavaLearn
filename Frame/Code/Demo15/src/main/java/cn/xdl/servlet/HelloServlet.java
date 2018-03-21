package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="helloservlet",urlPatterns="/hello.do")//等价于web.xml配置
public class HelloServlet extends HttpServlet{
	
	public void service(
		HttpServletRequest request,HttpServletResponse response) throws IOException{
//		HttpServletRequestWrapper
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Hello Servlet");
		out.close();
		
	}
	
}
