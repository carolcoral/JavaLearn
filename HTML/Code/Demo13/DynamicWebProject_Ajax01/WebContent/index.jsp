<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax的demo</title>
<script type="text/javascript">
	function getTime() {
		//一、发送请求阶段：js事件触发ajax请求
		//二、服务器处理阶段：servlet处理，返回处理结果
		//三、ajax响应阶段：通过回调函数处理响应结果
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
		xhr.open("post","GetTimeServlet",true);
		//3.回调事件的绑定
		xhr.onreadystatechange = function() {
			//当服务器返回结果数据时，此方法自动调用
			//1.响应完成 xhr.readyState+响应成功xhr.status
			if(xhr.readyState==4&&xhr.status==200){
				alert("响应结果");
				var result = xhr.responseText;
				//使用js语法，更新页面
				document.getElementById("h1").innerHTML=result;
			}
			
		}
		//4.发送ajax请求
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
		xhr.send("username=admin&pwd=123");//get方式一律写null
		
	}
	
	function method() {
		setInterval(getTime, 1000);
	}
</script>
</head>
<body onload="method()">
	<input type="button" value="now ?" onclick="getTime()"/>
	<h1 id="h1"></h1>
	<table border="1" width="80%" bordercolor="#800000">
		<tr>
			<td width="50%" bgcolor="#FDCC64">
				<p align="center">
					<b><font color="#800000">Department Name</font></b>
			</td>
			<td width="50%" bgcolor="#FDCC64">
				<p align="center">
					<b><font color="#800000">Amount</font></b>
			</td>
		</tr>
		<tr>
			<td width="50%" align="center">日用品部</td>
			<td width="50%" align="center"><input type="text" name="T1"
				size="20" value="0" onblur="countMoney()"></td>
		</tr>
		<tr>
			<td width="50%" align="center">文体部</td>
			<td width="50%" align="center"><input type="text" name="T1"
				size="20" value="0" onblur="countMoney()"></td>
		</tr>
		<tr>
			<td width="50%" align="center">五金部</td>
			<td width="50%" align="center"><input type="text" name="T1"
				size="20" value="0" onblur="countMoney()"></td>
		</tr>
		<tr>
			<td width="50%" align="center">食品部</td>
			<td width="50%" align="center"><input type="text" name="T1"
				size="20" value="0" onblur="countMoney()"></td>
		</tr>
		<tr>
			<td width="50%" align="center">求和统计</td>
			<td width="50%" align="center"><input type="text" id="sumTxt"
				name="sumTxt" value="0" size="20"></td>
		</tr>
	</table>
</body>
</html>