##MongoDB简介

1. 属于NoSQL之一，分布式文档数据库
2. 存储结构灵活，适应多变的表单数据
3. 提供灵活的查询方法

##MongoDB基本操作命令

1. 库

	use xxx; //创建一个库进入或直接进入库

	db.dropDatabase() //删除当前库

	show databases //查看有哪些库

2. 集合

	- 添加

		db.xxx.insert(json值)
	
	- 查询

		db.xxx.find() //查询所有

		db.xxx.find(json值) //按条件查询		

		db.xxx.find({"dno":{$gt:50}}) //查询dno>50的

		其他:$gt、$gte、$lt、$lte、$ne

		db.xxx.find({"dname":/java6/}) //查询dname 包含java6的记录

	- 更新

		db.xxx.update(条件,更新值)//全部更新

		db.xxx.update(条件,{$set:更新值}) //局部更新

	- 删除

		db.xxx.remove({}) //删除所有记录

		db.xxx.remove(json值) //删除指定条件记录

	- 统计数量

		 db.dept.count({"dname":/java6/})

	- 删除集合

		 db.dept.drop()

	- 查看有哪些集合

		show collections

##Java访问MongoDB

1. 利用mongo-java-driver.jar

	测试获取库名

		@Test
		public void test1() throws Exception{
			MongoClient mongo = new MongoClient("localhost",27017);
			List<String> dbs = mongo.getDatabaseNames();//show databases
			for(String s:dbs){
				System.out.println("库名:"+s);
			}
			mongo.close();
		}
		
	创建dept集合插入记录		

		@Test
		public void test2() throws Exception{
			MongoClient mongo = new MongoClient("localhost",27017);
			DB java16 = mongo.getDB("java16");//use java16
			DBCollection dept = java16.getCollection("dept"); //获取dept集合
			DBObject arr = new BasicDBObject();
			arr.put("deptno", 30);
			arr.put("dname", "H5");
			arr.put("loc", "上海");
			dept.insert(arr);
			mongo.close();
		}
		

	查询dept集合记录

		@Test
		public void test3() throws Exception{
			MongoClient mongo = new MongoClient("localhost",27017);
			DB java16 = mongo.getDB("java16");//use java16
			DBCollection dept = java16.getCollection("dept");
			DBCursor cursor = dept.find();//db.dept.find()
			while(cursor.hasNext()){
				DBObject obj = cursor.next();
				System.out.println(obj.get("deptno")+" "+obj.get("dname")+" "+obj.get("loc"));
			}
			mongo.close();
		}
		

	条件查询

		@Test
		public void test4() throws Exception{
			MongoClient mongo = new MongoClient("localhost",27017);
			DB java16 = mongo.getDB("java16");//use java16
			DBCollection dept = java16.getCollection("dept");
			DBObject params = new BasicDBObject();//{"loc":"北京"}
			params.put("loc", "北京");
			DBCursor cursor = dept.find(params);//db.dept.find({"loc":"北京"})
			while(cursor.hasNext()){
				DBObject obj = cursor.next();
				System.out.println(obj.get("deptno")+" "+obj.get("dname")+" "+obj.get("loc"));
			}
			mongo.close();
		}
	

	更新记录		

		@Test
		public void test5() throws Exception{
			MongoClient mongo = new MongoClient("localhost",27017);
			DB java16 = mongo.getDB("java16");//use java16
			DBCollection dept = java16.getCollection("dept");
			
			DBObject q = new BasicDBObject();//{"deptno":10}
			q.put("deptno", 10);
			
			DBObject o = new BasicDBObject();//{$set:{"dname":"JAVA"}}
			DBObject attr1 = new BasicDBObject();
			attr1.put("dname", "JAVA");
			o.put("$set", attr1);
			
			dept.update(q, o);//db.dept.update({"deptno":10},{$set:{"dname":"JAVA"}})
			
			mongo.close();
		}

2. 使用spring-data-mongodb.jar工具

	MongoTemplate

	- 在pom.xml添加定义

		  	<dependency>
			  <groupId>org.springframework.boot</groupId>
			  <artifactId>spring-boot-starter-data-mongodb</artifactId>
			</dependency>


	- 在application.properties定义mongo参数

			spring.data.mongodb.uri=mongodb://localhost:27017/ovls


	- 注入MongoTemplate操作


			@Autowired//注入
			private MongoTemplate mongo;
			
			@Autowired
			private SubjectMapper subjectDao;
			
			@Test//添加操作
			public void test1(){
				Subject subject = subjectDao.selectByPrimaryKey(20);
				//将subject写入到mongodb
				//mongo.insert(subject,"t_subject");
				mongo.insert(subject); //默认类型名做集合名
			}
			
			
			@Test//查询操作
			public void test2(){
				List<Subject> list = mongo.findAll(Subject.class);
				for(Subject s:list){
					System.out.println(s.getId()+" "+s.getName()+" "+s.getDirectionId());
				}
			}
			
			@Test//条件查询
			public void test3(){
				Query query = new Query();
				query.addCriteria(Criteria.where("directionId").is(1));//where directionId=1
				List<Subject> list = mongo.find(query, Subject.class);
				for(Subject s:list){
					System.out.println(s.getId()+" "+s.getName()+" "+s.getDirectionId());
				}
			}
			
			@Test//删除操作
			public void test4(){
				Query query = new Query();
				query.addCriteria(Criteria.where("id").is(1));
				mongo.remove(query, Subject.class);//按指定条件删除
				
				Subject subject = new Subject();
				subject.setId(20);
				mongo.remove(subject);//删除指定对象，按id做条件删除
			}
			
			@Test//更新操作
			public void test5(){
				Query query = new Query();
				query.addCriteria(Criteria.where("id").is(2));
				
				Update update = new Update();
				update.set("name", "JAVA");
				
				mongo.updateFirst(query, update, Subject.class);
			}


