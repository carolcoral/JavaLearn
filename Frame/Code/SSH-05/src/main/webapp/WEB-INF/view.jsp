<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>部门详情</h2>
	编号：${dept.deptno}<br/>
	名称：${dept.dname}<br/>
	地址：${dept.loc}<br/>
	
	<a href="list.action">返回列表</a>
</body>
</html>