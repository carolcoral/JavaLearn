
<h1>Servlet 02</h1>
<p>2018年01月18日17:56:14</p>
<hr />
<h3>Tomcat 开发环境搭建</h3>
<pre><code>搭建开发环境, 就是将Tomcat 配置到Eclipse中的过程  ! 

每一次更换工作空间, 会导致Eclipse还原设置, 需要重新配置开发环境 !

强调:  开发环境的搭建, 与运行环境的搭建 没有关系 !


    步骤1.    下载tomcat , 并将其解压到任意的英文目录下!

    步骤2.    打开Eclipse

    步骤3.    点击window

    步骤4.    选择preferences   

    步骤5.    展开server页

    步骤6.    选择runtime 并点击add添加


整体步骤 如图: 
</code></pre>

<p><img src="https://i.imgur.com/HxfH0u4.png" /></p>
<p><img src="https://i.imgur.com/dY84sJd.png" /></p>
<p><img src="https://i.imgur.com/fNGK5MF.png" /></p>
<h3>tomcat 目录结构</h3>
<pre><code>bin/             二进制可执行文件和脚本
common/    Catalina本身和web应用可加载的类目录
conf/           配置文件目录
lib/              所有Web应用可见的类库目录
logs/           日志目录
server/        服务器所需的类库目录
webapps/    Web应用所存放的目录
work/           Tomcat的工作目录（存放临时文件）
</code></pre>

<h3>常用端口号</h3>
<pre><code>21 ftp
80 http
443 https
</code></pre>

<h3>web项目访问路径</h3>
<pre><code>http://ip地址:端口号/工程名/文件名.后缀名

当端口号为80时, 使用http协议 可以省略不写端口号

当项目名称为ROOT时, 项目作为服务器的根项目,可以省略工程名

当某一个资源文件的名称匹配如下欢迎页面规则时, 则作为欢迎页面存在, 可以省略文件名.后缀!

    &lt;welcome-file-list&gt;
        &lt;welcome-file&gt;index.html&lt;/welcome-file&gt;
        &lt;welcome-file&gt;index.htm&lt;/welcome-file&gt;
        &lt;welcome-file&gt;index.jsp&lt;/welcome-file&gt;
        &lt;welcome-file&gt;default.html&lt;/welcome-file&gt;
        &lt;welcome-file&gt;default.htm&lt;/welcome-file&gt;
        &lt;welcome-file&gt;default.jsp&lt;/welcome-file&gt;
      &lt;/welcome-file-list&gt;
</code></pre>

<h3>WEB三大组件 - Servlet *****</h3>
<pre><code>Servlet是运行在服务器(tomcat)上的Java类
用来完成B/S架构下，客户端请求的响应处理
平台独立，性能优良，能以线程方式运行
Servlet API为Servlet提供了统一的编程接口
</code></pre>

<h5>Servlet编写步骤:</h5>
<pre><code>1.  编写一个HttpServlet类的子类 

2.  重写父类service方法

3.  在service方法中, 操作请求与响应对象


代码案例: 

    public class Servlet1 extends HttpServlet {
        /**
         * request:  请求对象 , 封装了请求中的所有信息, 可以通过一系列的api  获取请求中的内容!
         * response: 响应对象 , 封装了响应的一些操作方式, 我们可以通过响应对象 对客户端(也就是浏览器) , 进行一些响应!
         */
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置响应内容类型为网页, 且内容编码为utf-8
            response.setContentType(&quot;text/html;charset=utf-8&quot;);
            //获取到响应流
            response.getWriter().append(&quot;哈哈哈哈&quot;).append(&quot;呵呵呵&quot;);
        }
    }
</code></pre>

<h5>web.xml的位置</h5>
<pre><code>web.xml的位置: 项目/webContent/web-inf文件夹中 !  ***
</code></pre>

<h5>将Servlet配置到web.xml中  *****</h5>
<pre><code>步骤: 

    1.  将servlet信息告知web.xml

        &lt;servlet&gt;
            &lt;servlet-name&gt;标识符命名的servlet别名&lt;/servlet-name&gt;
            &lt;servlet-class&gt;类全名(包名+类名)&lt;/servlet-class&gt;
        &lt;/servlet&gt;


    2.  根据第一步的别名, 指定映射的网址
        &lt;servlet-mapping&gt;
            &lt;servlet-name&gt;步骤1的别名&lt;/servlet-name&gt;
            &lt;url-pattern&gt;/地址&lt;/url-pattern&gt;
        &lt;/servlet-mapping&gt;



