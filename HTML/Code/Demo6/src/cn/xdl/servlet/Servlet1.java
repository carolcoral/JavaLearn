package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	/**
	 * request:  请求对象 , 封装了请求中的所有信息, 可以通过一系列的api  获取请求中的内容!
	 * response: 响应对象 , 封装了响应的一些操作方式, 我们可以通过响应对象 对客户端(也就是浏览器) , 进行一些响应!
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应内容类型为网页, 且内容编码为utf-8
		response.setContentType("text/html;charset=utf-8");
		//获取到响应流
		response.getWriter().append("哈哈哈哈").append("呵呵呵");
	}
}
