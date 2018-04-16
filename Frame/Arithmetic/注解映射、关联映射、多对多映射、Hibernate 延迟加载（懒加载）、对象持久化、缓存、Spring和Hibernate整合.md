## 注解映射描述

在实体类中使用注解替代hbm.xml描述映射信息.

1. 根据表编写实体类，追加注解标记

		@Entity//实体
		@Table(name="EMP")//对应EMP表
		public class Emp implements Serializable{
			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="ID")
			private int id;
			
			@Column(name="ENAME")
			private String ename;
			
			@Column(name="SEX")
			private String sex;
			
			@Column(name="AGE")
			private int age;
			
			@Column(name="BIRTHDAY")
			private Date birthday;
			
			//省略set和get方法
		
		}


2. 在hibernate.cfg.xml加载实体类

		<mapping class="cn.xdl.entity.Emp"/> 



## 关联映射

关联映射分为一对多、多对一、一对一、多对多等，分别使用<one-to-many>、<many-to-one>、<one-to-one>、<many-to-many>标记定义映射。

Dept --> DEPT (1、主键)

Emp  --> EMP  (n、主键、外键)

1. 案例：查询某个部门及其员工信息

	- 在Dept类追加emps集合属性
	
			private Set<Emp> emps;//通过关联映射加载emp员工

	- 在Dept映射描述中指定<one-to-many>

			<set name="emps">
				<!-- 指定外键字段名 -->
				<key column="deptno"></key>
				<!-- 指定关联映射对象 -->
				<one-to-many class="cn.xdl.entity.Emp"/>
			</set>

	- 编程

			@Test//多次sql单表抓取
			public void test1(){
				Session session = HibernateUtil.getSession();
				Dept dept = session.get(Dept.class, 22);
				System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
				Set<Emp> emps = dept.getEmps();
				for(Emp emp:emps){
					System.out.println(emp.getId()+" "+emp.getEname());
				}
				session.close();
			}
		
			@Test//一次sql联合抓取
			public void test2(){
				Session session = HibernateUtil.getSession();
				//join fetch
				Query<Dept> query = session.createQuery(
					"from Dept d join fetch d.emps where d.no=?");
				query.setParameter(0, 20);
				Dept dept = query.uniqueResult();
				System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
				Set<Emp> emps = dept.getEmps();
				for(Emp emp:emps){
					System.out.println(emp.getId()+" "+emp.getEname());
				}
				session.close();
			}

## 案例：多对一映射

需求：显示员工列表

	显示项：员工编号、员工姓名、所属部门编号、所属部门名称、部门所在地

EMP : 多方
DEPT : 一方

由Emp查找关联的Dept，采用<many-to-one>映射。

1. 在Emp中追加dept属性，用于存储相关的DEPT信息

		private Dept dept;//存储相关的DEPT记录信息

	注意：将原有deptno属性删除，避免重复映射异常。

2. 在Emp的映射描述中使用many-to-one映射

		@ManyToOne(targetEntity=Dept.class)//<many-to-one>
		@JoinColumn(name="DEPTNO")
		private Dept dept;//存储相关的DEPT记录信息

3. 在代码中可以使用emp.getDept().getXxx方式获取部门信息

		@Test//默认采用多个单表sql加载数据
		public void test1(){
			Session session = HibernateUtil.getSession();
			Query<Emp> query = session.createQuery("from Emp");
			List<Emp> list = query.getResultList();
			for(Emp emp:list){
				System.out.println(emp.getId()+" "+emp.getEname()
					+" "+emp.getDept().getNo()+" "+emp.getDept().getName()
					+" "+emp.getDept().getLoc());
			}
			session.close();
		}
	
		@Test//采用一个多表连接查询
		public void test2(){
			Session session = HibernateUtil.getSession();
			Query<Emp> query = session.createQuery("from Emp e join fetch e.dept");
			List<Emp> list = query.getResultList();
			for(Emp emp:list){
				System.out.println(emp.getId()+" "+emp.getEname()
					+" "+emp.getDept().getNo()+" "+emp.getDept().getName()
					+" "+emp.getDept().getLoc());
			}
			session.close();
		}

## 多对多映射

1. 数据表

	- student

		id、sname、sex

	- student_course

		id、sid、cid

	- course

		id、cname

