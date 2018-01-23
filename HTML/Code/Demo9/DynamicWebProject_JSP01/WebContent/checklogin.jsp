<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 验证用户的登陆信息  -->
<%

	//1.获取表单数据
	String name = request.getParameter("username");
	String pwd = request.getParameter("pwd");
	//2.验证
	if("admin".equals(name)&&"123".equals(pwd)){
		//3.跳转结果页面
	%>
		<jsp:forward page="loginsuccess.jsp"><!--跳转页面  -->
			<jsp:param value="<%=name%>" name="username"/>
		</jsp:forward>
	<%
		
	}else{
		//3.跳转结果页面
		%>
		<jsp:forward page="forward_login.jsp"/><!--跳转页面  -->
		
	<%
	}
	
%>



