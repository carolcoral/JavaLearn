<h2>技术架构</h2>
<p><img src="https://i.imgur.com/ZdFTdGt.png" /></p>
<h2>负载架构</h2>
<p><img src="https://i.imgur.com/42B6tkd.png" /></p>
<h2>二维码工具类</h2>
<p>开发步骤：</p>
<pre><code>1：新建一个web project或者java project
2：导入二维码所需jar包
3：编写生成二维码的java类，运行main方法即可
</code></pre>

<p>代码参考下图</p>
<p><img src="https://i.imgur.com/1YkWZVB.png" /></p>
<h1>项目1-----【CRM客户管理系统】</h1>
<h2>调研</h2>
<pre><code>略
</code></pre>

<h2>产品</h2>
<pre><code>略
</code></pre>

<h2>需求</h2>
<pre><code>参考《01_CRM需求概要文档V1.0》
</code></pre>

<h2>UI</h2>
<pre><code>略
</code></pre>

<h2>开发</h2>
<p>技术选型：</p>
<pre><code>SSM、MYSQL57、tomcat7、jdk1.7、boostrap、anglur.js、quartz、ehcache、富文本编辑器(百度编辑器)
</code></pre>

<p>框架搭建：</p>
<pre><code>数据库设计：
    数据库名称=工程名称CRM_16
    表设计：
        表字符：utf-8、utf8
        表字段：
            主键、bigint(20) 自增、（32） UUID、不能为空
        索引：
            外键、关联字段、查询比较频繁的字段
        单表：500M、索引个数16个
        临时表、存储过程、视图、触发器、监听器（后面课程讲）


数据库优化原则：

        后面课程讲
</code></pre>

<p>CRM数据库表设计说明：</p>
<pre><code>参考脚本文件《crm.sql》

hj_user 用户表
    userid 用户主键
    roleid  角色主键
    deptid 部门主键

hj_role 角色表
    roleid 角色ID
    deptid 部门ID

hj_dept 部门表
    deptid 部门ID
    deptparaid 上一级部门ID

hj_menu 菜单表
    menuid 菜单主键ID
    menuparaid 上一级菜单ID

hj_role_menu  角色-菜单关系表
    roleid 角色ID
    menuid 菜单ID
</code></pre>

<p>SQL需求:</p>
<pre><code>需求1：查询用户ID=2的信息： 用户ID，用户名，角色ID，角色名称，部门ID，部门名称

    select
        u.userid,u.username,u.roleid,r.rolename,u.deptid,d.deptname
    from hj_user u
    left join hj_role r on r.roleid = u.roleid
    left join hj_dept d on d.deptid = u.deptid
    where u.userid = 2;

需求2：查询角色ID=2所属的菜单信息：角色ID，角色名称，菜单ID，菜单名称

    select 
        rm.roleid,r.rolename,rm.menuid,m.menuname
    from hj_role_menu rm
    left join hj_role r on r.roleid = rm.roleid
    left join hj_menu m on m.menuid = rm.menuid
    where rm.roleid = 2;

    select 
        rm.roleid,r.rolename,rm.menuid, 
        -- group_concat()
        group_concat(m.menuname separator ',') menuname
    from hj_role_menu rm
    left join hj_role r on r.roleid = rm.roleid
    left join hj_menu m on m.menuid = rm.menuid
    group by r.rolename;


需求3：查询系统管理（菜单ID=1）所有下级菜单

    select * 
    from  hj_menu m
    where m.menuparaid = 1;

需求4：查询所有的上级菜单信息 
    select * 
    from  hj_menu m
    where m.menuparaid is null;
</code></pre>

<p>项目工程搭建步骤：</p>
<pre><code>1：新建一个web project工程CRM_16
2：解压FTP中CRM压缩包到本地文件夹
3：工程名右键，选择build path，选中最后一个选项，将tomcat的jar包导入工程
4：复制压缩文件中的webroot文件夹“内”的文件，到工程的WebROOT文件夹下
5：复制lib文件夹下的jar包复制到工程中
6：取消前端文件验证表达式错误，操作步骤，参考下图
</code></pre>

<p><img src="https://i.imgur.com/7rGu5JI.png" /></p>
<p>框架代码：</p>
<p>web.xml:</p>
<pre><code>通用性设置如下：

  &lt;!-- spring配置文件信息 --&gt;
  &lt;!-- springMVC配置文件信息 --&gt;

  &lt;!-- 编码格式 --&gt;
  &lt;!-- 日志信息 --&gt;
  &lt;!-- session有效期 --&gt;
  &lt;!-- 404、500 --&gt;
  &lt;!-- 请求后缀拦截.do(后台管理系统)，.htm(前端网站) --&gt;



