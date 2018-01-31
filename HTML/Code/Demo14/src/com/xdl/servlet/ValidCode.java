package com.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidCode
 */
@WebServlet("/validCode.do")
public class ValidCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String code = request.getParameter("code");
		// 从session  取得答案 
		String  number = (String)request.getSession().getAttribute("number");
		PrintWriter  pw =response.getWriter();
		if(code.equals(number)){
			pw.write("验证码正确");
		}else{
			pw.write("验证码错误");
		}
		pw.close();
	}

}




