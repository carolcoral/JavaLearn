# JAVA 测试题（总）

### 1.Arraylist 与 Linkedlist 的区别

        ArrayList实现了List接口,它是以数组的方式来实现的,数组的特性是可以使用索引的方式来快速定位对象的位置,因此对于快速的随机取得对象的需求,使用ArrayList实现执行效率上会比较好. 
        LinkedList是采用链表的方式来实现List接口的,它本身有自己特定的方法，如: addFirst(),addLast(),getFirst(),removeFirst()等. 由于是采用链表实现的,因此在进行insert和remove动作时在效率上要比ArrayList要好得多!适合用来实现Stack(堆栈)与Queue(队列),前者先进后出，后者是先进先出.

### 2.重载与重写有什么区别

        override（重写）
        　　 1、方法名、参数、返回值相同。
        　　 2、子类方法不能缩小父类方法的访问权限。
        　　 3、子类方法不能抛出比父类方法更多的异常(但子类方法可以不抛出异常)。
        　　 4、存在于父类和子类之间。
        　　 5、方法被定义为final不能被重写。
        overload（重载）
        　　1、参数类型、个数、顺序至少有一个不相同。 
        　　2、不能重载只有返回值不同的方法名。
        　　3、存在于父类和子类、同类中。

### 3.&和&&有什么区别

        在java的逻辑运算符中，有这么四类：&&（短路与），&（与），|（或），||（短路或）。
        &&和&都是表示与，区别是&&只要满足第一个条件，后面条件就不再判断。而&要对所有的条件都进行判断。

### 4.接口和抽象类有什么区别

        1.定义抽象类的关键字是class，而定义接口的关键字是intenface；
    	2.继承抽象类使用extends，而实现接口使用implements；
    	3.抽象类支持单继承，而接口支持多实现；
    	4.抽象类可以有构造方法，而接口中不可以有；
    	5.接口中只允许出现常量，而抽象类中可以有变量；
    	6.接口中只允许有抽象方法，而抽象类可以有非抽象方法；
    	7.接口中增加方法一定会影响实现类，而抽象类可以不影响；


### 5.写出 JDBC 操作数据库的步骤

        1、加载驱动。（Class.forname("")） 
        2、获取链接。（Connection） 
        3、使用Connection创建一个Statement对象。 
        4、执行SQL语句。 
        5、释放资源。
        
        Public static Connection connection = null;
        Public static Properties properties = new Properties();
        Public void Connection getConnection(){
        	FileinputStream fis = new FileinputStream(“db.properties”);
        	properties.load(fis);
        	fis.close();
        	String url = properties.getProperty(“url”);
        	String username = properties.getProperty(“username”);
        	String password = properties.getProperty(“password”);
        	String driveClassName = properties.getProperty(“driverClassName”);
        	connection = DriverManager.getConnection(url,username,password);
        	Class.forname(driverClassName);
        	String sql = “select * from S_DEPT”;
        	PreparedStatement ps = connection.PrepareStatement(sql);
        	ResultSet res = ps.executeQuery();
        	while(res.next()){
        		System.out.println(res.getString(“ID”)+","+res.getString(“NAME”)+","+res.getString(“REGION_ID”));
        	}
        	res.close();
        	ps.close();
        	connection.close();
        }

