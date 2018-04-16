<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>添加部门</h1>
	<form action="addDept.action" method="post">
		部门名称:<input type="text" name="dept.dname"><br/>
		部门地址:<input type="text" name="dept.loc"><br/>
		<input type="submit" value="新增">
	</form>
</body>
</html>