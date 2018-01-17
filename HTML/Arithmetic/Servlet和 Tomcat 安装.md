
<h1>Servlet和 Tomcat 安装</h1>
<p>2018年01月17日18:25:02</p>
<hr />
<h3>Http协议 *</h3>
<pre><code>是一个应用层网络协议 !  超文本传输协议 !

分为请求 和 响应 两部分 !

    特点: 

    1.  简单, 快速, 支持的请求方法有: GET / POST 等等.. 
    2.  灵活: 可以传输任意类型的数据 , 在响应时, 指定content-type即可!
    3.  无连接  每次连接只处理一次请求, 服务器响应完毕以后, 立即断开连接! 节省系统资源 ***
    4.  无状态  请求与响应时, 服务器不存在记忆能力 ,如果后续处理需要使用前面的信息, 则必须重新传递!***
</code></pre>

<h5>请求 ***</h5>
<pre><code>分为两种不同的请求: 
    GET/POST

由四部分组成: 

    1.  请求头
        -   请求头部信息, 由一个个的键值对组成, 是用来向服务器描述客户端信息的!
    2.  请求体
        -   请求时,携带的数据! 只在POST请求时, 使用请求体携带数据!
    3.  请求空行
        -   请求头部后的一行空白行
    4.  请求行
        -   由请求方法 和 url 以及 协议组成 !
</code></pre>

<h5>响应 ***</h5>
<pre><code>由三部分组成:

    1.  响应头
        -   描述服务器的信息(包含,响应的时长,内容大小,类型等等)
    2.  响应体
        -   服务器响应给浏览器的具体数据 !
    3.  响应行
        -   包含了服务器HTTP协议版本 ,响应码,如果请求失败 会携带失败原因!
</code></pre>

<h3>Tomcat安装 (独立运行环境)</h3>
<pre><code>前置安装环境: 

    环境变量中, 必须存在一个 变量名为 JAVA_HOME的变量, 值为JDK安装的根路径 !


步骤: 

    1.  官网下载tomcat  

    2.  解压tomcat文件 到任意英文目录

    3.  通过dos命令行, 进入解压后的tomcat/bin目录

    4.  在dos命令行中 输入安装指令: service install 回车

    5.  观察安装成功的提示: The service 'Tomcat7' has been installed;
</code></pre>

<h5>tomcat独立运行环境卸载</h5>
<pre><code>方式1. 借助安装的service命令来执行删除服务

    步骤1.    通过dos命令行, 进入解压后的tomcat/bin目录
    步骤2.    在dos命令行中输入卸载指令: service remove 回车!


方式2. (仅用于windows)

    使用windows 删除所有软件服务的命令 来删除系统中tomcat7的服务!
    在window的dos窗口下 (任意路径) 输入

    sc delete 服务名;

    为我们输入的是: 
    sc delete tomcat7;
</code></pre>

<h5>修改tomcat默认的端口号</h5>
<pre><code>1.  进入解压后的文件夹 中的conf目录 .

2.  编辑server.xml

3.  寻找到端口号8080  更改为80  (7版本大概在71行)

4.  重启tomcat  端口号就改变了
</code></pre>

<h5>验证安装成功</h5>
<pre><code>1.  进入解压后的 tomcat/bin目录

2.  打开tomcat7w.exe(安装失败打不开!)

3.  点击start启动服务
</code></pre>

<h3>Tomcat安装 (开发环境)</h3>

</body>
</html>
