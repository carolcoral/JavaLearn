<h1>分布式服务架构（微服务架构）</h1>
<p>目前主流实现：Dubbo+zookeeper和SpringBoot+Cloud</p>
<p>利用上述技术都可以将功能服务分散到不同服务器部署，然后实现服务间通信（调用）。</p>
<p>请求--&gt;处理1--&gt;处理2--&gt;响应。意思可以将处理1和处理2做成独立服务分开部署，然后再进行RPC（Dubbo）或HTTP请求和响应模式(Cloud)交互。</p>
<p>Dubbo和Cloud的区别如下：</p>
<ul>
<li>Dubbo和Cloud服务调用机制不同，一个RPC、一个HTTP请求响应</li>
<li>Dubbo一般和zookeeper结合管理服务，Cloud内置集成Eureka管理服务</li>
<li>Cloud提供一套服务管理的完整方案、Dubbo需要跟其他技术集成使用。</li>
<li>Cloud仅用于Rest服务管理、Dubbo是将组件服务化管理</li>
</ul>
<h1>Spring Cloud</h1>
<p>Spring Cloud是一系列框架的有序集合。它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等。</p>
<ul>
<li>Spring Cloud Netflix</li>
</ul>
<p>　　是对Netflix开发的一套分布式服务框架的封装，包括服务的发现和注册，负载均衡、断路器、REST客户端、请求路由等。</p>
<ul>
<li>Spring Cloud Config</li>
</ul>
<p>　　将配置信息中央化保存, 配置Spring Cloud Bus可以实现动态修改配置文件</p>
<ul>
<li>Spring Cloud Bus</li>
</ul>
<p>　　分布式消息队列，是对Kafka, MQ的封装</p>
<ul>
<li>Spring Cloud Security</li>
</ul>
<p>　　对Spring Security的封装，并能配合Netflix使用</p>
<ul>
<li>Spring Cloud Zookeeper</li>
</ul>
<p>　　对Zookeeper的封装，使之能配置其它Spring Cloud的子项目使用</p>
<ul>
<li>
<p>Spring Cloud Eureka</p>
<p>Spring Cloud Eureka 是 Spring Cloud Netflix 微服务套件中的一部分，它基于Netflix Eureka 做了二次封装，主要负责完成微服务架构中的服务治理功能。</p>
</li>
</ul>
<h1>基于SpringCloud实现服务注册、查找、负载功能</h1>
<h2>搭建SpringCloud服务中心（eureka）</h2>
<ol>
<li>
<p>创建maven project，引入pom.xml定义</p>
<pre><code>&lt;parent&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;
    &lt;version&gt;1.4.7.RELEASE&lt;/version&gt;
    &lt;relativePath/&gt;
&lt;/parent&gt;

&lt;properties&gt;
    &lt;java.version&gt;1.7&lt;/java.version&gt;
&lt;/properties&gt;

&lt;dependencies&gt;
&lt;!-- springcloud-eureka-server --&gt;
&lt;dependency&gt;
  &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
  &lt;artifactId&gt;spring-cloud-starter-eureka-server&lt;/artifactId&gt;
  &lt;version&gt;1.3.4.RELEASE&lt;/version&gt;
&lt;/dependency&gt;

&lt;/dependencies&gt;

&lt;dependencyManagement&gt;
&lt;dependencies&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
      &lt;artifactId&gt;spring-cloud-starter-parent&lt;/artifactId&gt;
      &lt;version&gt;Brixton.SR5&lt;/version&gt;
      &lt;type&gt;pom&lt;/type&gt;
    &lt;/dependency&gt;
&lt;/dependencies&gt;
&lt;/dependencyManagement&gt;
</code></pre>

</li>
<li>
<p>追加application.properties中eureka参数定义</p>
<pre><code>#eureka
#spring.application.name=EUREKA-SERVER
eureka.client.registerWithEureka=false
eureka.client.fetchRegistry=false
eureka.client.serviceUrl.defaultZone=http://localhost:7777/eureka
</code></pre>

</li>
<li>
<p>追加启动类,使用@EnableEurekaServer</p>
<pre><code>@EnableEurekaServer//启动eureka服务器
@SpringBootApplication
public class EurekaServerBootApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaServerBootApplication.class, args);
    }

}
</code></pre>

</li>
<li>
<p>启动程序测试</p>
<p>打开浏览器输入http://localhost:7777</p>
</li>
</ol>
<h2>向SpringCloud注册Service服务（Restful服务）</h2>
<ol>
<li>
<p>在工程中pom.xml中引入jar包定义</p>
<pre><code>&lt;dependencyManagement&gt;
    &lt;dependencies&gt;
        &lt;dependency&gt;
          &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
          &lt;artifactId&gt;spring-cloud-starter-parent&lt;/artifactId&gt;
          &lt;version&gt;Brixton.SR5&lt;/version&gt;
          &lt;type&gt;pom&lt;/type&gt;
        &lt;/dependency&gt;
    &lt;/dependencies&gt;
&lt;/dependencyManagement&gt;
&lt;dependencies&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
      &lt;artifactId&gt;spring-cloud-starter-eureka&lt;/artifactId&gt;
      &lt;version&gt;1.3.4.RELEASE&lt;/version&gt;
    &lt;/dependency&gt;
    &lt;!-- 指定导入jackson包版本，避免eureka和boot冲突 --&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;
      &lt;artifactId&gt;jackson-annotations&lt;/artifactId&gt;
      &lt;version&gt;2.8.8&lt;/version&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;
      &lt;artifactId&gt;jackson-core&lt;/artifactId&gt;
      &lt;version&gt;2.8.8&lt;/version&gt;
    &lt;/dependency&gt;
&lt;/dependencies&gt;
</code></pre>

