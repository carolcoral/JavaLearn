<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out对象</title>
</head>
<body>
	<%
		for(int i = 0 ; i<10 ;i++){
			out.println("欢迎登陆使用本系统"+i);
			%>
				<br/>
			<%
		}
	
		String result = (String)request.getAttribute("result");
			
	
		
	%>
	
	<%=result %>
	<%
		response.getWriter().print("result:"+result);
	%>
</body>
</html>