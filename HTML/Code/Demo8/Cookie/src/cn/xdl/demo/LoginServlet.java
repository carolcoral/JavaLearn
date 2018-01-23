package cn.xdl.demo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(404, "网页不存在 哈哈哈哈哈哈");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		if((uname!=null&&uname.length()>2) && upass !=null) {
			//登陆成功
			//创建一个Cookie
			Cookie cookie = new Cookie("uname",uname);
			cookie.setMaxAge(30*24*60*60);
			response.addCookie(cookie);
			//response.getWriter().append("恭喜你, 登录成功");
			response.sendRedirect("home.do");
			
		}else {
			//登录失败
			//添加一个跳转到login.html的原因, 2表示用户登录失败
			response.addCookie(new Cookie("flag", "2"));
			response.sendRedirect("login.html");
		}
		
	}

}
