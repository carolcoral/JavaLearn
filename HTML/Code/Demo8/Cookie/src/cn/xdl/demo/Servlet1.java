package cn.xdl.demo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1.do")
public class Servlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		if(cookies==null) {
			System.out.println("这个浏览器 没有存储我们的cookie");
		}else {
			for (Cookie cookie : cookies) {
				System.out.println("key:"+cookie.getName()+"---> value:"+cookie.getValue());
			}
		}
		response.getWriter().append("<H1>这里是Servlet1 , 哈哈哈哈哈</H1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