访问servlet的方式: 

    http://ip地址:端口号/项目名/url-pattern的值
</code></pre>

<h3>Servlet执行流程</h3>
<pre><code>我们的HTTP请求, 是寻找到了某个ip下的 xx端口号 !  

也就是说 其实我们在请求的是 tomcat !


我们编写了Servlet 并对其进行配置以后.  

当用户第一次访问对应此Servlet的url时, 
tomcat 会去创建这个Servlet对象!

并调用它的service, 同时将请求与响应 封装为对象传递到service方法中!

后续再次访问 不会再创建Servlet对象, 而是直接调用第一次创建的对象的 service方法 !

-------------------

Servlet的service方法每一次被tomcat调用 都是在一个新的线程中 !  当访问执行完毕, 线程消亡 !
</code></pre>

<h3>Servlet 生命周期 ***</h3>
<pre><code>Servlet对象 从创建 到被GC的过程 !


Servlet的生命周期 , 在HttpServlet这个类存在三个方法的体现:


1.  初始化方法 init
    我们一般情况下 重写此方法,  是为了在Servlet对象被创建时, 初始化一些资源 !


2.  正在服务方法 service
    服务方法, 每次执行都在一个新的线程中, 是服务用户的请求, 给用户进行响应的方法 !


3.  即将消亡方法 destroy
    我们一般重写此方法, 是为了释放一些占用的系统资源 !


Servlet在第一次请求时 被创建对象 . 在服务器关闭 或 服务器项目被卸载时关闭! 
</code></pre>

<h3>常见的网络地址的后缀</h3>
<pre><code>.html

.php    : PHP文件, 动态网页 !

.jsp    :   Java的动态网页文件

.do     : Struts1 建议使用 .do结尾 !

.action :Struts2 建议使用 .action
</code></pre>

<h5>doGet 和 doPost方法</h5>
<pre><code>-   GET请求 和 POST请求

    GET请求(点击超链接,浏览器输入网址,表单提交method=GET,AJAX GET请求)

        在网址中拼接参数, 
        只能传输字符串, 
        大小存在限制 ,
        不安全

    POST请求(表单提交method=POST,AJAX POST请求)

        在请求体中携带参数
        可以传输任意数据
        理论上大小无限制
        安全



当浏览器访问我们的Servlet时, 触发的时service方法, 

在HttpServlet中 service方法是存在逻辑处理的! 

在HttpServlet中 service方法的处理逻辑如下: 

-   获取请求的方式  (GET/POST)

-   进行判断, 如果方式为GET, 则调用doGet方法, 并传入HttpServletRequest对象 和 HttpServletResponse对象!

-   如果方式为Post , 则调用doPost方法, 并传入HttpServletRequest对象 和 HttpServletResponse对象!
</code></pre>

<h3>接收请求中携带 的参数</h3>
<pre><code>我们在doGET/doPost方法中  使用请求对象(HttpServletRequest对象) , 获取请求中的参数 !

1.  接收请求中的单个参数:     *****
    String value = request.getParameter(&quot;key&quot;);


2.  接收请求中的多个参数
    String[] values = request.getParameterValues(&quot;key&quot;);
</code></pre>

<h3>设置响应编码格式 ***</h3>
<pre><code>//必须写在响应数据之前, 建议在第一行

方式1.
    response.setContentType(&quot;text/html;charset=utf-8&quot;);


方式2.
    response.setCharacterEncoding(&quot;UTF-8&quot;);
</code></pre>

<h4>请求中的中文乱码问题 *****</h4>
<pre><code>解决方案1.(适用于GET请求/POST请求)

    分为两步: 

        1.  将接收到的参数, 按照ISO-8859-1打碎成字节数组

        2.  将字节数字 按照UTF-8组装为字符串 !

    代码案例: uname = new String(uname.getBytes(&quot;iso-8859-1&quot;),&quot;UTF-8&quot;);


解决方案2. (仅适用于POST请求)

    请求对象提供了设置请求体编码的api !
    案例:
        //必须写在获取请求参数之前, 建议在第一行
        request.setCharacterEncoding(&quot;UTF-8&quot;);

解决方案3. 更换tomcat版本8或以上 !
</code></pre>


</body>
</html>

