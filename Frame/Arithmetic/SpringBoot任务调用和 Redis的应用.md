![](springboot.png)

##SpringBoot任务调用

###服务器启动时自动执行某个任务

SpringBoot提供了两种方法，编写一个组件实现ApplicationRunner或CommandLineRunner。

- ApplicationRunner

		@Component
		@Order(2)
		public class MyTask1 implements ApplicationRunner{
			
			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println("自动执行任务1处理");
			}
		
		}

- CommandLineRunner

		@Component
		@Order(1)
		public class MyTask2 implements CommandLineRunner{
		
			@Override
			public void run(String... args) throws Exception {
				System.out.println("自动执行任务2处理");
			}
		
		}

	提示：可以利用@Order指定任务触发顺序，1、2、3..

###服务器启动后定时自动执行某个任务

案例：每隔5S调用任务打印输出当前时间。

- 在启动类前添加@EnableScheduling，开启Schedul任务调度模块
- 编写任务组件，使用@@Scheduled

		@Component
		public class MyTask3 {
			
		//	@Scheduled(fixedRate=5000,initialDelay=2000)
			@Scheduled(cron="0/5 * * ? * *")
			public void execute(){
				System.out.println("自动执行任务3,时间:"+new Date());
			}
			
		}

通过corn表达式，方便定时，具体语法参考下面资料：

![](cron_expression.png)



#Redis

##Redis简介

Redis是完全基于内存的存储（内存数据库），存储结构为key-value键值对模式，value可以是字符串、列表、集合、有序集合、哈希类型。

Redis是属于NoSQL数据库(非关系型数据库)之一，NoSQL包含：
![](nosql.png)

Redis优点：

- 存取速度异常快速
- 支持持久化（RDB和AOF机制）
- 支持多种存储类型,字符产、集合、列表等
- 适合做应用程序的缓存



##Redis常用命令

1. 字符串操作

	- set key value  //存
	- get key  //取
	- strlen key //取value字符长度
	- incr key //value值加1
	- incrby key n //value值加n
	- decr key //value值减1
	- decrby key n //value值减n
	- append key str //将str拼接到原来value后面

2. key操作

	- del key //删除key
	- keys pattern //查看有哪些key
	- expire key 秒  //指定失效时长,单位秒
	- pexpire key 毫秒 //指定失效时长,单位毫秒
	- type key //查看value类型

3. 哈希操作(Java map, Redis hash)

	- hset key 字段名 字段值
	- hmset key 字段名1 字段值1 字段名2 字段值2
	- hget key 字段名
	- hmget key 字段名1 字段名2
	- hlen key //返回字段数量
	- hkeys key //返回字段名
	- hdel key 字段名 //删除字段名

4. 列表操作(Java List, Redis list)

 	- lpush key value  //从头部添加
	- rpush key value  //从结尾添加
	- lrange key begin end //获取指定区间的元素
	- llen key //返回集合元素数
	- lpop key //将头部元素弹出
	- rpop key //将尾部元素弹出

5. 集合操作(Java Set, Redis set)

	- sadd key value  //存值
	- smembers key  //取值
	- srem key value //删除元素
	- scard key //获取元素数量
	- srandmember key n //获取n个随机元素
	- spop key //弹出一个随机元素

6. 有序集合操作(Java TreeSet, Redis zet)

	- zadd key score value //存值
	- zrange key begin end //获取元素（由小到大）
	- zrevrange key begin end //获取元素（由大到小）
	- zcard key //获取元素个数
	- zcount key min max //统计分数区间个数



##Java访问Redis

###原始API Jedis对象操作

1. 测试连接

		@Test
		public void test1(){
			Jedis jedis = new Jedis("localhost",6379);
			System.out.println(jedis.ping());
			jedis.close();
		}
	
2. 查看所有key

		@Test
		public void test2(){
			Jedis jedis = new Jedis("localhost",6379);
			
			Set<String> keys = jedis.keys("*");//keys *
			for(String s:keys){
				System.out.println(s);
			}
			
			jedis.close();
		}
	
3. 字符串存取

		@Test
		public void test3(){
			Jedis jedis = new Jedis("localhost",6379);
			jedis.set("java", "hello redis");
			String name = jedis.get("name");
			System.out.println(name);
			jedis.close();
		}
	
4. 哈希操作

		@Test
		public void test4(){
			Jedis jedis = new Jedis("localhost",6379);
			String name = jedis.hget("myhash1", "name");
			System.out.println("name:"+name);
			String no = jedis.hget("myhash1", "no");
			System.out.println("no:"+no);
			jedis.close();
		}

###封装API RedisTemplate（spring-data）

1. 在pom.xml添加spring-boot-starter-redis定义

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-redis</artifactId>
		</dependency>

2. 在application.properties添加redis连接参数

		spring.redis.host=localhost
		spring.redis.port=6379

3. 获取Spring容器中RedisTemplate使用

	- 写入Java对象
	
			@Test
			public void test2(){
				ApplicationContext ac = 
					SpringApplication.run(MyBootApplication.class);
				RedisTemplate template = 
					ac.getBean("redisTemplate",RedisTemplate.class);
				
				Dept dept = new Dept();
				dept.setDeptno(1);
				dept.setDname("SpringBoot");
				
				template.opsForValue().set("spring", dept);
				
			}
	
	- 读取Java对象

			@Test
			public void test3(){
				ApplicationContext ac = 
					SpringApplication.run(MyBootApplication.class);
				RedisTemplate template = 
					ac.getBean("redisTemplate",RedisTemplate.class);
				Dept dept = (Dept)template.opsForValue().get("spring");
				System.out.println(dept.getDeptno()+" "+dept.getDname());
			}
