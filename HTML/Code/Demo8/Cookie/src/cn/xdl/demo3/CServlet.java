package cn.xdl.demo3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/x/c.do")
public class CServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		String hahaha = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("hahaha")) {
					hahaha = cookie.getValue();
				}

			}
		}

		if (hahaha != null) {
			response.getWriter().append("已取出:" + hahaha);
			Cookie cookie = new Cookie("hahaha","");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} else {
			response.getWriter().append("取出失败:" + hahaha);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
