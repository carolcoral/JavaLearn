
<h2>阿里Druid连接池应用</h2>
<ol>
<li>
<p>在pom.xml追加druid定义</p>
<pre><code>&lt;parent&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;
    &lt;version&gt;1.4.7.RELEASE&lt;/version&gt;
&lt;/parent&gt;

&lt;dependencies&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-jdbc&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;com.oracle&lt;/groupId&gt;
        &lt;artifactId&gt;ojdbc6&lt;/artifactId&gt;
        &lt;version&gt;11.2.0.3&lt;/version&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;junit&lt;/groupId&gt;
        &lt;artifactId&gt;junit&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
      &lt;groupId&gt;com.alibaba&lt;/groupId&gt;
      &lt;artifactId&gt;druid&lt;/artifactId&gt;
      &lt;version&gt;1.1.6&lt;/version&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;org.mybatis.spring.boot&lt;/groupId&gt;
        &lt;artifactId&gt;mybatis-spring-boot-starter&lt;/artifactId&gt;
        &lt;version&gt;1.2.2&lt;/version&gt;
    &lt;/dependency&gt;

&lt;/dependencies&gt;
</code></pre>

</li>
<li>
<p>在application.properties配置连接参数</p>
<pre><code>spring.datasource.username=SCOTT
spring.datasource.password=TIGER
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.driverClassName=oracle.jdbc.OracleDriver
</code></pre>

</li>
<li>
<p>编写Configuration配置组件</p>
<pre><code>@Configuration
public class DruidDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix=&quot;spring.datasource&quot;)
    public DataSource druid(){
    //DruidDataSource ds = new DruidDataSource();
        DataSource ds = 
            DataSourceBuilder.create().type(DruidDataSource.class).build();
        return ds;
    }

}
</code></pre>

</li>
</ol>
<h2>SpringBoot MVC应用</h2>
<h3>开发Web服务（Restful服务）</h3>
<pre><code>/dept   GET  ： 查询所有dept信息
/dept/1 GET  ： 查询id=1的DEPT信息
/dept   POST ： 添加dept信息
/dept/1 PUT  ： 修改id=1的dept信息
/dept/1 DELETE ： 删除id=1的dept信息
</code></pre>

<p>规则变型：查询利用GET、增删改用POST</p>
<pre><code>/dept        GET  ： 查询所有dept信息
/dept/1      GET  ： 查询id=1的DEPT信息
/dept/add    POST ： 添加dept信息
/dept/put    POST ： 修改id=1的dept信息
/dept/remove POST ： 删除id=1的dept信息
</code></pre>

<ol>
<li>
<p>在pom.xml添加spring-boot-starter-web定义</p>
<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>编写DeptController，利用@RestController、@RequestMapping标记</p>
<pre><code>@RestController//@Controller+@ResponseBody
public class DeptController {

    @Autowired
    private DeptDao deptDao;

    @RequestMapping(value=&quot;/dept&quot;,method=RequestMethod.GET)
    public List&lt;Dept&gt; loadAll(){
        return deptDao.loadAll();
    }

    @RequestMapping(value=&quot;/dept/{id}&quot;,method=RequestMethod.GET)
    public MyResult loadDept(@PathVariable(&quot;id&quot;)int no){
        MyResult result = new MyResult();
        Dept dept = deptDao.loadById(no);
        if(dept == null){
            result.setStatus(0);
            result.setMsg(&quot;未找到符合条件记录&quot;);
        }else{
            result.setStatus(1);
            result.setMsg(&quot;查询成功&quot;);
            result.setData(dept);
        } 
        return result;
    }

}
</code></pre>

</li>
<li>
<p>定义共同的返回对象MyResult.java</p>
<pre><code>public class MyResult implements Serializable{

    private int status;//处理结果状态
    private String msg;//提示信息
    private Object data;//返回的数据

    //省略了set和get方法
}
</code></pre>

</li>
</ol>
<h3>开发JSP应用（PC网站应用）</h3>
<p>/dept/list.do--&gt;DispatcherServlet--&gt;HandlerMapping--&gt;ListController--&gt;DeptDao
--&gt;ModelAndView--&gt;ViewResolver--&gt;/list.jsp</p>
<ol>
<li>
<p>编写ListController</p>
<pre><code>@Controller
public class ListController {

    @Autowired
    private DeptDao deptDao;

    @RequestMapping(&quot;/dept/list.do&quot;)
    public ModelAndView list(){
        List&lt;Dept&gt; list = deptDao.loadAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName(&quot;list&quot;);
        mav.getModel().put(&quot;depts&quot;, list);
        return mav;
    }

}
</code></pre>

</li>
<li>
<p>在application.properties添加view参数配置</p>
<pre><code>spring.mvc.view.prefix=/
spring.mvc.view.suffix=.jsp
</code></pre>

