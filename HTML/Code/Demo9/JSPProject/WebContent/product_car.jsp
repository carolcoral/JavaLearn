<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    		</table>
    	</div>
</body>
</html>