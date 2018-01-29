<%@page import="java.util.ArrayList"%>
<%@page import="cn.xdl.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%
	//1.从数据库获取商品信息
	//2.发送给当前的jsp页面展示
	List<User> datas = new ArrayList<User>();
	for (int i = 0; i < 10; i++) {
		datas.add(new User("admin" + i, 10 + i));
	}

	request.setAttribute("datas", datas);
%>
<body>
	<!-- 数据的展示 -->
	<c:forEach items="${datas }" var="user">
		<div>用户名：${user.name} 年纪：${user.age }</div>
	</c:forEach>
</body>
</html>












