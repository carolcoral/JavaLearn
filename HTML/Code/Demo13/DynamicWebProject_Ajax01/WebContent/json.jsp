<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getJson() {
			var xhr = null;
			//1.获取XMLHttpRequest对象
			if(window.ActiveXObject){//IE5,IE6 浏览器
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}else if(window.XMLHttpRequest){//IE7+，Firfox,Chrome等其他 浏览器
				xhr = new XMLHttpRequest();
			}
			alert("xhr:"+xhr);
			//2.创建一个ajax请求
			//参数一：method,请求的类型，GET/POST
			//参数二：url,请求的地址
			//参数三：async异步，true：异步方式；false:同步方式
			//xhr.open("get","GetTimeServlet?username=admin&pwd=123",true);
			xhr.open("post","GetJsonServlet",true);
			//3.回调事件的绑定
			xhr.onreadystatechange = function() {
				//当服务器返回结果数据时，此方法自动调用
				//1.响应完成 xhr.readyState+响应成功xhr.status
				if(xhr.readyState==4&&xhr.status==200){
					alert("响应结果");
					var result = xhr.responseText;
					//处理一个json对象字符串
					//var obj = eval("("+result +")");
					//var obj = JSON.parse(result);
					
					var jsonArray = JSON.parse(result);//json字符串被转化成了js对象数组
					//使用js语法，更新页面
					document.getElementById("h1").innerHTML=jsonArray[1].name;
				}
				
			}
			//4.发送ajax请求
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send(null);//get方式一律写null	
	}

</script>
</head>
<body>
	<input type="button" value="get json Str" onclick="getJson()" />
	<h1 id="h1"></h1>
</body>
</html>