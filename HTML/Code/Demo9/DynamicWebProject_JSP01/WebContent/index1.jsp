<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<!-- 申明定义区 -->
<%!
	String name = "赵云";
	
	public String getName(){
		return name;
	}
	
	//申明一个获取当前时间的成员方法
	public String getCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(new Date());
		return dateStr;
	}
	
%>
<body>

<!-- Java代码区 -->
	<%
		int age = 10;
	
		for(int i = 0 ; i<20 ; i++){
			%>
			 <h1>好人一生平安</h1> 
			<%
		}
		
	%>
	
	<%
		for(int i = 0 ; i<20 ; i++){
			out.print(getName()+" "+i);
		}
		
	%>
	<!-- 输出表达式区 -->
	<%=getCurrentTime()%>
</body>
</html>