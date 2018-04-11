# Hibernate框架

##简介

  Hibernate是一个持久层框架，用于实现对数据库操作（关系型数据库）。

  程序员使用Hibernate可以将数据库记录映射成Java对象，然后在业务中对对象操作，hibernate就会自动完成对数据库操作。

  MyBatis和Hibernate区别

  - Hibernate可以自动生成SQL对数据库操作;MyBatis需要手写SQL语句。
  - Hibernate封装复杂度高、学习难度大;MyBatis简单容易使用。
  - Hibernate关联映射有很多种类，比如一对多，多对一，一对一，多对多等;MyBatis只有两种加载一个记录、加载多个记录。
  - Hibernate缓存种类很多，比如一级，二级，查询缓存;Mybatis只有一种缓存。
  - Hibernate自动生成SQL，自动映射SQL参数；MyBatis采用#{key}映射SQL参数。


##结构

![](https://github.com/carolcoral/JavaLearn/blob/master/Cache/hibernate.png?raw=true)

##入门示例

1. 搭建环境

	- 引入jar包

		  <dependencies>
  
		  	<!-- hibernate -->
		  	<dependency>
			  <groupId>org.hibernate</groupId>
			  <artifactId>hibernate-core</artifactId>
			  <version>5.2.10.Final</version>
			</dependency>
		  
		  	<dependency>
			  <groupId>mysql</groupId>
			  <artifactId>mysql-connector-java</artifactId>
			  <version>5.1.42</version>
			</dependency>
		  
		  </dependencies>

			<build>  
				<plugins>  
				    <plugin>  
				        <groupId>org.apache.maven.plugins</groupId>  
				        <artifactId>maven-compiler-plugin</artifactId>  
				        <version>3.1</version>  
				        <configuration>  
				            <source>1.8</source>  
				            <target>1.8</target>  
				        </configuration>  
				    </plugin>  
				</plugins>  
			</build>

	- 引入hibernate.cfg.xml配置文件

			<session-factory>
				<property name="dialect">
					org.hibernate.dialect.MySQLDialect
				</property>
				<property name="connection.url">
					jdbc:mysql://localhost:3306/java13
				</property>
				<property name="connection.username">root</property>
				<property name="connection.password">1234</property>
				<property name="connection.driver_class">
					com.mysql.jdbc.Driver
				</property>
				<property name="show_sql">true</property>
				<property name="format_sql">true</property>
				<!-- 加载映射描述信息 -->
				<mapping resource="cn/xdl/hbm/Dept.hbm.xml" />
		
			</session-factory>


2. 编写实体类

		public class Dept implements Serializable{

			private int no; //DEPTNO
			private String name; //DNAME
			private String loc; //LOC
		
			//省略get和set方法
		}

3. 编写映射描述

		<hibernate-mapping>
			<class name="cn.xdl.entity.Dept" table="DEPT">
				<id name="no" column="DEPTNO" type="integer"></id>
				<property name="name" column="DNAME" type="string"></property>
				<property name="loc" column="LOC" type="string"></property>
			</class>
		</hibernate-mapping>

4. 获取Session操作对象

		public class HibernateUtil {
	
			public static Session getSession(){
				//Configuration
				Configuration conf = new Configuration();
				conf.configure("hibernate.cfg.xml");
				//SessionFactory
				SessionFactory factory = conf.buildSessionFactory();
				//Session
				Session session = factory.openSession();
				return session;
			}
			
			public static void main(String[] args){
				Session session = HibernateUtil.getSession();
				Dept dept = session.get(Dept.class, 1);//按id=1查询DEPT
				System.out.println(dept.getName()+" "+dept.getLoc());
			}
			
		}
