## JSP有九个内置对象（又叫隐含对象），不需要预先声明就可以在脚本代码和表达式中随意使用
## JSP九大内置对象分为四类：
		输入输出对象：out对象、response对象、request对象
		通信控制对象：pageContext对象、session对象、application对象
		Servlet对象:page对象、config对象
		错误处理对象：exception对象
## 九种对象简介：
		out对象：用于向客户端、浏览器输出数据。
		request对象：封装了来自客户端、浏览器的各种信息。
		response对象：封装了服务器的响应信息。
		exception对象：封装了jsp程序执行过程中发生的异常和错误信息。
		config对象：封装了应用程序的配置信息。
		page对象：指向了当前jsp程序本身。
		session对象：用来保存会话信息。也就是说，可以实现在同一用户的不同请求之间共享数
		application对象：代表了当前应用程序的上下文。可以在不同的用户之间共享信息。
		pageContext对象：提供了对jsp页面所有对象以及命名空间的访问。
## 一.out对象
	out对象是一个输出流，用来向浏览器输出信息，除了输出各种信息外还负责对缓冲区进行管理。
out对象方法介绍：

<table>
 <col>
 <col >
 <col>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td >方法名</td>
  <td class=xl65 width=263 style='width:263pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>print或println</td>
  <td class=xl66 style='box-sizing: border-box'>输出数据</td>

 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>newLine</td>
  <td class=xl66 style='box-sizing: border-box'>输出换行字符</td>

 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>flush</td>
  <td class=xl66 style='box-sizing: border-box'>输出缓冲区数据</td>

 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>close</td>
  <td class=xl66 style='box-sizing: border-box'>关闭输出流</td>

 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>clear</td>
  <td class=xl66 style='box-sizing: border-box'>清除缓冲区中数据,但不输出到客户端</td>
 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>clearBuffer</td>
  <td class=xl66 style='box-sizing: border-box'>清除缓冲区中数据,输出到客户端</td>
 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>getBufferSize</td>
  <td class=xl66 style='box-sizing: border-box'>获得缓冲区大小</td>
 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>getRemaining</td>
  <td class=xl66 style='box-sizing: border-box'>获得缓冲区中没有被占用的空间</td>
 </tr>
 <tr height=17 style='height:17.0pt;box-sizing: border-box'>
  <td height=17 class=xl66 style='height:17.0pt;box-sizing: border-box'>isAutoFlush</td>
  <td class=xl66 style='box-sizing: border-box'>是否为自动输出</td>
 </tr>
</table>

## 二.request对象
	request对象封装了从客户端到服务器发出的请求信息。
### request对象方法介绍：

