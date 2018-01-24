<%@page import="cn.xdl.bean.XdlProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新页面</title>
</head>
<%
	XdlProduct updateProduct = (XdlProduct)request.getAttribute("findProduct");
%>
<body>
	<form action="ProductServlet">
		编号：<input type="text" readonly="readonly" name="num" value="<%=updateProduct.getProduct_id()%>"/><br>
		名称：<input type="text"  name="name" value="<%=updateProduct.getName()%>"/><br>
		money：<input type="text"  name="price" value="<%=updateProduct.getFixed_price()%>"/><br>
		img：<input type="text"  name="img" value="<%=updateProduct.getBig_picture()%>"/><br>
		<input type="submit" value="更新"/><br>
		<input type="hidden" name="type" value="update"/>
	</form>
</body>
</html>