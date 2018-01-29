<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://hehe.haha.heihei.com/jsp/jstl/core" prefix="my" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义标签</title>
<script type="text/javascript">
	function btnclick() {
		alert("被点击");
	}

</script>
</head>
<body>
	<my:heihei></my:heihei>
	<my:yingying></my:yingying>
	<my:countNum></my:countNum>当前网站的访问量为：${count}
	<my:diviPage pageLength="10"></my:diviPage>
</body>
</html>