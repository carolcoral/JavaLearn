
<h2>阿里Druid连接池应用</h2>
<ol>
<li>
<p>在pom.xml追加druid定义</p>
<pre><code><parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.4.7.RELEASE</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>

    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc6</artifactId>
        <version>11.2.0.3</version>
    </dependency>

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.6</version>
    </dependency>

    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.2.2</version>
    </dependency>

</dependencies>
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
<pre><code><dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
</code></pre>

</li>
<li>
<p>编写DeptController，利用@RestController、@RequestMapping标记</p>
<pre><code>@RestController//@Controller+@ResponseBody
public class DeptController {

    @Autowired
    private DeptDao deptDao;

    @RequestMapping(value=&quot;/dept&quot;,method=RequestMethod.GET)
    public List<Dept> loadAll(){
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
<p>/dept/list.do-->DispatcherServlet-->HandlerMapping-->ListController-->DeptDao
-->ModelAndView-->ViewResolver-->/list.jsp</p>
<ol>
<li>
<p>编写ListController</p>
<pre><code>@Controller
public class ListController {

    @Autowired
    private DeptDao deptDao;

    @RequestMapping(&quot;/dept/list.do&quot;)
    public ModelAndView list(){
        List<Dept> list = deptDao.loadAll();
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
<pre><code><dependency>
  <groupId>jstl</groupId>
  <artifactId>jstl</artifactId>
  <version>1.2</version>
</dependency>

<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
</code></pre>

</li>
<li>
<p>编写list.jsp，使用JSTL和EL表达式显示</p>
<pre><code><%@ page language=&quot;java&quot; contentType=&quot;text/html; charset=UTF-8&quot;
pageEncoding=&quot;UTF-8&quot;%>
<%@ taglib uri=&quot;http://java.sun.com/jsp/jstl/core&quot; prefix=&quot;c&quot; %>
<!DOCTYPE html PUBLIC &quot;-//W3C//DTD HTML 4.01 Transitional//EN&quot; &quot;http://www.w3.org/TR/html4/loose.dtd&quot;>
<html>
<head>
<meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html; charset=UTF-8&quot;>
<title>Insert title here</title>
</head>
<body>

    <h1>部门列表</h1>
    <table>
        <tr>
            <td>编号</td>
            <td>部门名</td>
            <td>地址</td>
        </tr>
        <c:forEach items=&quot;${depts}&quot; var=&quot;dept&quot;>
        <tr>
            <td>${dept.deptno}</td>
            <td>${dept.dname}</td>
            <td>${dept.loc}</td>
        </tr>
        </c:forEach>
    </table>
</body>
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
<p>/template/list.do-->DispatcherServlet-->HandlerMapping-->TemplateController-->DeptDao-->返回ModelAndView-->thymeleaf模板文件
（src\main\resources\templates）</p>
<ol>
<li>
<p>在pom.xml追加thymeleaf定义</p>
<pre><code><dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
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
        List<Dept> list = deptDao.loadAll();
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
<p>注意：html模板文件，开始和结束标记必须匹配；给< html>元素添加xmlns:th=&quot;http://www.thymeleaf.org&quot;定义。</p>
<pre><code><!DOCTYPE html>
<html xmlns:th=&quot;http://www.thymeleaf.org&quot;>
<head>
<meta charset=&quot;UTF-8&quot;/>
<title>Insert title here</title>
</head>
<body>
    <h1>部门列表(thymeleaf模板)</h1>
    <table>
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>地址</td>
        </tr>
        <tr th:each=&quot;dept:${depts}&quot;>
            <td th:text=&quot;${dept.deptno}&quot;></td>
            <td th:text=&quot;${dept.dname}&quot;></td>
            <td th:text=&quot;${dept.loc}&quot;></td>
        </tr>
    </table>
</body>
</html>
</code></pre>

</li>
</ol>

</body>
</html>

