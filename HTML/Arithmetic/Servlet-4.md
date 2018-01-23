
<h1>Servlet 04</h1>
<p>2018年01月23日08:43:43</p>
<hr />
<h3>会话跟踪 | 状态管理</h3>
<pre><code>HTTP协议是无状态的 ,没有记忆能力的 !  

会话 : 客户端与服务器的 多次请求与响应 !


Web程序基于HTTP协议通信，而HTTP协议是”无状态”的协议，一旦服务器响应完客户的请求之后，就断开连接，而同一个客户的下一次请求又会重新建立网络连接
服务器程序有时是需要判断是否为同一个客户发出的请求，比如客户的多次选购商品。因此，有必要跟踪同一个客户发出的一系列请求
把浏览器与服务器之间多次交互作为一个整体，将多次交互所涉及的数据保存下来，即状态管理
</code></pre>

<h3>Cookie   客户端会话跟踪的技术实现	**</h3>
<pre><code>技术原理:  

    浏览器向服务器发送请求时，服务器将数据以set-Cookie消息头的方式响应给浏览器，然后浏览器会将这些数据以文本文件的方式保存起来；
    当浏览器再次访问服务器时，会将这些数据以Cookie消息头的方式发送给服务器
</code></pre>

<h3>常用方法	*****</h3>
<pre><code>创建Cookie , 

    Cookie在Java中的体现, 是一个Cookie类, 用来表示一个键值对 !

-   构造方法

        Cookie cookie = new Cookie(String key,String value);

-   设置Cookie的存活时间

        cookie.setMaxAge(int 秒);

            切记: 不可超过int类型最大值, 因为溢出有可能变为负数

        -   传入0 : 立即删除 !
        -   传入正数: 按秒 计时
        -   传入负数: 默认值为-1, 表示浏览会话结束时, 自动删除!


        案例:    
            设置时长为20年: cookie.setMaxAge(20*365*24*3600);

-   获取Cookie的key
        String key = cookie.getName();

-   获取Cookie的value
        String value = cookie.getValue();
</code></pre>

<h5>*****</h5>
<pre><code>将Cookie放到响应头部: 

    response.addCookie(cookie);

    相同的key 在存储时, 会产生覆盖 !


从请求头部, 获取Cookie

    Cookie[] cookies = request.getCookies();

    因为服务器可以存储的Cookie数量很多, 所以每次获取都是一个数组, 
    如果从未存储过 cookies 就是一个null!

    所以 在对Cookies遍历时 ,一定要进行非空判断 !        
</code></pre>

<h3>Cookie路径问题 	*</h3>
<pre><code>我们在存储Cookie时, 默认路径为当前请求地址的路径 !

例如:  www.baidu.com/s/a.do   路径为/s
      www.baidu.com/s/a/b.do  路径为/s/a
      www.baidu.com/a/a/c.do  路径为/a/a
当浏览器发起向服务器的请求时, 会先对比域 , 然后比较路径, 在允许的路径规则内, 发送Cookie !

一般我们会把一个项目的所有Cookie的路径统一 设置为 根路径 (&quot;/&quot;)


Cookie存取替换规则: 

    -   Cookie的读取, 只有存储路径和存储路径的子路经可以读取 !
    -   Cookie的替换 只能由相同路径操作 !


设置Cookie路径为项目根目录: 

    cookie.setPath(&quot;/&quot;);


案例: 

    我们设计了三个Servlet


    a:  /x/a.do

    b:  /x/b.do

    c:  /x/y/c.do

    ------------------------------


    a存      
        a, b,c可以获取 , a可以替换, 
        b可以替换,c不可替换

    c存      
        a,b都不可获取 , c可以获取.  
        a,b不可以替换 c可以替换
</code></pre>

<h3>Cookie的优缺点  *****</h3>
<pre><code>1.  Cookie存储的数据类型只能为字符串, 且不支持中文
2.  数据存储在浏览器中, 服务器压力小 ,但是不安全, 不建议存储敏感数据!
3.  保存的数据最大4kb
4.  有时用户会勾选禁止Cookie , 则Cookie无法存储!
</code></pre>

<h3>Session(会话对象)  服务器端的实现 , 基于Cookie</h3>
<pre><code>浏览器访问服务器时，服务器会为每一个浏览器都在服务器端的内存中分配一个空间，用于创建一个Session对象，该对象有一个id属性，其值唯一，我们称为SessionId，并且服务器会将这个SessionId以Cookie方式发送给浏览器存储；

浏览器再次访问服务器时，同时会将SessionId发送给服务器，服务器可以依据SessionId查找相对应的Session对象 !
</code></pre>

<h3>如何获取一个Session对象</h3>
<pre><code>1.  无参方法:  *****

    request.getSession(); *****
    用来获取一个Session对象, 内部实现为调用一参方法, 传入true

2.  一参方法: 熟悉

    request.getSession(boolean isNew);
    用来获取一个Session对象

    参数: 
        true :  获取一个HttpSession对象, 如果之前对象存在,则拿来使用 , 如果不存在则创建一个新的Session,并返回!
        false:  获取一个HttpSession对象, 如果之前对象存在, 则拿来使用 , 如果不存在 则返回null


--------

当一个Session被tomcat创建时, 就已经帮我们将JSESSIONID存储到了Cookie中, 并将Cookie存放到了响应头!
</code></pre>

<h5>session常用方法	***</h5>
<pre><code>向Session中存储一个键值对
    -   setAttribute(String key,Object value)

从Session中获取一个值
    -   Object value = getAttribute(String key);

从Session中移除一个键值对
    -   removeAttribute(String key);

销毁Session
    -   invalidate();
</code></pre>

<h5>Session存活时长设置</h5>
<pre><code>方式1.
    独立运行环境下: 通过修改tomcat的conf目录下的 web.xml 来完成Session时长的设置 !

    开发环境下,修改Servers项目下的web.xml

        &lt;session-config&gt;
            &lt;session-timeout&gt;整数分钟&lt;/session-timeout&gt;
        &lt;/session-config&gt;

方式2.
    使用session对象, 设置单个session的存活时长 !
    session.setMaxInactiveInterval(int 秒);
</code></pre>

<h5>session的优缺点	****</h5>
<pre><code>优点: 

    -   存储的数据在服务器, 安全
    -   能保存任意类型的数据
    -   能保存的数据大小, 理论上是没有限制的!

缺点:

    -   存储的数据在服务器, 占用大量的内存 , 
    -   服务器资源耗尽时, 会崩溃 !(OOM)
</code></pre>

<h3>Session 和Cookie在使用时, 应结合使用, 而不是选择某一个!</h3>
<pre><code>我们一般建议 不敏感的字符串数据, 存储在Cookie中 !

对于安全性要求较高的数据, 存储在Session中 !



一个浏览器对应一个session  
其实我们也可以仅使用session  cookie 进行用户的会话跟踪 !
然后数据存储在数据库 !
</code></pre>

<h3>Servlet线程安全问题</h3>
<pre><code>服务器在收到请求之后，会启动一个线程来进行相应的请求处理。
默认情况下，服务器为每个Servlet只创建一个对象实例。当多个请求访问同一个Servlet时，会有多个线程访问同一个Servlet对象，此时就可能发生线程安全问题。

synchronized( this ){
    //并发处理逻辑
 }
</code></pre>


</body>
</html>

