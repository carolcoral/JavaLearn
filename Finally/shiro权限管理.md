<h2>shiro权限管理</h2>
<p>Shiro 是一个强大而灵活的开源安全框架，能够非常清晰的处理认证、授权、管理会话以及密码加密。</p>
<h4>特点：</h4>
<pre><code>1：易于理解的 Java Security API
2：简单的身份认证（登录），支持多种数据源（LDAP，JDBC，Kerberos，ActiveDirectory 等）
3：对角色的简单的签权（访问控制），支持细粒度的签权
4：支持一级缓存，以提升应用程序的性能
5：内置的基于 POJO 企业会话管理，适用于 Web 以及非 Web 的环境
6：异构客户端会话访问
7：非常简单的加密 API
8：不跟任何的框架或者容器捆绑，可以独立运行
</code></pre>

<h4>Shiro 主要有四个组件：</h4>
<pre><code>SecurityManager：
    典型的 Facade，Shiro 通过它对外提供安全管理的各种服务

Authenticator：
    1：对“Who are you ？”进行核实。通常涉及用户名和密码
    2：这个组件负责收集 principals 和 credentials，并将它们提交给应用系统，如果提交的credentials 跟应用系统中提供的 credentials 吻合，就能够继续访问。否则需要重新提交 principals 和 credentials，或者直接终止访问。

Authorizer：
    1：身份份验证通过后，由这个组件对登录人员进行访问控制的筛查，比如“who can do what”， 或者“who can do which actions”。
    2：Shiro 采用“基于 Realm”的方法，即用户（又称 Subject）、用户组、角色和 permission 的聚合体。

Session Manager：
    这个组件保证了异构客户端的访问，配置简单。它是基于 POJO/J2SE 的，不跟任何的客户端或者协议绑定

Shiro 的认证和签权可以通过 JDBC、LDAP 或者 Active Directory 来访问数据库、目录服务器或者 Active Directory 中的人员以及认证 / 签权信息。SessionManager 通过会话 DAO 可以将会话保存在 cache 中，或者固化到数据库或文件系统中
</code></pre>

<h4>shiro可以做什么？</h4>
<pre><code>1：支持认证跨一个或多个数据源（LDAP，JDBC，kerberos身份等）
2：执行授权，基于角色的细粒度的权限控制
3：增强的缓存的支持
4：支持web或者非web环境，可以在任何单点登录(SSO)---ticket或集群分布式会话中使用
5：主要功能是：认证，授权，会话管理和加密
</code></pre>

<h4>Shiro支持三种方式实现授权过程：</h4>
<pre><code>1：编码实现
2：注解实现
3：jsp tablib标签
    Shiro提供了一套JSP标签库来实现页面级的授权控制
    在使用Shiro标签库前，首先需要在JSP引入shiro标签
</code></pre>

<h4>注解：</h4>
<pre><code>Shiro注解支持AspectJ、Spring、Google-Guice等

@RequiresAuthentication：
    可以用于用户类/属性/方法
@RequiresGuest
    表明该用户需为”guest”用
@RequiresPermissions(&quot;account:create&quot;)
    当前用户需拥有制定权限户 于表明当前用户需是经过认证的用户
@RequiresRoles 
    当前用户需拥有制定角色
@RequiresUser 
    当前用户需为已认证用户或已记住用户
</code></pre>

<h4>Shiro的具体功能点如下：</h4>
<pre><code>1. 身份认证/登录，验证用户是不是拥有相应的身份
2. 授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限
3. 会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；会话可以是普通JavaSE环境的，也可以是如Web环境的
4. 加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储
5. Web支持，可以非常容易的集成到Web环境，Caching：缓存，比如用户登录后，其用户信息、拥有的角色/权限不必每次去查，这样可以提高效率
6. shiro支持多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去
7. 提供测试支持
8. 允许一个用户假装为另一个用户（如果他们允许）的身份进行访问
9. 记住我，这个是非常常见的功能，即一次登录后，下次再来的话不用登录了
</code></pre>

