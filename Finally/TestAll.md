## JAVA 面试题汇总（附答案）

### 1.Arraylist 与 Linkedlist 的区别

        ArrayList、LinkedList、Vector 和 Stack是 list 的四个实现类，其中 Vector 是基于 JDK1.0，虽然实现了同步，但是效率低，已经不用了，Stack 继承 Vector。
        区别：
            - ArrayList 是实现了基于动态数组的数据结构，而 LinkedList 是基于链表的数据结构
            - 对于随机访问 get 和 set，ArrayList 要优于 LinkedList，LinkedList 不支持高效的随机访问
            - ArrayList 适合查找，LinkedList 适合增删

### 2.重载与重写有什么区别

        Override（重写）
            1、方法名、参数、返回值相同。
            2、子类方法不能缩小父类方法的访问权限。
            3、子类方法不能抛出比父类方法更多的异常(但子类方法可以不抛出异常)。
            4、存在于父类和子类之间。
            5、方法被定义为final不能被重写。
        Overload（重载）
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

        Public static Connection connection = null;
        Public static Properties properties = new Properties();
        Public void Connection getConnection(){
            1、加载驱动。（Class.forname("")） 
        	FileinputStream fis = new FileinputStream(“db.properties”);
        	properties.load(fis);
        	fis.close();
        	
        	String url = properties.getProperty(“url”);
        	String username = properties.getProperty(“username”);
        	String password = properties.getProperty(“password”);
        	String driveClassName = properties.getProperty(“driverClassName”);
        	
        	2、获取链接。（Connection）
        	connection = DriverManager.getConnection(url,username,password);
        	Class.forname(driverClassName);
        	
        	String sql = “select * from S_DEPT”;
        	
        	3、使用Connection创建一个Statement对象。
        	PreparedStatement ps = connection.PrepareStatement(sql);
        	
        	4、执行SQL语句。
        	ResultSet res = ps.executeQuery();
        	
        	while(res.next()){
        		System.out.println(res.getString(“ID”)+","+res.getString(“NAME”)+","+res.getString(“REGION_ID”));
        	}
        	
        	5、释放资源。
        	res.close();
        	ps.close();
        	connection.close();
        }

### 6.HashTable 和 HashMap 有什么区别？

        - Hashmap 是 HashTable的轻量级实现（非线程安全的实现），他们都完成了 Map 接口
        - 主要区别在于 HashMap 允许空（null）键值（key），由于非线程安全，效率上可能高于 HashTable
        - 最大的不同是，HashTable的方法是 Synchronized 的，而 HashMap 不是

### 7.创建多线程的方式有几种？分别是什么？线程死锁是如何产生的？如何防止线程死锁现象？

        方式：
            继承 Thread，实现 Runnable 接口
        产生：
            - 一个资源每次只能被一个进程使用
            - 一个进程因请求发生阻塞时，依然对已获得的资源保持不放
            - 进程已经获得资源使用权，但是一直未使用
            - 同一个进程，频繁的获取资源的优先使用权，一直未释放
        防止：
            - 加锁顺序（线程按照一定的顺序加锁）
            - 加锁时限（线程尝试获取锁的时候加上一定的时限，超过时限则放弃对该锁的请求，并释放自己占有的锁）
            - 死锁检测（一般是将所有的锁存放于 map 对象中，检测 map 中的锁）

### 8.String、StringBuffer、StringBuilder 的区别？

        - 运行速度快慢为：StringBuilder > StringBuffer > String
            String 为字符串常量，而 StringBuffer 和 StringBuilder 均为字符串变量，即 String 对象一旦创建之后该对象不可更改的
        - StringBuilder 是线程不安全的，而 String 和 StringBuffer 是线程安全的

### 9.TCP 和 UDP 的区别？哪个是三次握手协议？

        TCP 稳定性高，效率低，三次握手协议
        UDP 效率较高，稳定性较差

### 10.JSP 的常用指令有哪些？

        三个编译指令为：page、include、taglib
        
        七个动作指令为：jsp:forword、jsp:param、jsp:include、jsp:plugin、jsp:useBean、jsp:setProperty、jsp:getProperty

### 11.DI有几种方式，分别是什么，你常用的是哪种？

        1.Setter 方法
        2.构造器
        3.接口注入
        注解实现注入（常用）

