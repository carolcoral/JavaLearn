<h2>Redis(补充)</h2>
<h3>Redis缓存</h3>
<p>Redis作为系统的缓存，介于业务和关系型数据库之间。</p>
<p><img src="https://github.com/carolcoral/JavaLearn/blob/master/Cache/WechatIMG2.png" /></p>
<p>案例：利用Redis优化部门列表显示</p>
<ol>
<li>
<p>在pom.xml定义boot-redis</p>
<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-redis&lt;/artifactId&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>在application.properties定义redis连接参数</p>
<pre><code>spring.redis.host=localhost
spring.redis.port=6379
</code></pre>

</li>
<li>
<p>注入RedisTemplate&lt;Object,Object&gt;使用</p>
<pre><code>@Controller
public class TemplateController {

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private RedisTemplate&lt;Object, Object&gt; redis;

    @RequestMapping(&quot;/template/list.do&quot;)
    public ModelAndView list(){
        List&lt;Dept&gt; list = null;
        //访问redis,加载缓存数据
        list = (List)redis.opsForValue().get(&quot;depts&quot;);
        //如果缓存没有，去数据库加载，并且将返回结果放入redis缓存
        if(list == null){
            list = deptDao.loadAll();
            redis.opsForValue().set(&quot;depts&quot;, list);
            System.out.println(&quot;从数据库缓存获取数据&quot;);
        }else{
            System.out.println(&quot;从Redis缓存获取数据&quot;);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName(&quot;list&quot;);
        mav.getModel().put(&quot;depts&quot;, list);
        return mav;
    }
}
</code></pre>

</li>
<li>
<p>利用自动启动调用任务提前向缓存加载数据</p>
<pre><code>@Component
@Order(1)
public class MyTask1 implements ApplicationRunner{

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private RedisTemplate&lt;Object, Object&gt; redis;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(&quot;自动执行任务1处理,将部门列表数据加载到缓存&quot;);
        List&lt;Dept&gt; list = deptDao.loadAll();
        redis.opsForValue().set(&quot;depts&quot;, list);
        //将单个dept缓存
        for(Dept dept:list){
            redis.opsForValue().set(&quot;dept:&quot;+dept.getDeptno(), dept);
        }
    }

}
</code></pre>

</li>
</ol>
<h2>Redis持久化机制</h2>
<p>Redis内部提供了RDB和AOF两种持久化机制。</p>
<ol>
<li>
<p>RDB模式</p>
<p>快照机制，快速、但是两次快照之间数据会丢失。默认间隔为1分钟、5分钟、15分钟。（会存在1分钟数据丢失风险）</p>
</li>
<li>
<p>AOF模式</p>
<p>日志模式，将每一个命令都采用日志记录下来。日志文件会很大，恢复时慢。
默认关闭，打开方式将appendonly设置为yes，然后appendfsync参数指定日志记录频率，有always、everysec、no。</p>
</li>
</ol>
<p>提示：两种可以都开启，但是恢复时优先使用日志模式。</p>
<h2>Boot补充</h2>
<ol>
<li>
<p>Mybatis分页处理</p>
<ul>
<li>
<p>添加pom.xml定义</p>
<pre><code>&lt;dependency&gt;
  &lt;groupId&gt;com.github.pagehelper&lt;/groupId&gt;
  &lt;artifactId&gt;pagehelper-spring-boot-starter&lt;/artifactId&gt;
  &lt;version&gt;1.2.3&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

</li>
<li>
<p>代码</p>
<pre><code>PageHelper.startPage(2,5);
List&lt;Dept&gt; list = deptDao.loadAll();
</code></pre>

</li>
</ul>
</li>
<li>
<p>springboot test测试</p>
<p>spring提供了一套test测试框架，与junit结合应用，利用junit启动。</p>
<ul>
<li>测试Spring容器中对象方法</li>
</ul>
<p>将DeptDao对象注入到Test类测试。</p>
<pre><code>    @RunWith(SpringRunner.class)
    @SpringBootTest(classes={MyBootApplication.class})
    public class TestDeptDao {

        @Autowired
        private DeptDao deptDao;

        @Test
        public void test1(){
            List&lt;Dept&gt; list = deptDao.loadAll();
            for(Dept dept:list){
                System.out.println(dept.getDeptno()+&quot; &quot;+dept.getDname());
            }
        }

    }
</code></pre>

<ul>
<li>测试SpringMVC处理流程</li>
</ul>
<p>将Controller注入，然后利用MockMVC、MockResult等API测试MVC流程。</p>
<pre><code>    @RunWith(SpringRunner.class)
    @SpringBootTest(classes={MyBootApplication.class})
    public class TestRestful {

        @Autowired
        private DeptController controller;

        @Test
        public void test1() throws Exception{
            //发送http请求调用resuful服务
            MockMvc mock = MockMvcBuilders.standaloneSetup(controller).build();
            //创建一个/dept/10 GET类型请求
            RequestBuilder getRequest = MockMvcRequestBuilders.get(&quot;/dept/10&quot;);
            //发送请求,获取返回结果信息
            MvcResult result = mock.perform(getRequest).andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.println(content);
        }

    }
</code></pre>

</li>
</ol>
