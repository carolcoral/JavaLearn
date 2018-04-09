<h2>Struts2简介</h2>
<p>Struts1(MVC)</p>
<p>WebWork2(MVC)--xwork(内核)--&gt;Struts2</p>
<h2>Struts2结构</h2>
<ul>
<li>springmvc</li>
</ul>
<p><img src="springmvc.png" /></p>
<ul>
<li>struts2</li>
</ul>
<p><img src="struts2.png" /></p>
<h2>基本使用</h2>
<p>/hello.action--&gt;Filter控制器--&gt;HelloAction--&gt;Result--&gt;/hello.jsp</p>
<ol>
<li>
<p>创建工程、引入jar包和xml配置文件</p>
<pre><code>&lt;dependencies&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;org.apache.struts&lt;/groupId&gt;
      &lt;artifactId&gt;struts2-core&lt;/artifactId&gt;
      &lt;version&gt;2.5.14.1&lt;/version&gt;
    &lt;/dependency&gt;
&lt;/dependencies&gt;
</code></pre>

<p>在src/main/resources添加struts.xml配置文件</p>
</li>
<li>
<p>编写流程中主要组件</p>
<pre><code>package cn.xdl.action;

public class HelloAction {

    //默认方法名为execute,无参
    public String execute(){
        System.out.println(&quot;进入HelloAction处理&quot;);
        return &quot;success&quot;;//与&lt;result&gt;配置对应
    }

}
</code></pre>

</li>
<li>
<p>按流程配置组件</p>
<ul>
<li>
<p>配置Filter控制器</p>
<pre><code>&lt;filter&gt;
    &lt;filter-name&gt;strutsmvc&lt;/filter-name&gt;
    &lt;filter-class&gt;
    org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter
    &lt;/filter-class&gt;
    &lt;!-- 默认找src/struts.xml配置文件 --&gt;
&lt;/filter&gt;

&lt;filter-mapping&gt;
    &lt;filter-name&gt;strutsmvc&lt;/filter-name&gt;
    &lt;url-pattern&gt;*.action&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
</code></pre>

</li>
<li>
<p>配置HelloAction和Result</p>
<pre><code>&lt;package name=&quot;demo1&quot; extends=&quot;struts-default&quot;&gt;

    &lt;action name=&quot;hello&quot; class=&quot;cn.xdl.action.HelloAction&quot;&gt;
        &lt;result name=&quot;success&quot; type=&quot;dispatcher&quot;&gt;
            /WEB-INF/hello.jsp
        &lt;/result&gt;
    &lt;/action&gt;

&lt;/package&gt;
</code></pre>

</li>
</ul>
</li>
</ol>
<h2>案例:列表显示</h2>
<p>/list.action--&gt;Filter控制器--&gt;ListAction--&gt;DeptDao--&gt;Result--&gt;/WEB-INF/list.jsp</p>
<h2>案例：修改Action请求扩展名</h2>
<h3>默认规则</h3>
<p>默认只有.action或没有扩展名请求能进入action，如果需要修改，按以下方法</p>
<ol>
<li>
<p>在web.xml中将Filter配置改为/*</p>
<pre><code>&lt;filter&gt;
    &lt;filter-name&gt;strutsmvc&lt;/filter-name&gt;
    &lt;filter-class&gt;
    org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter
    &lt;/filter-class&gt;
    &lt;!-- 默认请求类型为.action或没有扩展名 --&gt;
    &lt;!-- 默认找src/struts.xml配置文件 --&gt;
&lt;/filter&gt;

&lt;filter-mapping&gt;
    &lt;filter-name&gt;strutsmvc&lt;/filter-name&gt;
    &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
</code></pre>

</li>
<li>
<p>在struts.xml中定义<constant></p>
<pre><code>&lt;constant name=&quot;struts.action.extension&quot; value=&quot;do&quot;&gt;
&lt;/constant&gt;
</code></pre>

</li>
</ol>
<h3>请求命名空间namespace</h3>
<p>/day01/hello.do   请求名为hello，namespace为/day01,需要通过&lt; package&gt;元素的namespace属性指定。</p>
<pre><code>&lt;package name=&quot;demo1&quot; namespace=&quot;/day01&quot; extends=&quot;struts-default&quot;&gt;

    &lt;!--所有action请求都需要加上/day01 --&gt;
    &lt;action name=&quot;hello&quot; class=&quot;&quot;&gt;&lt;/action

&lt;/package&gt;
</code></pre>

<h2>案例：登录</h2>
<h3>显示登录界面</h3>
<p>/user/tologin.do--&gt;Filter控制器--&gt;ActionSupport--&gt;Result--&gt;/WEB-INF/login.jsp</p>
<ol>
<li>
<p>编写login.jsp</p>
</li>
<li>
<p>追加action配置</p>
<pre><code>&lt;!-- class属性默认值为ActionSupport --&gt;
&lt;action name=&quot;tologin&quot;&gt;
    &lt;!-- name默认值为success、type默认值为dispatcher --&gt;
    &lt;result&gt;
    /WEB-INF/login.jsp
    &lt;/result&gt;
&lt;/action&gt;
</code></pre>

</li>
</ol>
<h3>登录按钮处理</h3>
<p>/user/login.do--&gt;Filter控制器--&gt;LoginAction--&gt;Result--&gt;成功ok.jsp/失败login.jsp</p>
<ol>
<li>
<p>编写LoginAction</p>
<p>利用同名属性接收请求参数</p>
<pre><code>public class LoginAction {

    private String username;//对应&lt;input type=&quot;text&quot; name=&quot;username&quot;&gt;
    private String password;

    public String execute(){
        //检查用户名和密码
        if(&quot;scott&quot;.equalsIgnoreCase(username)
            &amp;&amp;&quot;123456&quot;.equals(password)){
            return &quot;success&quot;;
        }
        return &quot;login&quot;;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
</code></pre>

</li>
<li>
<p>配置LoginAction和Result</p>
<pre><code>&lt;action name=&quot;login&quot; class=&quot;cn.xdl.action.LoginAction&quot;&gt;
    &lt;result name=&quot;success&quot; type=&quot;dispatcher&quot;&gt;/WEB-INF/ok.jsp&lt;/result&gt;
    &lt;result name=&quot;login&quot; type=&quot;dispatcher&quot;&gt;/WEB-INF/login.jsp&lt;/result&gt;
&lt;/action&gt;
</code></pre>

</li>
</ol>
<h2>request、session、application使用</h2>
<p>Struts2底层对request、session、application进行了封装，对应Map类型为RequestMap、SessionMap、ApplicationMap。</p>
<ol>
<li>
<p>通用方法ActionContext</p>
<ul>
<li>
<p>获取Map类型的</p>
<p>ActionContext.getSession()</p>
<p>ActionContext.getApplication()</p>
<p>ActionContext.get(&quot;request&quot;)</p>
</li>
<li>
<p>获取Servlet类型的</p>
<p>ServletActionContext.getRequest()</p>
<p>ServletActionContext.getServletContext()</p>
<p>ServletActionContext.getResponse()</p>
</li>
</ul>
</li>
<li>
<p>Action专用方法</p>
<p>Action类实现Aware接口，底层注入对象.</p>
<ul>
<li>
<p>注入Map类型</p>
<p>RequestAware</p>
<p>SessionAware</p>
<p>ApplicationAware</p>
</li>
<li>
<p>注入Servlet类型</p>
<p>ServletRequestAware</p>
<p>ServletResponseAware</p>
<p>ServletContextAware</p>
</li>
</ul>
</li>
</ol>