</li>
<li>
<p>在pom.xml中追加jstl和tomcat-embed-jasper引擎</p>
<pre><code>&lt;dependency&gt;
  &lt;groupId&gt;jstl&lt;/groupId&gt;
  &lt;artifactId&gt;jstl&lt;/artifactId&gt;
  &lt;version&gt;1.2&lt;/version&gt;
&lt;/dependency&gt;

&lt;dependency&gt;
  &lt;groupId&gt;org.apache.tomcat.embed&lt;/groupId&gt;
  &lt;artifactId&gt;tomcat-embed-jasper&lt;/artifactId&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>编写list.jsp，使用JSTL和EL表达式显示</p>
<pre><code>&lt;%@ page language=&quot;java&quot; contentType=&quot;text/html; charset=UTF-8&quot;
pageEncoding=&quot;UTF-8&quot;%&gt;
&lt;%@ taglib uri=&quot;http://java.sun.com/jsp/jstl/core&quot; prefix=&quot;c&quot; %&gt;
&lt;!DOCTYPE html PUBLIC &quot;-//W3C//DTD HTML 4.01 Transitional//EN&quot; &quot;http://www.w3.org/TR/html4/loose.dtd&quot;&gt;
&lt;html&gt;
&lt;head&gt;
&lt;meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html; charset=UTF-8&quot;&gt;
&lt;title&gt;Insert title here&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;

    &lt;h1&gt;部门列表&lt;/h1&gt;
    &lt;table&gt;
        &lt;tr&gt;
            &lt;td&gt;编号&lt;/td&gt;
            &lt;td&gt;部门名&lt;/td&gt;
            &lt;td&gt;地址&lt;/td&gt;
        &lt;/tr&gt;
        &lt;c:forEach items=&quot;${depts}&quot; var=&quot;dept&quot;&gt;
        &lt;tr&gt;
            &lt;td&gt;${dept.deptno}&lt;/td&gt;
            &lt;td&gt;${dept.dname}&lt;/td&gt;
            &lt;td&gt;${dept.loc}&lt;/td&gt;
        &lt;/tr&gt;
        &lt;/c:forEach&gt;
    &lt;/table&gt;
&lt;/body&gt;
</code></pre>

<p></html></p>
</li>
</ol>
<h3>开发thymeleaf模板应用（PC网站应用）</h3>
<p>模板技术：velocity、freemarker、thymeleaf等。</p>
<p>JSP--》转译成Servlet--》编译Servlet--》运行--》生成HTML响应输出</p>
<p>模板文件+模板表达式（提取模型数据）--》生成HTML响应输出</p>
<p>velocity技术： *.vm+VTL表达式</p>
<p>freemarker技术： *.ftl+FTL表达式</p>
<p>thymeleaf技术： *.html+TH表达式</p>
<p>/template/list.do--&gt;DispatcherServlet--&gt;HandlerMapping--&gt;TemplateController--&gt;DeptDao--&gt;返回ModelAndView--&gt;thymeleaf模板文件
（src\main\resources\templates）</p>
<ol>
<li>
<p>在pom.xml追加thymeleaf定义</p>
<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-thymeleaf&lt;/artifactId&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>编写Controller（与JSP响应Controller相同）</p>
<pre><code>@Controller
public class TemplateController {

    @Autowired
    private DeptDao deptDao;

    @RequestMapping(&quot;/template/list.do&quot;)
    public ModelAndView list(){
        List&lt;Dept&gt; list = deptDao.loadAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName(&quot;list&quot;);
        mav.getModel().put(&quot;depts&quot;, list);
        return mav;
    }

}
</code></pre>

</li>
<li>
<p>在src/main/resources/templates添加模板文件</p>
<p>注意：html模板文件，开始和结束标记必须匹配；给&lt; html&gt;元素添加xmlns:th=&quot;http://www.thymeleaf.org&quot;定义。</p>
<pre><code>&lt;!DOCTYPE html&gt;
&lt;html xmlns:th=&quot;http://www.thymeleaf.org&quot;&gt;
&lt;head&gt;
&lt;meta charset=&quot;UTF-8&quot;/&gt;
&lt;title&gt;Insert title here&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;
    &lt;h1&gt;部门列表(thymeleaf模板)&lt;/h1&gt;
    &lt;table&gt;
        &lt;tr&gt;
            &lt;td&gt;编号&lt;/td&gt;
            &lt;td&gt;名称&lt;/td&gt;
            &lt;td&gt;地址&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr th:each=&quot;dept:${depts}&quot;&gt;
            &lt;td th:text=&quot;${dept.deptno}&quot;&gt;&lt;/td&gt;
            &lt;td th:text=&quot;${dept.dname}&quot;&gt;&lt;/td&gt;
            &lt;td th:text=&quot;${dept.loc}&quot;&gt;&lt;/td&gt;
        &lt;/tr&gt;
    &lt;/table&gt;
&lt;/body&gt;
&lt;/html&gt;
</code></pre>

</li>
</ol>

</body>
</html>

