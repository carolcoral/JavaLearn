# 添加操作

## 操作代码

	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	session.save(dept);
	tx.commit();//提交事务
	session.close();

## 主键生成策略

Hibernate提供了一些内置主键生成器

1. identity

	交给数据库自动生成主键值，适合MySQL和SQLServer。（注意：建表时需要追加自动增长设置）

		<id name="no" column="DEPTNO" type="integer">
			<generator class="identity">
			</generator>
		</id>

2. sequence

	采用指定序列生成主键值，适合Oracle和DB2。

		<id name="no" column="DEPTNO" type="integer">
			<generator class="sequence">
				<param name="sequence_name">xxx</param>
			</generator>
		</id>


3. increment

	先查询主键最大值，然后加1再插入，适合各种数据库。

		<id name="no" column="DEPTNO" type="integer">
			<generator class="increment">
			</generator>
		</id>


4. uuid

	采用uuid算法生成一个字符串类型主键值。

		<id name="no" column="DEPTNO" type="integer">
			<generator class="uuid">
			</generator>
		</id>

	(注意：表主键字段类型为varchar)

5. native

	hibernate会根据方言设置自动选择identity或sequence等策略。

		<id name="no" column="DEPTNO" type="integer">
			<generator class="native">
			</generator>
		</id>

6. assigned

	忽略，说明hibernate框架不管生成，需要按程序员指定的id值进行添加。

	（注意：默认值，需要在代码中调用setId(xxx)设置）

7. 自定义主键生成器

	- 编写自定义生成器类,实现IdentifierGenerator接口

			public class DeptId implements IdentifierGenerator{
	
				@Override
				public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
					//追加自定义主键规则逻辑
					return 100;
				}
			
			}

	- 配置生成器

			<id name="no" column="DEPTNO" type="integer">
				<generator class="cn.xdl.util.DeptId">
				</generator>
			</id>


## 更新操作

	@Test
	public void test2(){
		//部分更新，先查询，再修改
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Dept dept = session.get(Dept.class, 21);
		dept.setName("研发部");
		session.update(dept);//属于全部更新，根据id做条件更新其他字段值
		tx.commit();
		session.close();
	}

## 删除操作

	@Test
	public void test3(){
		Dept dept = new Dept();
		dept.setNo(21);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(dept);//根据id做条件删除
		tx.commit();
		session.close();
	}

## findById查询

	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Dept dept = session.get(Dept.class, 21);
		if(dept != null){
			System.out.println(dept.getName()+" "+dept.getLoc());
		}else{
			System.out.println("未找到记录");
		}
		session.close();
	}

## 查询操作

### HQL操作

Hibernate Query Language 面向对象查询语言

HQL语句是针对映射的对象和属性进行查询操作.

HQL语法结构和SQL相同，支持select..from..where..

HQL和SQL区别：

- HQL属于面向对象查询;SQL属于面向结构查询
- HQL用类名和属性名;SQL用表名和字段名
- HQL中类名属性名大小写敏感；SQL中表名和字段名不敏感
- HQL不支持select *写法,需要可以省略
- HQL不支持join..on..中的on语句

SQL: select * from dept
HQL: from Dept

SQL: select * from dept where dname like ?
HQL: from Dept where name like ?

查询所有记录

	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		String hql = "from Dept";
		Query<Dept> query = session.createQuery(hql);
		List<Dept> list = query.list();//执行HQL
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
带条件查询记录

	@Test
	public void test6(){
		Session session = HibernateUtil.getSession();
		String hql = "from Dept where name like ?";
		Query<Dept> query = session.createQuery(hql);
		query.setParameter(0, "java%");//给第一个?设置参数值
		List<Dept> list = query.list();//执行HQL
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
分页查询

	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		String hql = "from Dept";
		Query<Dept> query = session.createQuery(hql);
		//设置分页参数
		query.setFirstResult(5);//抓取记录起点
		query.setMaxResults(5);//最大抓取数量
		List<Dept> list = query.list();//执行HQL
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
统计查询

	@Test
	public void test8(){
		Session session = HibernateUtil.getSession();
		String hql = "select count(*) from Dept";
		Query<Long> query = session.createQuery(hql);
		Long size = query.uniqueResult();
		System.out.println("记录总数:"+size);
		session.close();
	}

### Criteria操作

不足：对分组统计、多表查询、条件查询，会非常复杂。

查询所有记录

	@Test
	public void test10(){
		Session session = HibernateUtil.getSession();
		Criteria ct = session.createCriteria(Dept.class);//from Dept
		List<Dept> list = ct.list();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}

带条件参数查询(Restrictions)

	@Test
	public void test11(){
		Session session = HibernateUtil.getSession();
		Criteria ct = session.createCriteria(Dept.class);//from Dept
		ct.add(Restrictions.like("name", "%java%"));//where name like ?
		ct.addOrder(Order.desc("no"));//order by no desc
		List<Dept> list = ct.list();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}



### NativeSQL操作

执行原始的sql语句。

查询所有记录

	@Test
	public void test14(){
		String sql = "select deptno,dname,loc from dept";
		Session session = HibernateUtil.getSession();
		NativeQuery<Dept> query = session.createNativeQuery(sql,Dept.class);
		List<Dept> list = query.getResultList();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
带条件参数的查询

	@Test
	public void test15(){
		String sql = "select deptno,dname,loc from dept where dname like :name";
		Session session = HibernateUtil.getSession();
		NativeQuery<Dept> query = session.createNativeQuery(sql,Dept.class);
		query.setParameter("name", "%java%");
		List<Dept> list = query.getResultList();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}


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
