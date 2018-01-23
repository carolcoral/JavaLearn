package cn.xdl.demo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home.do")
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		String uname = null;
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("uname")) {
					uname = cookie.getValue();
				}
			}
		}
		if(uname==null) {
			//用户尚未登录
			//添加一个跳转到login.html的原因, 1表示用户在未登录的状态下,访问了  主页
			response.addCookie(new Cookie("flag", "1"));
			response.sendRedirect("login.html");
		}else {
			//用户已经登录
			response.getWriter().append("欢迎你:"+uname);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}
