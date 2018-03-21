
<h2>SpringBootMVC异常处理</h2>
<p>SpringBoot有一个ErrorMvcAutoConfiguration自动配置组件，默认加载BasicErrorController，Controller中定义了两个/error处理。（一个html响应、一个json响应）</p>
<p>当MVC程序底层发生异常，会自动转向/error请求处理，显示错误界面。</p>
<h3>自定义ErrorController（全局处理）</h3>
<p>自定义ErrorController组件，需要实现ErrorController接口或继承AbstractErrorController都可以。</p>
<pre><code>@Controller
public class MyErrorController implements ErrorController{

    //自定义/error请求处理逻辑
    @RequestMapping(&quot;/error&quot;)
    public ModelAndView error(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName(&quot;error&quot;);//error.html
        return mav;
    }

    @Override
    public String getErrorPath() {
        return &quot;/error&quot;;
    }

}
</code></pre>

<h3>使用@ExceptionHandler</h3>
<p>处理某个Controller异常，应用方法就是在Controller添加带Exception参数的方法，然后使用@ExceptionHandler标记。</p>
<pre><code>@ExceptionHandler
@ResponseBody
public MyResult handlerException(Exception e){
    MyResult result = new MyResult();
    result.setStatus(0);
    result.setMsg(&quot;参数有错&quot;);
    result.setData(e.getMessage());
    return result;
}
</code></pre>

<h2>SpringBootMVC拦截器</h2>
<ol>
<li>
<p>编写拦截器组件，实现HandlerInterceptor接口</p>
<pre><code>@Component//扫描
public class SomeInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(&quot;开始执行Controller处理&quot;);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(&quot;Controller执行完毕&quot;);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        String param = request.getQueryString();
        System.out.println(request.getRequestURI()+&quot;?&quot;+param+&quot;请求处理完毕&quot;);
    }

}
</code></pre>

</li>
<li>
<p>配置拦截器</p>
<pre><code>@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    private SomeInterceptor some;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(some).addPathPatterns(&quot;/compute.do&quot;);
    }

}
</code></pre>

</li>
</ol>
<h2>SpringBoot AOP</h2>
<p>AOP关键概念：切面、切入点、通知。</p>
<p>案例：记录每个Controller方法执行的时间</p>
<pre><code>- 切面：计算方法执行时间
- 切入点：所有Controller方法 within(cn.xdl.controller.*)
- 通知：环绕通知 @Around
</code></pre>

<ol>
<li>
<p>在pom.xml追加aop定义</p>
<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-aop&lt;/artifactId&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>编写切面组件，使用@Aspect、@Around等标记</p>
<pre><code>@Component//ioc
@Aspect//定义为切面
public class WatchBean {

    @Around(&quot;within(cn.xdl.controller.*)&quot;)
    public Object execute(ProceedingJoinPoint pjp) throws Throwable{
        //开始计时
        StopWatch watch = new StopWatch();
        watch.start();
        Object obj = pjp.proceed();//执行controller方法
        //结束计时
        watch.stop();
        long time = watch.getTotalTimeMillis();//执行时长
        String targetClass = pjp.getTarget().getClass().getName();//组件名
        String methodName = pjp.getSignature().getName();//方法名
        System.out.println(&quot;组件：&quot;+targetClass+&quot;方法:&quot;+methodName+&quot;执行时长为:&quot;+time+&quot;ms&quot;);
        return obj;
    }

}
</code></pre>

</li>
</ol>
<h2>SpringBoot静态资源管理</h2>
<p>在SpringBoot工程中，默认静态资源目录如下：</p>
<pre><code>src/main/resources/public (最低)
src/main/resources/static
src/main/resources/resources
src/main/resources/META-INF/resources（最高）
</code></pre>

<p>资源目录根据优先级，从高到低查找。</p>
<p>如果需要自定义静态资源存储路径，可以采用下面配置类</p>
<pre><code>@Configuration
public class MyResourceConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(&quot;/mystatic/**&quot;)
            .addResourceLocations(&quot;classpath:/mystatic/&quot;);
    }

}
</code></pre>

<p>提示：不要使用/**映射，会破坏原有默认静态资源访问。</p>
<h2>SpringBoot对JavaWeb集成</h2>
<ol>
<li>
<p>Servlet</p>
<ul>
<li>编写Servlet组件，继承HttpServlet</li>
<li>利用@WebServlet注解配置</li>
<li>在启动类中，添加@ServletComponentScan</li>
<li>
<p>案例代码</p>
<pre><code>@WebServlet(name=&quot;helloservlet&quot;,urlPatterns=&quot;/hello.do&quot;)
public class HelloServlet extends HttpServlet{

    public void service(
        HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType(&quot;text/html;charset=UTF-8&quot;);
        PrintWriter out = response.getWriter();
        out.println(&quot;Hello Servlet&quot;);
        out.close();

    }

}
</code></pre>

</li>
</ul>
</li>
<li>
<p>Filter</p>
<ul>
<li>编写Filter组件，实现Filter接口</li>
<li>利用@WebFilter注解配置</li>
<li>在启动类中，添加@ServletComponentScan</li>
<li>
<p>案例代码</p>
<pre><code>@WebFilter(urlPatterns=&quot;/hello.do&quot;,filterName=&quot;somefilter&quot;)
public class SomeFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(&quot;-----doFilter------&quot;);
        chain.doFilter(request, response);//调用后续servlet\jsp等

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
</code></pre>

</li>
</ul>
</li>
<li>
<p>Listener</p>
<ul>
<li>编写Listener组件</li>
<li>利用@WebListener注解配置</li>
<li>在启动类中，添加@ServletComponentScan</li>
</ul>
</li>
<li>
<p>启用druid连接池的监控功能</p>
<ul>
<li>
<p>配置启用StatViewServlet组件</p>
<pre><code>@WebServlet(urlPatterns=&quot;/druid/*&quot;,initParams={
    @WebInitParam(name=&quot;loginUsername&quot;,value=&quot;xdl&quot;),
    @WebInitParam(name=&quot;loginPassword&quot;,value=&quot;123&quot;)
})
public class DruidStatServlet extends StatViewServlet{

}
</code></pre>

</li>
<li>
<p>配置启用WebStatFilter组件</p>
<pre><code>@WebFilter(urlPatterns=&quot;/*&quot;,initParams={
@WebInitParam(name=&quot;exclusions&quot;,value=&quot;*.js,*.jpg,*.css,/druid/*&quot;)
})
public class DruidStatFilter extends WebStatFilter{

}
</code></pre>

</li>
<li>
<p>打开浏览器访问</p>
<p>http://localhost:xxxx/druid/index.html</p>
</li>
</ul>
</li>
</ol>

</body>
</html>