<table>
 <col >
 <col >
 <col >
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td>方法名</td>
  <td class=xl65 width=317 style='width:317pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>isUserInRole</td>
  <td class=xl65 style='box-sizing: border-box'>判断认证后的用户是否属于某一成员组</td> </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>获取指定属性的值,如该属性值不存在返回Null</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getAttributeNames</td>
  <td class=xl65 style='box-sizing: border-box'>获取所有属性名的集合</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getCookies</td>
  <td class=xl65 style='box-sizing: border-box'>获取所有Cookie对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getCharacterEncoding</td>
  <td class=xl65 style='box-sizing: border-box'>获取请求的字符编码方式</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getContentLength</td>
  <td class=xl65 style='box-sizing: border-box'>返回请求正文的长度,如不确定返回-1</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getHeader</td>
  <td class=xl65 style='box-sizing: border-box'>获取指定名字报头值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getHeaders</td>
  <td class=xl65 style='box-sizing: border-box'>获取指定名字报头的所有值,一个枚举</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getHeaderNames</td>
  <td class=xl65 style='box-sizing: border-box'>获取所有报头的名字,一个枚举</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getInputStream</td>
  <td class=xl65 style='box-sizing: border-box'>返回请求输入流,获取请求中的数据</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getMethod</td>
  <td class=xl67 style='box-sizing: border-box'>获取客户端向服务器端传送数据的方法</span></a></td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getParameter</td>
  <td class=xl65 style='box-sizing: border-box'>获取指定名字参数值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getParameterNames</td>
  <td class=xl65 style='box-sizing: border-box'>获取所有参数的名字,一个枚举</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getParameterValues</td>
  <td class=xl65 style='box-sizing: border-box'>获取指定名字参数的所有值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getProtocol</td>
  <td class=xl67 style='box-sizing: border-box'>获取客户端向服务器端传送数据的协议名称</span></a></td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getQueryString</td>
  <td class=xl67 style='box-sizing: border-box'>获取以get方法向服务器传送的查询字符串</span></a></td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getRequestURI</td>
  <td class=xl65 style='box-sizing: border-box'>获取发出请求字符串的客户端地址</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getRemoteAddr</td>
  <td class=xl65 style='box-sizing: border-box'>获取客户端的IP地址</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getRemoteHost</td>
  <td class=xl65 style='box-sizing: border-box'>获取客户端的名字</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getSession</td>
  <td class=xl65 style='box-sizing: border-box'>获取和请求相关的会话</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServerName</td>
  <td class=xl67 style='box-sizing: border-box'>获取服务器的名字</span></a></td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServerPath</td>
  <td class=xl65 style='box-sizing: border-box'>获取客户端请求文件的路径</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServerPort</td>
  <td class=xl67 style='box-sizing: border-box'>获取服务器的端口号</span></a></td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>removeAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>删除请求中的一个属性</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>setAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>设置指定名字参数值</td>
 </tr>
</table>

### request对象演示：
	完成一个简单的用户注册信息界面，将注册信息发送到欢迎界面上。
#### 用户注册界面表单设置：
	<form action="do_register.jsp" method="post">
	    用户名：
	    <input type="text" name="userName"><br>
	    技能：
	    <input type="checkbox" name="skills" value="java">java
	    <input type="checkbox" name="skills" value="python">python
	    <input type="checkbox" name="skills" value="ruby">ruby
	    <input type="checkbox" name="skills" value="golang">golang
	    <br>
	    <input type="submit" value="提交">
	    <input type="reset" value="重置">
	</form>

用户注册信息处理界面使用getParameter方法将用户的表单信息提取出来

		String name=request.getParameter("userName");
		String[] skillArr=request.getParameterValues("skills");
		
将skillArr数组转换成字符串：

		String skills="";
		if (skillArr!=null&&skillArr.length>0){
		    for (String skill:skillArr
		         ) {
		        skills=skills+skill+" ";
		    }
		}
		
将数据使用setAttribute保存起来

		request.setAttribute("userName",name);
		request.setAttribute("skills",skills);
		
使用jsp的forword指令将页面跳转到welcome.jsp

		<jsp:forward page="welcome.jsp"></jsp:forward>

setAttribute和getAttribute用于在web组件之间共享信息

getparameter方法用于接收服务器通过set和post方法传输的数据

注意没有setparameter方法

##### welcome.jsp页面配置：

		<html>
		<head>
		    <title>技能展示界面</title>
		</head>
		<body>
		
		信息展示界面：<br><br>
		<%--<%=%>这是表达式<%%>这是jsp程序处理--%>
		姓名：<%=request.getAttribute("userName")%><br>
		技能：<%=request.getAttribute("skills")%>
		</body>
		</html>


## 三.response对象
	response对象主要用于对客户端的请求进行回应。
	以及处理http的连接信息，例如设置http文件头，设置cookie对象等。
### response对象方法：

