<h2>JEECMS内容管理系统--快速建站</h2>
<p>框架技术：</p>
<pre><code>SSH、mysql、jdk1.7、shiro、lucene、支付(阿里)、第三方(QQ)、二维码zxing、爬虫、webservice、logback、quartz、memcache、ehcache、dom4j
</code></pre>

<p>应用场景：</p>
<pre><code>1：将jeecms内容管理系统的后台改造为我们自己的网站后台
2：将jeecms内容管理系统的后台应用为我们网站的某一个模块，eg：资讯，新闻
</code></pre>

<p>搭建步骤：</p>
<pre><code>1：在开发工具中，新建一个web project工程jeecms
2：将jeecmsv8.1-src文件内的代码，复制到工程中
3：将db文件夹下的jeecms-db-v8脚本需要执行(执行之前，需要单独创建数据库jeecms)
4：将src文件夹下的代码，复制到工程的src下面
5：将WebContent文件内的所有文件，复制到webroot下面
6：修改jdbc属性配置文件
7：将项目工程部署到tomcat中，启动访问
</code></pre>

<p>访问地址：</p>
<pre><code>后台：http://localhost/jeecms/jeeadmin/jeecms/login.do
前端：http://localhost/jeecms
</code></pre>
