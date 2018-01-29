<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>

<body>
	<!-- 多分支  标签 -->
	
	<c:choose>
		<c:when test="${param.num==1}">
			<img alt="" src="book_01.jpg">
		</c:when>
		<c:when test="${param.num==2}">
			<img alt="" src="book_02.jpg">
		</c:when>
		<c:when test="${param.num==3}">
			<img alt="" src="book_03.jpg">
		</c:when>
		<c:otherwise>
			<img alt="" src="book_04.jpg">
		</c:otherwise>
	</c:choose>
	
</body>
</html>