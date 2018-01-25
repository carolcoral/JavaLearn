# JSP

# 回顾
	一、JSP概述
	二、JSP语法
		申明定义区
		java代码区      _jspservice()
		输出表达式
		
		指定：include  /   page   /   taglib
		
# 今日概述
	一、JSP内置对象
	二、MVC设计思路
	

# 一、JSP内置对象

	输入输出对象：out对象，response对象，request对象
	通信控制对象：application对象，session对象，pageContext对象
	错误处理对象：exception对象
	Servlet对象：page对象，config对象

### <1>out对象
	概念：输出流对象，用来向浏览器输出信息。
		  还负责对缓冲区进行管理
	
	常用方法：print或者println,输出信息

### <2>request对象
	概念：封装了从客户端到服务器发出的请求信息。		
	
	
	常用方法：getParameter方法，接收服务器得到浏览器通过get/post方式传输的数据
			 setAttribute/getAttribute方法，用于在web组件之间进行数据的共享（servlet/jsp）
			 getRequestDispatcher("out.jsp").forward(request, response),页面的跳转

### <3>response对象
	概念：用户对客户端的请求进行回应。

	常用方法：sendRedirect,把响应发送到另一个位置进行处理
			 getWriter,输出信息


### <4>application对象(ServletContext)
	概念：代表当前应用程序的上下文，可以在不同的用户之间共享数据。
	
	常用方法：setAttribute/getAttribute ,用于在不同的用户之间共享信息

# 练习
	使用application对象实现对某个网站访问量的记录


### <5>session对象(HttpSession，存储用户信息/购物车信息等等)
	概念：用于保存用户的会话信息，实现一个用户的不同请求之间的数据共享。

	常用方法：setAttribute/getAttribute,同一个用户的不同请求之间的数据交互


	ProductServlet----->product_list.jsp----->购买(获取商品的信息)----->CarServlet(id,保存购物车数据)----->product_car.jsp
																			session(保存数据)
																			application
																			request		


![](s1.png)

# 作业
	完成课上的Demo（完成）
	扩展购物车功能
	完善代码（Dao）
			表------>dao---->daoimp---->daofactory---->daoservice

			xdl_product
			xdl_user

	预习EL+JSTL
		jsp  前端显示

### 购物车模块
	总金额：product_list.jsp----->CarServlet(选购的商品信息和总金额存储到session)---->product_car.jsp
	
	删除一条清单：product_car.jsp---->删除---->DeleteCarProductServlet(从session移除此商品)---->product_car.jsp
												获取session	
												获取需要移除项的id，移除操作
												跳转购物车列表

	更改清单中的数量：-  +（传输1/-1）  ----->UpdateCarProductNumServlet(从session更新此商品)
												获取session	
												获取需要更新项的id，更新操作（carProduct.getNum()+数值）
												跳转购物车列表
	
### <6>exception对象
	概念：处理JSP页面发生的错误和异常

##### 把所有的错误都集中到某个页面进行处理

	配置：发生错误的页面：page指令中配置，errorPage="指定产生异常时处理异常的页面"
		 处理错误的页面：page指令中配置，isErrorPage=true|false ,当前页面才可以使用exception
	
	常用方法：和java中异常一致

##### 自定义处理404错误500异常
		1.web.xml错误页面的配置
			<error-page>
				<error-code>404</error-code>
				<location>/page404.html</location>
			</error-page>
		2.编写需要展示自定义页面
			创建page404.html页面
	
### <7>pageContext对象
	概念：表示当前页面的上下文
		 使用当前的对象访问page,request,session,application范围内的数据。	
		 本身也可以存储数据
		
	常用方法：getAttribute(key)/setAttribute,获取的是当前page范围内的数据
			 getAttribute(String key,int scope)	
					参数二：指定获取数据的范围
						   PageContext.PAGE_SCOPE:	对应page范围
						   PageContext.REQUEST_SCOPE: 对应request范围
						   PageContext.SESSION_SCOPE:  对应session范围
						   PageContext.APPLICATION_SCOPE:  对应application范围
### <8/9>page,config对象
		
### 作用范围，四个域
	page范围： 一个页面，仅在当前页面有效
	request范围：一次请求，在同一次请求中有效
	session范围：一次会话，可以包含多个请求，在一个用户的多次请求中有效
	application范围：一次服务，可以在多个用户的多次会话中有效
	
	存储数据：范围不同，数据的交互

	常用方法：
			getAttribute/setAttribute











