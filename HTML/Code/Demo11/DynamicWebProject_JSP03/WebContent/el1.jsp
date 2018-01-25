<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.xdl.bean.User"%>
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
		//1.无法获取
		String sex = "男";//在当前page页面申明的数据，el无法获取
		//2.从 小范围到大范围进行查找
		pageContext.setAttribute("username", "xiaoming");
		request.setAttribute("username", "admin");
		session.setAttribute("username", "wangayi");
		application.setAttribute("username", "zhangsan");
		application.setAttribute("sex", sex);
		
		//3.一个对象，获取属性
		User user = new User();
		user.setName("老李");
		user.setAge(18);
		session.setAttribute("user", user);
		//4.一个集合，获取集合中的对象和属性
		List<User> datas = new ArrayList<>();
		datas.add(user);
		datas.add(user);
		datas.add(user);
		session.setAttribute("datas", datas);
		%>

	
	用户名：${applicationScope.username} <!-- 指定了查找范围 -->
	性别：${sex}<!-- 未指定范围的查找 -->
	密码：${param.pwd} <!-- 获取对象的属性值 -->
	用户对象：${user.age>=18?"成年了":"未成年"}<!-- 使用运算符 -->
	获取一个集合中某个对象：${datas[1]}<!-- 获取一个集合中某个对象 -->
	获取一个集合中某个对象的属性：${datas[1].name}<!-- 获取一个集合中某个对象的属性 -->
</body>
</html>