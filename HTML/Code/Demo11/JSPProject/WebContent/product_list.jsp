<%@page import="cn.xdl.bean.XdlProduct"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>demo1.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
#products {
	width: 520px;
	height: 400px;
	margin: 20px;
}

#cart {
	width: 520px;
	height: 400px;
	margin: 20px;
}

#products div {
	width: 150px;
	float: left;
	margin: 10px;
}

#products div img {
	width: 150px;
	height: 150px;
}

#products div p {
	border: 1px solid red;
	margin: 0px;
}

p.price {
	color: red;
	font-weight: bold;
}

#cart table {
	border: 1px solid black;
	width: 100%;
	margin: 10px;
}

#cart table td {
	border: 1px solid black;
	text-align: center;
}

#cart table .num {
	width: 30px;
}
</style>
<script type="text/javascript">
	function buyProduct(btn) {
		//获取商品信息
		//获取商品的价格
		var price = btn.name;
		//获取商品的名称
		var div = btn.parentNode.parentNode;
		var ps = div.getElementsByTagName("p");
		var name = ps[1].innerHTML;
		
		alert(name+"-"+price);
		
		window.location.href = "CarServlet?name="+name+"&price="+price;
		
	}
</script>
</head>

<body>
	<div>
		<!-- 产品列表 -->
		<div id="products">
			<%
				//1.接收Servlet从数据获取信息
				List<XdlProduct> datas = (List<XdlProduct>)request.getAttribute("data");
				for (int i = 0; i < datas.size(); i++) {
					XdlProduct currProduct = datas.get(i);
			%>
			<div>
				<img src="<%=currProduct.getBig_picture() %>" />
				<p class="price">
					¥<%=currProduct.getFixed_price() %>&nbsp;&nbsp; 
					<input name="<%=currProduct.getFixed_price() %>" type="button"
						onclick="buyProduct(this);" value="加入购物车" />
					<a href="CarServlet?cid=<%=currProduct.getProduct_id()%>&name=<%=currProduct.getName()%>&price=<%=currProduct.getFixed_price()%>">购买</a>
				</p>
				<p class="name"><%=currProduct.getName() %></p>
				<a href="ProductServlet?type=del&product_id=<%=currProduct.getProduct_id()%>">删除</a>
				 <a href="ProductServlet?type=findone&product_id=<%=currProduct.getProduct_id()%>">更新</a>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<a href="addproduct.jsp">添加商品信息</a>
	
</body>
</html>
