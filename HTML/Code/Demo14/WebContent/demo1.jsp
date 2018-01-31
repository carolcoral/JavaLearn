<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"   src="js/jquery.js"></script>
<script type="text/javascript">
function   getRandom(){
	// 发起ajax 调用 
	$.ajax({
		url:"random.do",
		type:"post",
		success:function(data){
			$("#sp1").html(data);
		}
	});
}
</script>
</head>
<body>
    <%=new  Date() %>
    <input   type="button"  value="获取随机数"  onclick="getRandom()"> <br>
    <span  id="sp1"></span>
</body>
</html>