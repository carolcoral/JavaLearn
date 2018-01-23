<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		double randomNum = Math.random();
	%>
	<!-- include动作，导入一个jsp页面 -->
	<jsp:include page="index2.jsp"/>
	<!-- include动作，导入一个jsp页面 ，传递参数-->
	
	<jsp:include page="include_demo2.jsp">
		<jsp:param value="<%=randomNum %>" name="num"/>
	</jsp:include>	
	
</body>
</html>