<table >
 <col >
 <col >
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td >方法名</td>
  <td class=xl65 width=317 style='width:317pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>addCookie</td>
  <td class=xl65 style='box-sizing: border-box'>添加一个Cookie对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>addHeader</td>
  <td class=xl65 style='box-sizing: border-box'>添加Http文件指定名字头信息</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>containsHeader</td>
  <td class=xl65 style='box-sizing: border-box'>判断指定名字Http文件头信息是否存在</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>encodeURL</td>
  <td class=xl65 style='box-sizing: border-box'>使用sessionid封装URL</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>flushBuffer</td>
  <td class=xl65 style='box-sizing: border-box'>强制把当前缓冲区内容发送到客户端</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getBufferSize</td>
  <td class=xl65 style='box-sizing: border-box'>返回缓冲区大小</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getOutputStream</td>
  <td class=xl65 style='box-sizing: border-box'>返回到客户端的输出流对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>sendError</td>
  <td class=xl65 style='box-sizing: border-box'>向客户端发送错误信息</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>sendRedirect</td>
  <td class=xl65 style='box-sizing: border-box'>把响应发送到另一个位置进行处理</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>setContentType</td>
  <td class=xl65 style='box-sizing: border-box'>设置响应的MIME类型</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>setHeader</td>
  <td class=xl65 style='box-sizing: border-box'>设置指定名字的Http文件头信息</td>
 </tr>
</table>

## 四.session对象
	session对象：是一个jsp内置对象，它在第一个jsp被装载时自动创建，完成会话期管理。从一个客户打开浏览器并连接到服务器开始，到客户关闭浏览器离  开这个服务器结束(或者超时)，被称为一个会话。当一个客户访问一个服务器时，可能会在这个服务器的几个页面之间切换，服务器应当通过某种办法知道这是一个客户，就需要创建session对象。
	http是无状态的连接协议，需要使用session来存放用户每次的登陆信息
### session对象方法：

<table>
 <col >
 <col >
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td >方法名</td>
  <td class=xl65 width=317 style='width:317pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>获取指定名字的属性</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getAttributeNames</td>
  <td class=xl65 style='box-sizing: border-box'>获取session中全部属性名字,一个枚举</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getCreationTime</td>
  <td class=xl65 style='box-sizing: border-box'>返回session的创建时间</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getId</td>
  <td class=xl65 style='box-sizing: border-box'>获取会话标识符</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getLastAccessedTime</td>
  <td class=xl65 style='box-sizing: border-box'>返回最后发送请求的时间</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getMaxInactiveInterval</td>
  <td class=xl65 style='box-sizing: border-box'>返回session对象的生存时间单位千分之一秒</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>invalidate</td>
  <td class=xl65 style='box-sizing: border-box'>销毁session对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>isNew</td>
  <td class=xl65 style='box-sizing: border-box'>每个请求是否会产生新的session对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>removeAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>删除指定名字的属性</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>setAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>设定指定名字的属性值</td>
 </tr>
</table>

接下来通过一个登陆的小例子来演示下session对象的应用：

		登陆表单设置：
		<form action="do_login.jsp" method="post">
		    userName:<input type="text" name="userName"><br/>
		    password:<input type="password" name="password"><br/>
		    <input type="submit" value="submit">
		    <input type="reset" value="reset">
		</form>

登陆逻辑处理界面，使用getParameter获取到用户名和密码：

		String userName=request.getParameter("userName");
		String password=request.getParameter("password");

对用户名和密码进行判断：
		
		if (userName!=null&&password!=null){
		    session.setAttribute("userName",userName);
		    response.setHeader("refresh","2;URL=welcome.jsp");
		}

在欢迎界面使用getAttribute获取当前的用户名：
		
		<%if(session.getAttribute("userName")!=null){%>

<code><%--getAttribute</code>方法是使用指定的key获取session中的value值。获取到的是一个object对象

在使用的时候需要根据具体的类型进行类型转换。

这里取出的是一个字符串，直接调用会使用他的toString方法，因此不用进行转换--%>

		欢迎 <%=session.getAttribute("userName")%>
		<a href="logout.jsp">注销</a>
		<%}else{%>
		请先登陆
		<a href="login.jsp">登陆</a>
		<%}%>

判断session对象是否是新创建

		<%if (session.isNew()){%>
		<br/>
		<br/>
		欢迎新用户
		<%}else{%>
		<br/>
		<br/>
		欢迎老用户
		<%}%>

在登出界面里清除session对象信息，并跳转到欢迎界面中去：

		session.invalidate();//清除掉session对象
		response.setHeader("refresh","2;URL=welcome.jsp");