2. 将student和course单独映射

	- student

			@Entity
			@Table(name="STUDENT")
			public class Student implements Serializable{
			
				@Id
				@Column(name="ID")
				private int no;
				@Column(name="SNAME")
				private String name;
				@Column(name="SEX")
				private String sex;
			
				//省略set和get方法
				
			}

	- course

			@Entity
			@Table(name="COURSE")
			public class Course implements Serializable{
			
				@Id
				@Column(name="ID")
				private int no;
				@Column(name="CNAME")
				private String name;
			
				//省略set和get方法	

			}


3. 追加Student到Course的多对多映射

	- 在Student追加集合属性

			private Set<Course> courses;
			
			public Set<Course> getCourses() {
				return courses;
			}
			public void setCourses(Set<Course> courses) {
				this.courses = courses;
			}

	- 在Student映射描述Many-to-Many

			@ManyToMany
			@JoinTable(name="STUDENT_COURSE",
				joinColumns={@JoinColumn(name="SID")},
				inverseJoinColumns={@JoinColumn(name="CID")})
			private Set<Course> courses;

	- 代码中可以使用student.getCourses()获取相关课程信息.

			@Test//多次sql查询
			public void test1(){
				Session session = HibernateUtil.getSession();
				Student stu = session.get(Student.class, 2);
				System.out.println(stu.getNo()+" "+stu.getName()+" "+stu.getSex());
				//查看学员选了哪些课
				Set<Course> courses = stu.getCourses();
				for(Course course:courses){
					System.out.println(course.getNo()+" "+course.getName());
				}
				session.close();
			}
			
			@Test//一次sql查询
			public void test2(){
				Session session = HibernateUtil.getSession();
				Query<Student> query = session.createQuery(
					"from Student s join fetch s.courses where s.no=:no");
				query.setParameter("no", 2);
				Student stu = query.uniqueResult();
				System.out.println(stu.getNo()+" "+stu.getName()+" "+stu.getSex());
				//查看学员选了哪些课
				Set<Course> courses = stu.getCourses();
				for(Course course:courses){
					System.out.println(course.getNo()+" "+course.getName());
				}
				session.close();
			}



## Hibernate延迟加载(懒加载)

在使用一些API查询数据时，并没有立刻发送SQL执行，而是在后续使用时才进行db查询.

	org.hibernate.LazyInitializationException: could not initialize proxy - no Session

异常原因是：使用了延迟加载操作，然后却把session提前关闭了。

涉及的延迟加载查询方法如下：

- session.load()-->get()
- 关联映射属性查询dept.getEmps()-->join fetch
- query.iterator()-->query.list()

解决上述异常方法：1.采用立刻加载替代;2.将session关闭放在最后做。

在Web应用中，DAO不能立刻关闭Session,因为JSP中才访问对象属性显示。会使用Filter或Interceptor将Session关闭封装，放在JSP解析之后执行。（OpenSessionInView模式，支持Hibernate延迟加载），在Spring框架中提供了一个OpenSessionInViewFilter组件。

## 对象持久性

对象持久性： 将对象信息写入文件或者数据库。（Hibernate指的是写入数据库）

Hibernate中Java对象有以下3种状态。

- 临时状态

	刚new出的对象为临时状态.

- 持久状态

	通过session查出的、或通过save、update方法处理的对象为持久状态。

- 游离状态或托管状态

	通过session的close、evict执行后，原有的持久对象就会变成游离状态。


意义：持久状态对象数据状态可以更新到DB，但是临时或游离状态的对象数据改变是不会更新到DB的。


## 缓存

### 一级缓存（默认开启）

属于session级别缓存，每个Session对象都有一个缓存区，从对象创建到close关闭。session缓存是独享。

利用session的get\load\save\update方法都会将对象存入缓存区。可以通过clear\evict方法清除缓存区对象。

优点：同一个session多次查询同一个对象时，只查询一次数据库，后续都是从缓存取出。

### 二级缓存（默认关闭）

属于SessionFactory级别缓存，一个SessionFactory对象只有一个。由SessionFactory创建出的多个Session对象都可以访问二级缓存区。

二级缓存使用方法：

1. 引入二级缓存工具包(ehcache)

		<dependency>
		  <groupId>org.hibernate</groupId>
		  <artifactId>hibernate-ehcache</artifactId>
		  <version>5.2.10.Final</version>
		</dependency>

2. 引入ehcache.xml配置文件

