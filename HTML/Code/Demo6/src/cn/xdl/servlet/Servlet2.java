package cn.xdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2.do")
public class Servlet2 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("初始化方法 正在执行~ ");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("正在服务 ~ ");
	}
	
	@Override
	public void destroy() {
		System.out.println("对象正在准备消亡 ~  ");
	}
	
	

}
