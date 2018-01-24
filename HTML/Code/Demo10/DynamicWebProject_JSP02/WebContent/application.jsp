<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是一个很好玩的网站</title>
</head>
<body>
	<%
		//0.判断application是否存储了记录当前网站的访问量的数据
		int count = 0;
		if(application.getAttribute("count")!=null){
			//1.获取application对象，获取记录当前网站访问量的数据
			count = (Integer)application.getAttribute("count");
			//2.添加访问量
			count++;	
		}else{
			count = 1 ;
		}
		//3.将新的数据存储到application
		application.setAttribute("count", count);
	%>
	
	<h1>欢迎大爷访问本网站，您是第<%=count %>位土豪来此消费！</h1>
	<a href="http://www.chuanchengdabing.cn">进入 商品区，进行消费</a>
</body>
</html>