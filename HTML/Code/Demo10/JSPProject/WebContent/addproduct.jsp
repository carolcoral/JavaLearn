<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>	
	<form action="ProductServlet?type=add" method="post">
		商品的名称：<input type="text" name="name"/><br>
		商品的价格：<input type="text" name="price"/><br>
		商品的图片：<input type="text" name="img"/><br>
		<input type="submit" value="添加商品信息"/>
	</form>

</body>
</html>