<h4>shiro入门示例</h4>
<p>步骤：</p>
<pre><code>1：在启动容器中，增加shiro的filter过滤器
2：增加shiro的配置文件信息,shiro.xml
3：在shiro.xml配置文件中，增加自己的自定义relam(认证(查询用户名和密码信息)、授权(角色信息)，自己写一个查询数据库的用户名、密码、角色等用户信息)
4：在控制层controller，增加登录(login（）)和退出方法（logout（））
5：提示对应的登录返回信息即可
</code></pre>

<p>代码：</p>
<pre><code>web.xml中增加配置：
&lt;!-- shiro过滤器 --&gt;
&lt;filter&gt;  
    &lt;filter-name&gt;shiroFilter&lt;/filter-name&gt;  
    &lt;filter-class&gt;org.springframework.web.filter.DelegatingFilterProxy&lt;/filter-class&gt;  
    &lt;init-param&gt;  
        &lt;param-name&gt;targetFilterLifecycle&lt;/param-name&gt;  
        &lt;param-value&gt;true&lt;/param-value&gt;  
    &lt;/init-param&gt;  
&lt;/filter&gt;  
&lt;filter-mapping&gt;  
    &lt;filter-name&gt;shiroFilter&lt;/filter-name&gt;  
    &lt;url-pattern&gt;*.jhtml&lt;/url-pattern&gt;  
    &lt;url-pattern&gt;*.json&lt;/url-pattern&gt;  
&lt;/filter-mapping&gt; 

shiro配置文件：shiro.xml

