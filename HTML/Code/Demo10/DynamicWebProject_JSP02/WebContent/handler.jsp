<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1.获取请求参数
	String name = request.getParameter("username");	
	String pwd = request.getParameter("pwd");	
	
	//out.print(name+","+pwd);
	response.getWriter().print(name+","+pwd);
	
	//2.转发操作
	//3.数据的传递
	request.setAttribute("result", name);
	
	request.getRequestDispatcher("out.jsp").forward(request, response);
	
%> 