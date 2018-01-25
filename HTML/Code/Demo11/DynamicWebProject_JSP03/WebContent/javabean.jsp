<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="mydate" class="java.util.Date"></jsp:useBean>
	<jsp:useBean id="myuser" class="cn.xdl.bean.User"></jsp:useBean>
	
	<%=mydate %>
	<%=myuser %>
	<br>
	
	<jsp:useBean id="myuser2" class="cn.xdl.bean.User"><!-- new User() -->
		<jsp:setProperty name="myuser2" value="韩信" property="name"/><!-- new User().setName("韩信") -->
	</jsp:useBean>
	
	<p>
		学生的姓名：<jsp:getProperty property="name" name="myuser2"/><!-- new User().getName() -->
	</p>
	<%=myuser2 %>
</body>
</html>