&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;  
&lt;beans xmlns=&quot;http://www.springframework.org/schema/beans&quot;  
    xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;  
    xsi:schemaLocation=&quot;http://www.springframework.org/schema/beans   
                        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd&quot;  
    default-lazy-init=&quot;true&quot;&gt;  

    &lt;description&gt;Shiro Configuration&lt;/description&gt;  

    &lt;!-- Shiro's main business-tier object for web-enabled applications --&gt;  
    &lt;bean id=&quot;securityManager&quot; class=&quot;org.apache.shiro.web.mgt.DefaultWebSecurityManager&quot;&gt;  
        &lt;property name=&quot;realm&quot; ref=&quot;myShiroRealm&quot; /&gt;  &lt;!--自定义过滤(拦截)  --&gt;
        &lt;property name=&quot;cacheManager&quot; ref=&quot;cacheManager&quot; /&gt;  
    &lt;/bean&gt;  

    &lt;!-- 項目自定义的Realm --&gt;  
    &lt;bean id=&quot;myShiroRealm&quot; class=&quot;com.xdl.shiro.realm.MyShiroRealm&quot;&gt;  
        &lt;property name=&quot;cacheManager&quot; ref=&quot;cacheManager&quot; /&gt;  
    &lt;/bean&gt;  

    &lt;!-- Shiro Filter --&gt;  
    &lt;bean id=&quot;shiroFilter&quot; class=&quot;org.apache.shiro.spring.web.ShiroFilterFactoryBean&quot;&gt;  
        &lt;property name=&quot;securityManager&quot; ref=&quot;securityManager&quot; /&gt;  
        &lt;property name=&quot;loginUrl&quot; value=&quot;/login.jhtml&quot; /&gt;  
        &lt;property name=&quot;successUrl&quot; value=&quot;/loginsuccess.jhtml&quot; /&gt;  
        &lt;property name=&quot;unauthorizedUrl&quot; value=&quot;/error.jhtml&quot; /&gt;  
        &lt;property name=&quot;filterChainDefinitions&quot;&gt;  
            &lt;!--是有先后顺序的  --&gt;
            &lt;value&gt;  
                /index.jhtml = authc  
                /login.jhtml = anon
                /checkLogin.json = anon  
                /loginsuccess.jhtml = anon  
                /logout.json = anon  
                /** = authc  
            &lt;/value&gt;  
        &lt;/property&gt;  
    &lt;/bean&gt;  

    &lt;!-- 用户授权信息Cache --&gt;  
    &lt;bean id=&quot;cacheManager&quot; class=&quot;org.apache.shiro.cache.MemoryConstrainedCacheManager&quot; /&gt;  

    &lt;!-- 保证实现了Shiro内部lifecycle函数的bean执行 --&gt;  
    &lt;bean id=&quot;lifecycleBeanPostProcessor&quot; class=&quot;org.apache.shiro.spring.LifecycleBeanPostProcessor&quot; /&gt;  

    &lt;!-- AOP式方法级权限检查 --&gt;  
    &lt;bean class=&quot;org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator&quot;  
        depends-on=&quot;lifecycleBeanPostProcessor&quot;&gt;  
        &lt;property name=&quot;proxyTargetClass&quot; value=&quot;true&quot; /&gt;  
    &lt;/bean&gt;  

    &lt;bean class=&quot;org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor&quot;&gt;  
        &lt;property name=&quot;securityManager&quot; ref=&quot;securityManager&quot; /&gt;  
    &lt;/bean&gt;  

&lt;/beans&gt; 
</code></pre>

<p>shiro.xml配置文件说明：</p>
<p>”shiroFilter” 这个bean里面的各个属性property的含义：</p>
<pre><code>（1）securityManager：这个属性是必须的，没什么好说的，就这样配置就好。 
（2）loginUrl：没有登录的用户请求需要登录的页面时自动跳转到登录页面，可配置也可不配置。 
（3）successUrl：登录成功默认跳转页面，不配置则跳转至”/”，一般可以不配置，直接通过代码进行处理。 
（4）unauthorizedUrl：没有权限默认跳转的页面。 
（5）filterChainDefinitions，对于过滤器就有必要详细说明一下：
    1）Shiro验证URL时,URL匹配成功便不再继续匹配查找(所以要注意配置文件中的URL顺序,尤其在使用通配符时)，故filterChainDefinitions的配置顺序为自上而下,以最上面的为准
    2）当运行一个Web应用程序时,Shiro将会创建一些有用的默认Filter实例,并自动地在[main]项中将它们置为可用自动地可用的默认的Filter实例是被DefaultFilter枚举类定义的,枚举的名称字段就是可供配置的名称
    3）通常可将这些过滤器分为两组：
        anon,authc,authcBasic,user是第一组认证过滤器
        perms,port,rest,roles,ssl是第二组授权过滤器
        注意user和authc不同：当应用开启了rememberMe时,用户下次访问时可以是一个user,但绝不会是authc,因为authc是需要重新认证的 user表示用户不一定已通过认证,只要曾被Shiro记住过登录状态的用户就可以正常发起请求,比如rememberMe
        说白了,以前的一个用户登录时开启了rememberMe,然后他关闭浏览器,下次再访问时他就是一个user,而不会authc
    4)举几个例子 
        /admin=authc,roles[admin] 表示用户必需已通过认证,并拥有admin角色才可以正常发起’/admin’请求 
        /edit=authc,perms[admin:edit] 表示用户必需已通过认证,并拥有admin:edit权限才可以正常发起’/edit’请求 
        /home=user 表示用户不一定需要已经通过认证,只需要曾经被Shiro记住过登录状态就可以正常发起’/home’请求
    5)各默认过滤器常用如下(注意URL Pattern里用到的是两颗星,这样才能实现任意层次的全匹配)
        /admins/**=anon 无参,表示可匿名使用,可以理解为匿名用户或游客 
        /admins/user/**=authc 无参,表示需认证才能使用 
        /admins/user/**=authcBasic 无参,表示httpBasic认证 
        /admins/user/**=user 无参,表示必须存在用户,当登入操作时不做检查 
        /admins/user/**=ssl 无参,表示安全的URL请求,协议为https 
        /admins/user/*=perms[user:add:] 参数可写多个,多参时必须加上引号,且参数之间用逗号分割,如/admins/user/*=perms[“user:add:,user:modify:*”] 当有多个参数时必须每个参数都通过才算通过,相当于isPermitedAll()方法 
        /admins/user/**=port[8081]当请求的URL端口不是8081时,跳转到schemal://serverName:8081?queryString 其中schmal是协议http或https等,serverName是你访问的Host,8081是Port端口,queryString是你访问的URL里的?后面的参数 
        /admins/user/**=rest[user]根据请求的方法,相当于/admins/user/**=perms[user:method],其中method为post,get,delete等 
        /admins/user/**=roles[admin]参数可写多个,多个时必须加上引号,且参数之间用逗号分割,如/admins/user/**=roles[“admin,guest”]当有多个参数时必须每个参数都通过才算通过,相当于hasAllRoles()方法
</code></pre>
