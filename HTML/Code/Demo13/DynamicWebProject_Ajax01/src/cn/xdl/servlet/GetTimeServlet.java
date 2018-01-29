package cn.xdl.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTimeServlet
 */
@WebServlet("/GetTimeServlet")
public class GetTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		response.getWriter().print(username+"-"+date);
		System.out.println("do over");
	}

}
