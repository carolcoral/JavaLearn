package cn.xdl.demo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.html")
public class LoginPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<!DOCTYPE html> " + 
				"<html> " + 
				"<head> " + 
				"<meta charset='UTF-8'> " + 
				"<title>Insert title here</title> ");
		response.getWriter().append("<script>");
		
		
		Cookie[] cookies = request.getCookies();
		String flag = null;
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("flag")) {
					flag = cookie.getValue();
				}
				
			}
		}
		//程序执行到这里, flag存在三种情况, 
		
		if(flag==null) {
			//-	null 表示用户直接打开了登录页面
		}else if(flag.equals("1")) {
			//-	1	 表示用户从主页跳转至登录
			response.getWriter().append("alert('您尚未登陆, 无法访问主页,请先登录 !')");
		}else if(flag.equals("2")){
			//-	2	表示用户登录失败, 跳转回了登录页面
			response.getWriter().append("alert('很遗憾, 您登录失败了 ,请重新登录 !')");
		}
		//无论是以上什么情况, 都设置一个Cookie 用来覆盖上面的标记, 且覆盖后, 立即删除!
		Cookie flagCookie = new Cookie("flag","");
		flagCookie.setMaxAge(0);
		response.addCookie(flagCookie);
		
		response.getWriter().append("</script>");
		
		response.getWriter().append(		
				"</head> " + 
				"<body> " + 
				"	<h1>用户登录</h1> " + 
				"	<form action='login.do' method='POST'> " + 
				"	 " + 
				"	<p><input name='uname' placeholder='请输入帐号'></p> " + 
				"	<p><input name='upass' type='password' placeholder='请输入密码'></p> " + 
				"	<p><input value='登录' type='submit' ></p> " + 
				"	</form> " + 
				"</body> " + 
				"</html>")
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
