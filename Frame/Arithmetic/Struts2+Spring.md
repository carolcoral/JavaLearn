## Struts2和Spring整合

 Struts2: MVC结构
 
 Spring: 容器（IOC/AOP）


  ![](https://i.imgur.com/y65Cnrc.png)


##案例：hello world


/hello.action-->Filter控制器-->HelloAction(Spring)-->Result-->/WEB-INF/hello.jsp

1. 搭建Struts2+Spring环境

	- 引入struts2和spring的jar包
	- 引入struts.xml和applicationContext.xml
	- 引入struts2-spring-plugin.jar包

			<dependencies>
			  	<!-- struts相关包 -->
			  	<dependency>
				  <groupId>org.apache.struts</groupId>
				  <artifactId>struts2-core</artifactId>
				  <version>2.5.14.1</version>
				</dependency>
			
				<dependency>
				  <groupId>org.apache.struts</groupId>
				  <artifactId>struts2-json-plugin</artifactId>
				  <version>2.5.14.1</version>
				</dependency>
				
				<!-- 测试包 -->
				<dependency>
				  <groupId>junit</groupId>
				  <artifactId>junit</artifactId>
				  <version>4.12</version>
				</dependency>
			  	
			  	<!-- jsp相关包 -->
				<dependency>
				  <groupId>jstl</groupId>
				  <artifactId>jstl</artifactId>
				  <version>1.2</version>
				</dependency>
				
				
				<!-- struts+spring,会自动将spring相关包引入 -->
				<dependency>
				  <groupId>org.apache.struts</groupId>
				  <artifactId>struts2-spring-plugin</artifactId>
				  <version>2.5.14.1</version>
				</dependency>
			
			</dependencies>

	- 在web.xml配置ContextLoaderListener

			<context-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>classpath:applicationContext.xml</param-value>
			</context-param>
			<!-- 内部加载contextConfigLocation指定的配置文件，创建Spring容器给StrutsSpringObjectFactory访问 -->
			<listener>
				<listener-class>
				org.springframework.web.context.ContextLoaderListener
				</listener-class>
			</listener>

2. 编写HelloAction，将它纳入Spring容器中

	HelloAction.java

		@Controller//默认id名为helloAction
		public class HelloAction {
			
			public String execute(){
				System.out.println("进入HelloAction");
				return "success";
			}
			
		}

	spring配置

		<context:component-scan base-package="cn.xdl"/>

3. 编写hello.jsp

4. 配置Struts2请求响应处理流程

	- 配置Filter控制器

			<filter>
				<filter-name>strutsmvc</filter-name>
				<filter-class>
			org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter
				</filter-class>
				<!-- 默认访问struts.xml -->
			</filter>
			<filter-mapping>
				<filter-name>strutsmvc</filter-name>
				<url-pattern>/*</url-pattern>
			</filter-mapping>

	- 配置Action+Result


			<package name="demo1" extends="struts-default">
				
				<!-- StrutsSpringObjectFactory根据class名做id查找Spring容器的Action对象 -->
				<action name="hello" class="helloAction">
					<result>/WEB-INF/hello.jsp</result>
				</action>
				
			</package>



## 案例：列表显示

### 编写DeptDao

1. 追加spring-jdbc、驱动、dbcp连接池包

		<!-- spring-jdbc/驱动包 -->
		<dependency>
		  <groupId>org.springframework</groupId>
		  <artifactId>spring-jdbc</artifactId>
		  <version>4.1.9.RELEASE</version>
		</dependency>
		
		<dependency>
		  <groupId>mysql</groupId>
		  <artifactId>mysql-connector-java</artifactId>
		  <version>5.1.42</version>
		</dependency>
		
		<dependency>
		  <groupId>commons-dbcp</groupId>
		  <artifactId>commons-dbcp</artifactId>
		  <version>1.4</version>
		</dependency>

2. 编写实体类Dept.java

		public class Dept implements Serializable{
	
			private int deptno;
			private String dname;
			private String loc;
			
			//省略set和get方法
		}

3. 编写DeptDao接口和JdbcDeptDao实现类

	DeptDao接口

		public interface DeptDao {
	
			public List<Dept> selectAll();
			
		}

	JdbcDeptDao实现类

		@Repository("deptDao")
		public class JdbcDeptDao implements DeptDao {
			
			@Autowired
			private JdbcTemplate template;
		
			public List<Dept> selectAll() {
				String sql = "select * from dept";
				RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<Dept>(Dept.class);
				List<Dept> list = template.query(sql, rowMapper);
				return list;
			}
		
		}

4. 配置JdbcDeptDao、JdbcTemplate、dbcp连接池

		<bean id="dbcp" class="org.apache.commons.dbcp.BasicDataSource">
			<property name="username" value="root"></property>
			<property name="password" value="1234"></property>
			<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
			<property name="url" value="jdbc:mysql://localhost:3306/java13"></property>
		</bean>
	
		<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
			<constructor-arg index="0" ref="dbcp">
			</constructor-arg>
		</bean>

5. 测试DeptDao


## ListAction

/list.action-->Filter控制器-->ListAction-->DeptDao-->Result-->/WEB-INF/list.jsp

1. 编写Action,注入DeptDao

		@Controller
		public class ListAction {
			
			private List<Dept> depts;
		
			@Autowired
			private DeptDao deptDao;
			
			public String execute(){
				depts = deptDao.selectAll();
				return "success";
			}
			
			
			public List<Dept> getDepts() {
				return depts;
			}
		
			public void setDepts(List<Dept> depts) {
				this.depts = depts;
			}
		
		}

2. 在struts.xml中配置Action和Result

		<action name="list" class="listAction">
			<result>/WEB-INF/list.jsp</result>
		</action>



## 案例：新增操作

/addDept.action-->Filter控制器-->AddAction
-->DeptDao-->Result-->继续发出list.action请求

1. 在DeptDao追加save方法

		public void save(Dept dept) {
			String sql = "insert into dept (dname,loc) values (?,?)";
			Object[] params = {dept.getDname(),dept.getLoc()};
			template.update(sql,params);
		}

2. 编写AddAction

		@Controller
		public class AddAction {
			
			private Dept dept;//对应dept.dname、dept.loc
		
			@Autowired
			private DeptDao deptDao;
			
			public String execute(){
				deptDao.save(dept);
				System.out.println(dept.getDname());
				return "success";
			}
			
			public Dept getDept() {
				return dept;
			}
		
			public void setDept(Dept dept) {
				this.dept = dept;
			}
		}

3. 配置Action和Result

		<action name="addDept" class="addAction">
			<result name="success" type="redirectAction">
				<param name="actionName">list</param>
			</result>
		</action>

4. 乱码解决方法

		<property name="url" value="jdbc:mysql://localhost:3306/java13?useUnicode=true&amp;characterEncoding=utf8"></property>