### 12.Mybatis 中 $ 和 # 在 xml 中取值有什么不同？

        mybatis 为我们提供了两种支持动态 sql 的语法：#{} 以及 ${}
        #方式能够很大程度防止 sql 注入，$方式无法防止 sql 注入
        $方式一般用于传入数据库对象，例如传入表名
        #{}将传入的数据都当成一个字符串，会对自动传入的数据加一个双引号
        一般能用#就别用$

### 13.Session 和 Cookie 有什么区别？

        Cookie 存在客户端，Session 数据放在服务器上
        cookie 不是很安全，别人可以分析存放在本地的 cookie 并进行修改
        session 会在一定时间内保存在服务器上，当访问增多，会比较占用你服务器的性能
        单个 cookie 在客户端的限制是3k，就是说一个站点在客户端存放的 cookie 不能大于3k

### 14.GET 和 POST 请求的区别？

        GET：
            1.从服务器上获取数据，一般不能使用在写操作接口
            2.有 URL 所限制，GET 方式传输的大小有所限制，传输的数据量不超过2kb
            3.请求的数据会附加在 URL 之后，以？分隔 URl 和传输数据，多个参数用 & 连接
            4.安全性差
        POST：
            1.向服务器提交数据，一般处理写业务
            2.POST 方式传送的数据量比较大，一般被默认为没有限制，但是实际中会出现限制，主要与 http 协议有关
            3.安全性高
            4.请求的数据内容放在 HTML HEADER 中

### 15.转发（forword）和重定向（redirect）的区别？

        1.效率上：
            转发（forward） > 重定向（redirect）
        2.显示上：
            重定向（redirect）：显示新的 URL
            转发（forward）：地址栏不变
        3.数据上：
            转发（forward）：可以共享 request 里面的数据
            重定向（redirect）：不能共享数据
        4.请求次数：
            重定向（redirect）：两次
            转发（forward）：一次

### 16.&和&&有什么区别？

        & 是按位与的意思，表示把前后的数据转换成二进制后进行操作
        && 是逻辑与，需要前后的条件必须同同时满足才能成立

### 17.需求：有一张表 scoreInfo，字段和数据如下：

        表结构和数据：
            id     subject     score
            1       语文        70
            2       数学        80
            3       英语        50
            4       java        100
        问题：
            请用一条 sql 语句查询出这四条记录并按以下条件显示出来
            （大于或等于80表示优秀，大于或等于60表示及格，小于60分表示不及格）
        结果：
            1     语文     及格
            2     数学     优秀
            3     英语     不及格
            4     java     优秀
        解答：
            select 
                s.id,s.name,
                case when s.score >=80 then '优秀'
                     when s.score >=60 then '及格'
                     when s.score <60 then '不及格'
                     end as scopes
            from scoreinfo s
    
### 18.Hibernate 与 Mybatis 区别？

        1.hibernate 的扩展性和一致性比 mybatis 强
        2.hibernate 不需要写 sql 语句，会自动生成，而 mybatis 则需要写 sql 语句
        3.hibernate 支持事务，一级缓存、二级缓存、查询缓存等
        4.hibernate 自己提供分页功能（setfirst，setmax），mybatis 需要配置分页插件（pagehelper）

### 19.列举 struts2常见的组件有哪些？常见的配置标签有哪些？返回值类型有哪些？

        组件：
            strutsParperAndExcuteFilter
            Action
            Result
            Interceptor
        标签：
            package
            action
            result
            param
            interceptor
        返回值类型：
            dispatcher
            redirect
            redirectAction
            stream
            json

### 20.用最有效率的方法计算出2乘以8等于多少？

        2 << 3

### 21.Spring 常见的注解有哪些？

### 22.Debug 模式下，快捷键有哪些，分别代表什么？

### 23.Tomcat 如何修改端口号？如何清除项目缓存？默认并发量是多少？

### 24.final、finally、finalize 的区别？

### 25.一个汉字几个字节？一个 char 类型的变量，可以存储一个汉字吗？为什么可以或不可以。

### 26.列举至少9个 linux 系统操作命令，并给出汉字解释？

### 27.谈谈 Spring AOP 的原理？