## 五.application对象
	application对象代表当前的应用程序。存在于服务器的内存空间中。
	应用一旦启动便会自动生成一个application对象。如果应用没有被关闭，
	此application对象便一直会存在。直到应用被关闭
	application的生命周期比session更长。

### 应用：
	为多个用户共享全局信息。比如当前的在线人数等。
### application对象方法：
<table >
 <col >
 <col >
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td >方法名</td>
  <td class=xl65 width=317 style='width:317pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>获取应用对象中指定名字的属性值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getAttributeNames</td>
  <td class=xl65 style='box-sizing: border-box'>获取应用对象中所有属性的名字,一个枚举</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getInitParameter</td>
  <td class=xl65 style='box-sizing: border-box'>返回应用对象中指定名字的初始参数值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServletInfo</td>
  <td class=xl65 style='box-sizing: border-box'>返回Servlet编译器中当前版本信息</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>setAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>设置应用对象中指定名字的属性值</td>
 </tr>
</table>

可以使用application对象来实现页面访问次数记录的功能：

		<%
		    Object obj=application.getAttribute("counter");
		    if (obj==null){
		        application.setAttribute("counter",new Integer(1));
		        out.println("该页面被访问了1次<br/>");
		    }else {
		        int countValue=new Integer(obj.toString());
		        countValue++;
		        out.println("该页面被访问了"+countValue+"次<br/>");
		        application.setAttribute("counter",countValue);//java会自动装箱
		
		    }
		%>

## 六.config对象
	config对象表示当前jsp程序的配置信息
	一般项目中，jsp被用作模版技术，也就是位于表示层
	而位于表示层的jsp文件一般是不需要配置信息的
	所以此对象在jsp程序中其实很少使用
	config对象是servletConfig类的一个实例。
### config对象方法：

<table >
 <col>
 <col >
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td >方法名</td>
  <td class=xl65 width=317 style='width:317pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServletContext</td>
  <td class=xl65 style='box-sizing: border-box'>返回所执行的Servlet的环境对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServletName</td>
  <td class=xl65 style='box-sizing: border-box'>返回所执行的Servlet的名字</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getInitParameter</td>
  <td class=xl65 style='box-sizing: border-box'>返回指定名字的初始参数值</td>
 </tr>
 <tr height=20 style='height:20.0pt;box-sizing: border-box'>
  <td height=20 class=xl65 style='height:20.0pt;box-sizing: border-box'>getInitParameterNames</td>
  <td class=xl69 style='box-sizing: border-box'>返回该<font class="font11">JSP</font><font
  class="font12">中所有的初始参数名</font><font class="font11">,</font><font
  class="font12">一个枚举</font></td>
 </tr>
</table>


	page对象有点类似与java编程中的this指针，他指向了当前jsp页面本身。
	page对象是java.lang.object类的一个实例
	
* page对象拥有一个toString方法，下面是官方定义的方法介绍：

		public String toString() {
		    return getClass().getName() + "@" + Integer.toHexString(hashCode());
		}
		
包名+类名+@+hashcode值

### page对象的方法：
<table>
 <col >
 <col >
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td >方法名</td>
  <td class=xl65 width=317 style='width:317pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>toString</td>
  <td class=xl65 style='box-sizing: border-box'>将当前项目的信息打印出来</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getClass</td>
  <td class=xl65 style='box-sizing: border-box'>返回当前的object类</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>hashCode</td>
  <td class=xl65 style='box-sizing: border-box'>返回page对象的hashCode值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>equals</td>
  <td class=xl65 style='box-sizing: border-box'>用于比较对象是否与当前对象相同</td>
 </tr>
</table>

## 八.exception对象
	exception对象表示jsp引擎在执行代码时抛出的异常
	如果想要使用exception对象，那么需要配置编译指令的isErrorPage属性为true
	即在页面指令中设置:<%@page isErrorPage=“true”%>

## 九：pageContext对象

	pageContetx对象是jsp页面中所有对象功能的最大集成着。
	使用他可以访问所有的jsp内置对象。
	
