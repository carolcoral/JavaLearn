
<h1>Servlet 03</h1>
<p>2018年01月20日08:44:38</p>
<hr />
<h3>ServletContext  上下文  ( 熟悉 )</h3>
<pre><code>用于关联单个项目中所有的Servlet

是多个Servlet之间通信的桥梁, 用于多个Servlet之间信息的共享 !

ServletContext(application) 在JSP技术点中 是一个很重要的点,  是9种隐含对象之一, 是4大域对象中范围最大的!



在项目启动时, tomcat会为每一个应用程序 创建一个ServletContext对象 ! 

在概念上,  我们可以认为它就像一个全局的 静态map集合一样, 在任何的Servlet中 都能很简单的寻找到它, 使用它存取数据!
</code></pre>

<h3></h3>
<pre><code>在Servlet中, 如何获取一个ServletContext对象

    ServletContext context = this.getServletContext();
</code></pre>

<h3></h3>
<pre><code>常用方法

-   存一个键值对  *****
    setAttribute(String key,Object value);

-   通过键取出值  *****
    getAttribute(String key);

-   通过键删除值  *****
    removeAttribute(String key);

-   获取项目运行时的目录 !    *

    String path = getRealPath(&quot;/&quot;);
</code></pre>

<h5>ServletContext 配置初始化数据</h5>
<pre><code>在web.xml中, 向ServletContext中 添加初始化数据 !

格式: 

&lt;context-param&gt;
    &lt;param-name&gt;key&lt;/param-name&gt;
    &lt;param-value&gt;value&lt;/param-value&gt;
&lt;/context-param&gt;


取出初始化的数据, 与 取出程序中存储的Attribute  不一样.

格式: 

    String value = getInitParameter(&quot;key&quot;);

获取所有初始化数据的key

    String[] keys = getInitParameterNames();
</code></pre>

<h3>ServletConfig 了解</h3>
<pre><code>每一个Servlet 都拥有一个配置对象(ServletConfig),

获取ServletConfig对象的两种方式: 

    1.  通过重写init方法, 得到参数列表中的ServletConfig

    2.  通过Servlet对象的getServletConfig方法 获取对象

注意: 第一种方法 使用后, 第二种方式失效 !



如何给Servlet添加配置对象 


在web.xml中配置Servlet时, 添加&lt;init-param&gt;节点

格式: 

&lt;serlvet&gt;
    &lt;servlet-name&gt;...&lt;/servlet-name&gt;
    &lt;serlvet-class&gt;...&lt;/servlet-class&gt;
    &lt;init-param&gt;
        &lt;param-name&gt;rootname&lt;/param-name&gt;
        &lt;param-value&gt;admin&lt;/param-value&gt;
    &lt;/init-param&gt;
&lt;/servlet&gt;
</code></pre>

<h3></h3>
<pre><code>通过ServletConfig对象, 如何获取配置时的数据 !

String value = config.getInitParameter(&quot;key&quot;);

获取所有初始化数据的key

String[] keys =config.getInitParameterNames();
</code></pre>

<h3>JDBC 与 JavaWeb</h3>
<h4>请求转发	*****</h4>
<pre><code>一个web组件, 将未处理完毕的请求, 通过tomcat 将请求转交给另外一个web组件处理!

格式: 

    步骤:

        -   1.  获取请求转发器
            RequestDispatcher pd = request.getRequestDispatcher(&quot;转发的地址&quot;);

        -   2.  通过请求转发器 , 将请求转发至另一个相对地址
            pd.forward(request,response);

    简写格式: 
            request.getRequestDispatcher(&quot;转发的地址&quot;).forward(request,response);


特点:

    1.  浏览器只发送了一次请求
    2.  浏览器地址不会发生改变
    3.  转发过程中的各个web组件, 共享这个请求与响应对象 !
    4.  转发的操作, 只能发生在同一个项目中!
</code></pre>

<h4>请求重定向 *****</h4>
<pre><code>响应给客户端一个302的状态码, 以及一个新的location 

浏览器接收到302状态码后, 立即发起一个新的请求, 寻找location


    格式: 

        response.sendRedirect(&quot;地址&quot;);

特点: 

    1.  产生了两次请求
    2.  浏览器地址发生了改变
    3.  可以跳转至外部网站
</code></pre>

<h3>作业</h3>
<pre><code>完成图书管理系统 


实现对于图书的管理 

    -   图书的查看  * 
    -   图书的删除
    -   图书的添加
    -   图书的修改  扩展
</code></pre>


</body>
</html>

