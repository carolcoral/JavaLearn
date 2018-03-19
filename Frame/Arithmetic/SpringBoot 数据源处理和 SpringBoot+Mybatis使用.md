<body>
<h1>自动配置@EnableAutoConfiguration</h1>
<p>SpringBoot内部提供了大量的组件，组件采用@Configuration+@Bean标记。自动配置组件在spring-boot-autoconfigure-1.4.7.RELEASE.jar的META-INF/spring.factories定义，SpringBoot容器启动时会自动加载定义的Configuration组件，在Spring容器中产生组件对象。</p>
<h2>案例：如何使用DataSource连接池</h2>
<ol>
<li>
<p>添加连接池开发包、驱动包</p>
<pre><code>&lt;parent&gt;
  &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
  &lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;
  &lt;version&gt;1.4.7.RELEASE&lt;/version&gt;
&lt;/parent&gt;

&lt;properties&gt;
    &lt;java.version&gt;1.7&lt;/java.version&gt;
&lt;/properties&gt;

&lt;dependencies&gt;

    &lt;!-- 启用ioc、组件扫描、自动配置 --&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;junit&lt;/groupId&gt;
        &lt;artifactId&gt;junit&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;!-- 包含tomcat连接池、jdbcTemplate --&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter-jdbc&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
      &lt;groupId&gt;com.oracle&lt;/groupId&gt;
      &lt;artifactId&gt;ojdbc6&lt;/artifactId&gt;
      &lt;version&gt;11.2.0.3&lt;/version&gt;
    &lt;/dependency&gt;

&lt;/dependencies&gt;
</code></pre>

</li>
<li>
<p>在application.properties配置连接池参数</p>
<pre><code>spring.datasource.username=SCOTT
spring.datasource.password=TIGER
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.driverClassName=oracle.jdbc.OracleDriver
</code></pre>

</li>
<li>
<p>开启@SpringBootApplication标记创建Spring容器，获取DataSource对象(id为dataSource)</p>
<pre><code>//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MyBootApplication {


}
</code></pre>

<p>测试类</p>
<pre><code>@Test
public void test1(){
    ApplicationContext ac = 
        SpringApplication.run(MyBootApplication.class);
    DataSource ds = ac.getBean(&quot;dataSource&quot;,DataSource.class);
    System.out.println(ds);
}
</code></pre>

</li>
</ol>
<h2>SpringBoot默认连接池原理</h2>
<h3>默认机制：</h3>
<p>SpringBoot利用DataSourceAutoConfiguration创建出id=dataSource的连接池对象。内部创建优先级为：</p>
<ul>
<li>
<p>首先会尝试创建tomcat连接池（tomcat-jdbc包）</p>
<p>spring-boot-starter-jdbc引入后会自动包含tomcat-jdbc包</p>
</li>
<li>
<p>如果创建tomcat-jdbc失败，会创建HikariCP连接池（hikaricp包）</p>
</li>
<li>如果创建HikariCP失败，会创建dbcp连接池（commons-dbcp包）</li>
<li>如果创建dbcp失败，会创建dbcp2连接池（commons-dbcp2包）</li>
</ul>
<h3>如果需要创建指定类型的连接池，可以采用下面方法：</h3>
<p>方法一：利用spring.datasource.type配置</p>
<ul>
<li>
<p>引入选用的连接池的jar包</p>
<pre><code>&lt;dependency&gt;
  &lt;groupId&gt;commons-dbcp&lt;/groupId&gt;
  &lt;artifactId&gt;commons-dbcp&lt;/artifactId&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>在application.properties添加指定类型连接池</p>
<pre><code>spring.datasource.type=org.apache.commons.dbcp.BasicDataSource
</code></pre>

</li>
</ul>
<p>方法二：利用@Configuration+@Bean自定义</p>
<pre><code>package cn.xdl.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDataSourceConfig {

    @Bean
    public DataSource myDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(&quot;SCOTT&quot;);
        ds.setPassword(&quot;TIGER&quot;);
        ds.setUrl(&quot;jdbc:oracle:thin:@localhost:1521:XE&quot;);
        ds.setDriverClassName(&quot;oracle.jdbc.OracleDriver&quot;);
        return ds;
    }

}
</code></pre>

<blockquote>
<p>提示：如果开发者自定义了连接池对象，DataSourceAutoConfiguration会失效。</p>
</blockquote>
<h2>配置参数注入</h2>
<p>在SpringBoot中自动配置组件ConfigurationPropertiesAutoConfiguration，可以将Properties文件中的配置参数注入到Bean对象属性中。</p>
<ul>
<li>
<p>application.properties</p>
<pre><code>#datasource
spring.datasource.username=SCOTT
spring.datasource.password=TIGER
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.driverClassName=oracle.jdbc.OracleDriver
#spring.datasource.type=org.apache.commons.dbcp.BasicDataSource

