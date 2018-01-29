# 今日概要
	一、JSTL(JSP标准的标签库)	
	二、Filter和Listener

# 一、JSTL
### <1>概念
	JSP Standard Tag Library ,JSP标准的标签库


### <2>作用
	1.有助于前端开发人员的作业
	2.将数据和显示分类
	3.将业务封装到JSTL中，可以重用
		
### <3>语法
	1. 下载JSTL的jar包，添加到项目中（lib文件下）
	2. 在使用此标签库的页面中添加taglib指令
	   <%@taglib uri="标签库的描述" prefix="前缀"%>
	
		uri:用来匹配引入的标签库文件
		prefix:前缀，区分不同库中的标签

### <4>常用的标签
	<if>：判断标签
		语法格式：
		<c:if test="条件表达式">
			分支语句	
		</c:if>	
			
		属性：test属性是必要写的属性，boolean类型

	
	<choose>：多分支判断
		语法格式：
		<c:choose>
			<c:when test="条件">分支语句</c:when>			
			...
			<c:otherwise>分支语句</c:otherwise>
		</choose>
			
		属性：test属性，是分支结构的入口，boolean类型	

	    例如：
		<c:choose>
		<c:when test="${param.num==1}">
			<img alt="" src="book_01.jpg">
		</c:when>
		<c:when test="${param.num==2}">
			<img alt="" src="book_02.jpg">
		</c:when>
		<c:when test="${param.num==3}">
			<img alt="" src="book_03.jpg">
		</c:when>
		<c:otherwise>
			<img alt="" src="book_04.jpg">
		</c:otherwise>
	</c:choose>

	<foreach>：循环标签
		语法格式：
		<c:foreach item="" var="object">
			//循环体
					
		</c:foreach>			
					
		属性：item表示数据源，var从数据源中获取的一个对象

### <5>自定义标签（了解）
	编写的步骤：
		1.编写一个tld文件，描述一个自定义的标签库	

		2.编写一个类，实现标签的功能

		3.导入自己编写的标签库
			
		
# 二、Filter过滤器
### <1>概念
	web服务器上的所有对资源的请求进行管理和过滤操作

	Filter对用户的请求进行预处理，然后接着将请求提交给Servlet进行处理和响应，最后Filter对服务器的响应进行处理。

![](1.png)
	
### <2>特点
	保证资源的安全性
	身份的验证
	编码的设置
	... ...

### <3>实现的流程
	1. 编写一个类，实现Filter接口，重写过滤方法
	2. 在web.xml中配置过滤器，指定过滤资源


	<!-- 配置过滤器对象 -->
	<filter>
		<filter-name>checklogin</filter-name>
		<filter-class>cn.xdl.filter.MyFilter</filter-class>
	</filter>

	<!-- 指定需要拦截的请求 -->
	<filter-mapping>
		<filter-name>checklogin</filter-name>
		<url-pattern>/product_list.jsp</url-pattern>
	</filter-mapping>
								
	
### 作业
	重构商城的案例
		个人信息模块：登陆，注册，修改个人信息  （User）
		商品模块：
			使用一条SQL语句完成，获取指定条数的商品信息（按照某个字段进行排序）	

			



