### pageContext对象方法：

<table >
 <col >
 <col >
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td >方法名</td>
  <td class=xl65 width=317 style='width:317pt;box-sizing: border-box'>说明</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>forward</td>
  <td class=xl65 style='box-sizing: border-box'>重定向到另一页面或Servlet组件</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>获取某范围中指定名字的属性值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>findAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>按范围搜索指定名字的属性</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>removeAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>删除某范围中指定名字的属性</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>setAttribute</td>
  <td class=xl65 style='box-sizing: border-box'>设定某范围中指定名字的属性值</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getException</td>
  <td class=xl65 style='box-sizing: border-box'>返回当前异常对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getRequest</td>
  <td class=xl65 style='box-sizing: border-box'>返回当前请求对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getResponse</td>
  <td class=xl65 style='box-sizing: border-box'>返回当前响应对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServletConfig</td>
  <td class=xl65 style='box-sizing: border-box'>返回当前页面的ServletConfig对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getServletContext</td>
  <td class=xl65 style='box-sizing: border-box'>返回所有页面共享的ServletContext对象</td>
 </tr>
 <tr height=19 style='height:19.0pt;box-sizing: border-box'>
  <td height=19 class=xl65 style='height:19.0pt;box-sizing: border-box'>getSession</td>
  <td class=xl65 style='box-sizing: border-box'>返回当前页面的会话对象</td>
 </tr>
</table>


# jsp内置对象总结：

<table>
 <col >
 <tr >
  <td >Jsp内置对象</td>
  <td>功能</td>
  <td >主要方法</td>
 </tr>
 <tr >
  <td >out</td>
  <td>向客户<span >端输出数据</span></td>
  <td >print()
  println() flush() clear() isAutoFlush() getBufferSize()<font class="font7">&nbsp;&nbsp;</font><font><span>&nbsp;</span>close() …………</font></td>
 </tr>
 <tr >
  <td>request</td>
  <td >向客户<span style='display:none'>端请求数据</span></td>
  <td>getAttributeNames()
  getCookies() getParameter() getParameterValues() setAttribute()
  getServletPath() …………..</td>
 </tr>
 <tr >
  <td >response</td>
  <td>封装了jsp产生的响应,然后被发送到客户端以响应客户的请求</td>
  <td>addCookie()
  sendRedirect() setContentType()flushBuffer()
  getBufferSize() getOutputStream()sendError()
  containsHeader()……………</td>
 </tr>
 <tr >
  <td>application</td>
  <td ></td>
  <td ></td>
 </tr>
 <tr>
  <td >config</td>
  <td >表示Ser<span style='display:none'>vlet的配置,当一个Servlet初始化时,容器把某些信息通过此对象传递给这个Servlet</span></td>
  <td >getServletContext()
  getServletName() getInitParameter()<font class="font7">&nbsp;&nbsp;</font><font
  class="font5"><span
  style="mso-spacerun:yes">&nbsp;</span>getInitParameterNames()……………</font></td>
 </tr>
 <tr >
  <td>page</td>
  <td >Jsp实现<span style='display:none'>类的实例,它是jsp本身,通过这个可以对它进行访问</span></td>
  <td class=xl66 style='box-sizing: border-box'>flush()………</td>
 </tr>
 <tr >
  <td >pagecontext</td>
  <td >为JSP页面包装页面的上下文。管理对属于JSP中特殊可见部分中己经命名对象的该问</td>
  <td >forward()
  getAttribute() getException() getRequest() getResponse() getServletConfig() getSession()
  getServletContext() setAttribute() removeAttribute()
  findAttribute() ……………</td>
 <tr >
  <td >session</td>
  <td >用来保存每个用户的信息,以便跟踪每个用户的操作状态</td>
  <td >getAttribute()
  getId() getAttributeNames() getCreateTime()
  getMaxInactiveInterval() invalidate()
  isNew()</td>
 </tr>
 <tr >
  <td >exception</td>
  <td >反映运行的异常</td>
  <td >getMessage()…………</td>
  <td ></td>
 </tr>
</table>

