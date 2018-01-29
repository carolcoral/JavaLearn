<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    

<link rel="stylesheet" type="text/css" href="head.css" />
<!--快捷访问栏开始-->
<div id="shortcut">
	
	<div class="page_width">
		<ul>
			<li class="welcome">您好！欢迎来到京东商城！
				
				<c:if test="${not empty username}">
						<span>
							欢迎${username}
							<a href="login.jsp">[注销]</a>
							<a href="register.jsp" class="link_reg">[切换账户]</a>
						</span>	
				</c:if>
				
				<c:if test="${empty username}">
						<span>
							<a href="login.jsp">[请登录]</a>，新用户？
							<a href="register.jsp" class="link_reg">[免费注册]</a>
						</span>	
				</c:if>
					
			</li>
			<li class="my_order"><a href="orderList.jsp">我的订单</a></li>
			<li><a href="userHome.jsp">我的京东</a></li>
			<li><a href="myCart.jsp">我的购物车</a></li>
			<li class="sub">
                <a href="#" target="_blank">帮助中心</a>
            </li>
		</ul>
		<span class="clear"></span>
	</div>
</div>