</li>
<li>
<p>在application.properties文件追加eureka定义</p>
<pre><code>spring.application.name=PAPER-SERVICE
eureka.client.serviceUrl.defaultZone=http://localhost:7777/eureka
</code></pre>

</li>
<li>
<p>在启动类前追加@EnableDiscoveryClient</p>
<pre><code>@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages=&quot;cn.xdl.ovls.paper.dao&quot;)
public class PaperBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperBootApplication.class, args);
    }

}
</code></pre>

</li>
<li>
<p>启动程序测试</p>
<p>先启动Eureka服务中心项目，然后启动服务项目。</p>
<p>浏览器输入http://localhost:7777就可以查看注册实例</p>
</li>
</ol>
<h2>SpringCloud服务调用(RestTemplate模式)</h2>
<ol>
<li>
<p>在项目中pom.xml引入定义</p>
<pre><code>&lt;!-- ribbon --&gt;
&lt;dependency&gt;
  &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
  &lt;artifactId&gt;spring-cloud-starter-eureka&lt;/artifactId&gt;
  &lt;version&gt;1.3.4.RELEASE&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
  &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
  &lt;artifactId&gt;spring-cloud-starter-ribbon&lt;/artifactId&gt;
  &lt;version&gt;1.3.4.RELEASE&lt;/version&gt;
&lt;/dependency&gt;

&lt;dependencyManagement&gt;
    &lt;dependencies&gt;
        &lt;dependency&gt;
          &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
          &lt;artifactId&gt;spring-cloud-starter-parent&lt;/artifactId&gt;
          &lt;version&gt;Brixton.SR5&lt;/version&gt;
          &lt;type&gt;pom&lt;/type&gt;
        &lt;/dependency&gt;
    &lt;/dependencies&gt;
&lt;/dependencyManagement&gt;
</code></pre>

</li>
<li>
<p>在application.properties追加eureka参数</p>
<pre><code>eureka.client.serviceUrl.defaultZone=http://localhost:7777/eureka
</code></pre>

</li>
<li>
<p>创建RestTemplate对象，追加@LoadBalanced，启用ribbon负载功能</p>
<pre><code>@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced//追加ribbon负载功能
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

}
</code></pre>

</li>
<li>
<p>注入RestTemplate对象，利用服务名调用Restful服务</p>
<pre><code>@Autowired
private RestTemplate template;

//url规则： http://注册服务名/请求名
ResponseResult result = template.getForObject(
    &quot;http://SUBJECT-SERVICE/subject&quot;, ResponseResult.class);
</code></pre>

</li>
<li>
<p>在启动类前，追加@EnableDiscoveryClient</p>
<pre><code>@EnableDiscoveryClient//启用服务注册和查找
@SpringBootApplication
public class ExamWebBootApplication {

    public static void main(String[] args){
        SpringApplication.run(ExamWebBootApplication.class, args);
    }

}
</code></pre>

</li>
<li>
<p>启动测试</p>
</li>
</ol>
<h2>SpringCloud服务调用(Feign接口对象模式)</h2>
<ol>
<li>
<p>在pom.xml中追加ribbon和feign定义</p>
<pre><code>&lt;dependencies&gt;
    &lt;!-- ribbon --&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
      &lt;artifactId&gt;spring-cloud-starter-eureka&lt;/artifactId&gt;
      &lt;version&gt;1.3.4.RELEASE&lt;/version&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
      &lt;artifactId&gt;spring-cloud-starter-ribbon&lt;/artifactId&gt;
      &lt;version&gt;1.3.4.RELEASE&lt;/version&gt;
    &lt;/dependency&gt;

    &lt;!-- feign调用 --&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
      &lt;artifactId&gt;spring-cloud-starter-feign&lt;/artifactId&gt;
      &lt;version&gt;1.3.4.RELEASE&lt;/version&gt;
    &lt;/dependency&gt;

&lt;/dependencies&gt;

&lt;dependencyManagement&gt;
    &lt;dependencies&gt;
        &lt;dependency&gt;
          &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;
          &lt;artifactId&gt;spring-cloud-starter-parent&lt;/artifactId&gt;
          &lt;version&gt;Brixton.SR5&lt;/version&gt;
          &lt;type&gt;pom&lt;/type&gt;
        &lt;/dependency&gt;
    &lt;/dependencies&gt;
</code></pre>

<p></dependencyManagement></p>
</li>
<li>
<p>在application.properties中配置eureka参数</p>
<pre><code>eureka.client.serviceUrl.defaultZone=http://localhost:7777/eureka
</code></pre>

</li>
<li>
<p>定义远程Feign接口，追加@FeignClient标记</p>
<pre><code>@FeignClient(name=&quot;SUBJECT-SERVICE&quot;)//指定注册服务名
public interface SubjectRemote {

    //方法参考Controller定义编写
    @RequestMapping(value=&quot;/subject&quot;,method=RequestMethod.GET)
    public ResponseResult loadSubjects();

}
</code></pre>

</li>
<li>
<p>注入Feign接口对象调用远程服务</p>
<pre><code>@Autowired
private SubjectRemote subjectRemote;
//利用Feign接口对象方法调用远程服务
ResponseResult result = subjectRemote.loadSubjects();
</code></pre>

</li>
<li>
<p>在主入口类中追加@EnableFeignClients和@EnableDiscoveryClient标记</p>
<pre><code>@EnableFeignClients//启用Feign接口模式调用服务
@EnableDiscoveryClient//启用服务注册和查找
@SpringBootApplication
public class ExamWebBootApplication {

    public static void main(String[] args){
        SpringApplication.run(ExamWebBootApplication.class, args);
    }

}
</code></pre>

</li>
<li>
<p>启动程序测试</p>
</li>
</ol>