3. 在hibernate.cfg.xml开启二级缓存，指定缓存包类型

		<property name="hibernate.cache.use_second_level_cache">true</property>
		<property name="hibernate.cache.region.factory_class">
			org.hibernate.cache.ehcache.EhCacheRegionFactory
		</property>

4. 在hbm.xml映射描述中追加<cache>标记

		<cache usage="read-write"/>


注意：手动清理二级缓存空间，可以使用sessionFactory.evict方法

### 查询缓存（默认关闭）

查询缓存属于一种特殊的二级缓存，可以多个session共享。一级和二级都只能缓存单个实体对象，不能缓存结果集，如果需要缓存查询结果集只能使用查询缓存。

查询缓存使用方法：

1. 开启二级缓存

		//参考上面二级缓存过程

2. 在hibernate.cfg.xml配置开启查询缓存

		<property name="hibernate.cache.use_query_cache">true</property>

3. 在执行query.list()之前设置查询缓存

		Session session = HibernateUtil.getSession();
		Query<Dept> query = session.createQuery("from Dept");
		query.setCacheable(true);//利用查询缓存机制（先查缓存，没有查数据库然后再放入缓存）
		List<Dept> list = query.list();

## Spring和Hibernate整合

目的：用Spring容器管理Hibernate实现的DAO组件，利用AOP进行事务控制。

### Spring和Hibenate环境搭建

- 引入jar包

		<!-- hibernate开发包 -->
		<dependency>
		  <groupId>org.hibernate</groupId>
		  <artifactId>hibernate-core</artifactId>
		  <version>4.2.21.Final</version>
		</dependency>
		
		<!-- spring-orm整合hibernate包 -->
			<dependency>
		  <groupId>org.springframework</groupId>
		  <artifactId>spring-orm</artifactId>
		  <version>4.1.9.RELEASE</version>
		</dependency>

- 引入hibernate.cfg.xml

		<hibernate-configuration>
		
			<session-factory>
				<property name="dialect">
					org.hibernate.dialect.MySQLDialect
				</property>
				<property name="show_sql">true</property>
				<property name="format_sql">true</property>
				
				<!-- 加载映射描述信息 -->
				<mapping class="cn.xdl.entity.Dept"/> 
		
			</session-factory>
		
		</hibernate-configuration>

- 定义实体类和映射描述

		@Entity
		@Table(name="DEPT")
		public class Dept implements Serializable{
			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="DEPTNO")
			private int deptno;
			@Column(name="DNAME")
			private String dname;
			@Column(name="LOC")
			private String loc;
			//省略set和get方法
		}

### Spring提供了HibernateTemplate

简化编写DAO组件。

- 配置SessionFactory

		<bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
			<!-- 指定datasource -->
			<property name="dataSource" ref="dbcp"></property>
			<!-- 指定hibernate.cfg.xml -->
			<property name="configLocations" value="classpath:hibernate.cfg.xml"></property>
		</bean>

- 配置HibernateTemplate

		<bean id="hibernateTemplate" class="org.springframework.orm.hibernate4.HibernateTemplate">
			<property name="sessionFactory" ref="sessionFactory"></property>	
		</bean>

- 注入HibernateTemplate对象编写DAO

		@Repository("deptDao")
		public class HibernateDeptDao implements DeptDao{
		
			@Autowired
			private HibernateTemplate hibernateTemplate;
			
			public List<Dept> selectAll() {
				List list = hibernateTemplate.find("from Dept");
				return list;
			}
		
			public void save(Dept dept) {
				hibernateTemplate.save(dept);
			}
		
			public Dept selectById(int id) {
				Dept dept = hibernateTemplate.load(Dept.class, id);
				return dept;
			}
		
		}



### Spring提供了OpenSessionInViewFilter

用于支持延迟加载操作。

在web.xml配置Filter，注意必须放在Struts Filter控制器之前。

	<filter>
		<filter-name>opensession</filter-name>
		<filter-class>
		org.springframework.orm.hibernate4.support.OpenSessionInViewFilter
		</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>opensession</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>


### Spring提供了HibernateTransactionManager

用于@Transactional实现事务控制。


	<!-- 启用HibernateTransactionManager事务控制 -->
	<bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory"></property>
	</bean>
	
	<tx:annotation-driven transaction-manager="transactionManager"/>

之后就可以在代码类前或方法前使用@Transactional标记。