spring.name=SCOTT
spring.password=1234
</code></pre>

</li>
<li>
<p>利用@ConfigurationProperties注入参数</p>
<pre><code>@Configuration
//@ConfigurationProperties(prefix=&quot;spring&quot;)
public class MyDataSourceConfig {
    //将spring.name注入
    private String name;
    //将spring.password注入
    private String password;

    //省略get和set方法
}
</code></pre>

<p>如果参数名和属性不一致，可以使用@Value(&quot;${xxx}&quot;)表达式指定注入。</p>
</li>
<li>
<p>也可以将@ConfigurationProperties用在@Bean方法上，表示给@Bean对象属性注入参数</p>
<pre><code>@Bean
@ConfigurationProperties(prefix=&quot;spring.datasource&quot;)
public DataSource myDataSource(){
    System.out.println(&quot;----------&quot;+name);
    System.out.println(&quot;----------&quot;+password);
    BasicDataSource ds = new BasicDataSource();
//ds.setUsername(&quot;SCOTT&quot;);
//ds.setPassword(&quot;TIGER&quot;);
//ds.setUrl(&quot;jdbc:oracle:thin:@localhost:1521:XE&quot;);
//ds.setDriverClassName(&quot;oracle.jdbc.OracleDriver&quot;);
    return ds;
}
</code></pre>

<p>提示：@ConfigurationProperties功能由@EnableConfigurationProperties开启，也可以由@EnableAutoConfiguration开启，属于自动配置功能。</p>
</li>
</ul>
<h2>SpringBoot JdbcTemplate（Spring DAO）</h2>
<p>JdbcTemplate也是JdbcTemplateAutoConfiguration自动配置组件创建。在应用中，只需要提供连接参数、jar包，然后直接编写实体类、DAO，注入JdbcTemplate使用。</p>
<ol>
<li>
<p>配置DataSource连接池</p>
<ul>
<li>在pom.xml引入jar包定义</li>
<li>在application.properties定义数据库链接参数</li>
</ul>
</li>
<li>
<p>编写实体类</p>
<p>Dept.java，属性名和类型与数据表保持一致。</p>
</li>
<li>
<p>编写DAO接口和实现类</p>
<p>扫描DAO实现类，并且注入JdbcTemplate使用。</p>
</li>
</ol>
<h2>SpringBoot MyBatis（Spring ORM）</h2>
<ol>
<li>
<p>搭建SpringBoot+MyBatis环境</p>
<p>在pom.xml中添加mybatis-spring-boot-starter定义和DataSource。</p>
<pre><code>&lt;dependency&gt;
  &lt;groupId&gt;org.mybatis.spring.boot&lt;/groupId&gt;
  &lt;artifactId&gt;mybatis-spring-boot-starter&lt;/artifactId&gt;
  &lt;version&gt;1.2.2&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>编写实体类</p>
<pre><code>public class Emp implements Serializable{

    private int empno;
    private String ename;
    private int mgr;
    private String job;
    private Date hiredate;
    private Double comm;
    private Double sal;
    private int deptno;
    //省略了set和get方法
}
</code></pre>

</li>
<li>
<p>编写SQL定义文件</p>
<pre><code>&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; ?&gt;  
&lt;!DOCTYPE mapper PUBLIC &quot;-//mybatis.org//DTD Mapper 3.0//EN&quot; 
&quot;http://mybatis.org/dtd/mybatis-3-mapper.dtd&quot;&gt;

&lt;mapper namespace=&quot;cn.xdl.mapper.EmpDao&quot;&gt;

    &lt;select id=&quot;findAll&quot; resultType=&quot;cn.xdl.entity.Emp&quot;&gt;
        select * from emp
    &lt;/select&gt;

&lt;/mapper&gt;
</code></pre>

</li>
<li>
<p>编写Mapper映射器接口</p>
<pre><code>package cn.xdl.mapper;

import java.util.List;

import cn.xdl.entity.Emp;

public interface EmpDao {

    public List&lt;Emp&gt; findAll();

}
</code></pre>

</li>
<li>
<p>在启动类前追加@MapperScan标记</p>
<pre><code>//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableConfigurationProperties
@MapperScan(basePackages={&quot;cn.xdl.mapper&quot;})//扫描Mapper映射器接口生成对象
public class MyBootApplication {


}
</code></pre>

</li>
<li>
<p>在application.properties追加mybatis.mapper-locations定义</p>
<pre><code>mybatis.mapper-locations=classpath:sql/*.xml
</code></pre>

</li>
</ol>

</body>
</html>
<!-- This document was created with MarkdownPad, the Markdown editor for Windows (http://markdownpad.com) -->