&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;web-app version=&quot;2.5&quot; 
    xmlns=&quot;http://java.sun.com/xml/ns/javaee&quot; 
    xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot; 
    xsi:schemaLocation=&quot;http://java.sun.com/xml/ns/javaee 
    http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd&quot;&gt;
  &lt;display-name&gt;CRM_16&lt;/display-name&gt;   

  &lt;!-- spring配置文件信息 --&gt;
    &lt;context-param&gt;
        &lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
        &lt;param-value&gt;classpath:applicationContext.xml&lt;/param-value&gt;
    &lt;/context-param&gt;
    &lt;listener&gt;
        &lt;listener-class&gt;org.springframework.web.context.ContextLoaderListener&lt;/listener-class&gt;
    &lt;/listener&gt;
  &lt;!-- springMVC配置文件信息 --&gt;
    &lt;servlet&gt;
        &lt;servlet-name&gt;crm_16&lt;/servlet-name&gt;
        &lt;servlet-class&gt;org.springframework.web.servlet.DispatcherServlet&lt;/servlet-class&gt;
        &lt;init-param&gt;
            &lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
            &lt;param-value&gt;classpath:context-dispatcher.xml&lt;/param-value&gt;
        &lt;/init-param&gt;
        &lt;!-- 启用即加载 --&gt;
        &lt;load-on-startup&gt;1&lt;/load-on-startup&gt;
    &lt;/servlet&gt;

    &lt;!-- 请求后缀拦截.do(后台管理系统)，.htm(前端网站) --&gt;
  &lt;servlet-mapping&gt;
        &lt;servlet-name&gt;crm_16&lt;/servlet-name&gt;
        &lt;url-pattern&gt;*.do&lt;/url-pattern&gt;
  &lt;/servlet-mapping&gt;

  &lt;!-- 编码格式UTF-8 --&gt;
    &lt;filter&gt;
        &lt;filter-name&gt;encodingFilter&lt;/filter-name &gt;
        &lt;filter-class&gt;org.springframework.web.filter.CharacterEncodingFilter&lt;/filter-class&gt;
        &lt;init-param&gt;
            &lt;param-name&gt;encoding&lt;/param-name&gt;
            &lt;param-value&gt;UTF-8&lt;/param-value&gt;
        &lt;/init-param&gt;
        &lt;init-param&gt;
            &lt;param-name&gt;forceEncoding&lt;/param-name&gt;
            &lt;param-value&gt;true&lt;/param-value&gt;
        &lt;/init-param&gt;
    &lt;/filter&gt;
    &lt;filter-mapping&gt;
        &lt;filter-name&gt;encodingFilter&lt;/filter-name&gt;
        &lt;url-pattern&gt;*&lt;/url-pattern&gt;
    &lt;/filter-mapping&gt;

  &lt;!-- 日志信息 --&gt;
    &lt;context-param&gt;
        &lt;param-name&gt;log4jConfigLocation&lt;/param-name&gt;
        &lt;param-value&gt;classpath:/log4j.xml&lt;/param-value&gt;
    &lt;/context-param&gt;
    &lt;!-- 加载log4j配置文件 --&gt;
    &lt;listener&gt;
        &lt;listener-class&gt;org.springframework.web.util.Log4jConfigListener&lt;/listener-class&gt;
    &lt;/listener&gt;


  &lt;!-- session有效期 --&gt;
  &lt;session-config&gt;
    &lt;session-timeout&gt;120&lt;/session-timeout&gt;&lt;!-- 默认的是分钟 --&gt;
  &lt;/session-config&gt;
  &lt;!-- 404、500 --&gt;
  &lt;error-page&gt;
    &lt;error-code&gt;404&lt;/error-code&gt;
    &lt;location&gt;/404.do&lt;/location&gt;
  &lt;/error-page&gt;
  &lt;error-page&gt;
    &lt;error-code&gt;500&lt;/error-code&gt;
    &lt;location&gt;/500.do&lt;/location&gt;
  &lt;/error-page&gt;
&lt;/web-app&gt;
</code></pre>

<h3>登录页面跳转</h3>
<p>开发步骤：</p>
<p>代码示例：</p>
<p>页面展示：</p>
<h3>登录</h3>
<p>开发步骤:</p>
<p>代码如下：</p>
