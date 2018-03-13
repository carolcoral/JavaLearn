<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <h3>这是登录页面</h3>
    <form action="login.do">
         <input  type="text"   name="username" > <br>
         <input  type="password"  name="password"> <br>
         <input  type="submit"  value="登录"> <span>${msg}</span>
    </form>
</body>
</html>