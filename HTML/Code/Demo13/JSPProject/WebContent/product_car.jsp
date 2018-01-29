<%@page import="cn.xdl.bean.CarProduct"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">


#products{
	width: 520px;
	height: 400px;
	margin: 20px;
}

#cart{
	width: 520px;
	height: 400px;
	margin:20px;
}

#products div{
	width: 150px;
	float: left;
	margin: 10px;
}

#products div img{
	width: 150px;
	height: 150px;
}

#products div p{
	border: 1px solid red;
	margin: 0px;
}

p.price{
	color: red;
	font-weight: bold;
}

#cart table{
	border: 1px solid black;
	width: 100%;
	margin: 10px;
}

#cart table td{
	border: 1px solid black;
	text-align: center;
}

#cart table .num{
	width: 30px;
}
</style>
<script type="text/javascript">
	//创建XMLHttpRequest对象
	function createXhr() {
		var xhr = null;
		//1.获取XMLHttpRequest对象
		if(window.ActiveXObject){//IE5,IE6 浏览器
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){//IE7+，Firfox,Chrome等其他 浏览器
			xhr = new XMLHttpRequest();
		}
		
		return xhr;
	}

	//删除购物车商品
	function deleteCarProduct(pid,a) {
		//1.获取xhr对象
		var xhr = createXhr();
		alert("xhr:"+xhr);
		//2.创建一个Ajax请求
		xhr.open("post","DeleteCarProductServlet",true);
		//3.设置响应的回调函数
		xhr.onreadystatechange = function() {
			//当前请求是否已经处理完毕
			if(xhr.readyState==4&&xhr.status==200){
				alert("sucess");
				//获取响应结果
				var str = xhr.responseText;
				alert("删除完毕:"+str);
				//更新页面，从当前购物车列表中移除选中的选项，js
				//3.1更新总价格
				document.getElementById("sumPrice").innerHTML = "商品总金额："+str;
				//$("#sumPrice").html("商品总金额："+str);
				// tr.remove()
				//3.2移除删除的购物车列表记录
				var td = a.parentNode;
				var tr = td.parentNode;
				var table = tr.parentNode;
				table.deleteRow(tr.rowIndex);
			}
		};
		//4.发送ajax请求
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("pid="+pid);
	}
	
	//更新购物车商品的数量
	function updateCarProductNum(pid,a,num) {
		alert("pid:"+pid)
		//1.获取xhr对象
		var xhr = createXhr();
		alert("xhr:"+xhr);
		//2.创建一个Ajax请求
		xhr.open("post","UpdateCarProductNumServlet",true);
		//3.设置响应的回调函数
		xhr.onreadystatechange = function() {
			//当前请求是否已经处理完毕
			if(xhr.readyState==4&&xhr.status==200){
				alert("sucess");
				//获取响应结果
				var str = xhr.responseText;
				alert("更新完毕:"+str);
				//更新页面，从当前购物车列表中移除选中的选项，js
				//3.1更新总价格
				document.getElementById("sumPrice").innerHTML = "商品总金额："+str;
				//$("#sumPrice").html("商品总金额："+str);
				// tr.remove()
				//3.2更新商品的数量
				var td = a.parentNode;
				var span = td.getElementsByTagName("span")[0];
				span.innerHTML = eval( num+"+"+span.innerHTML);//"1+5" = 6
			}
		};
		//4.发送ajax请求
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("pid="+pid+"&num="+num);
	}
</script>
</head>
<body>
		<!-- 购物车 -->
    	<div id="cart">
    		<table id="cart_list">
    			<tr>
    				<th>产品名称</th>
    				<th>单价</th>
    				<th>数量</th>
    				<th>合计</th>
    				<th>操作</th>
    			</tr>
    				<c:forEach items="${carlist }" var="cp">
    					<tr>
		    				<td>${cp.name}</td>
		    				<td>${cp.price}</td>
		    				<td>
		    				    <a href="UpdateCarProductNumServlet?cid=${cp.car_id}&num=-1">-</a> 
		    				    <span>${cp.num}</span>
		    				     <a href="javascript:" onclick="updateCarProductNum(${cp.car_id},this,1)">+</a> 
		    				</td>
		    				<td>${cp.total}</td>
		    				<td><a href="javascript:" onclick="deleteCarProduct(${cp.car_id},this)">删除</a></td>
	    				</tr>
	    			</c:forEach>
    		</table>
    		<span id="sumPrice">商品总金额：${sumPrice }</span>
    	</div>
</body>
</html>