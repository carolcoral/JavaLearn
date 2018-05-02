@CopyRight Carol

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

        @Autowired -- 自动装配
        @Component -- 自动支持自动装配
        @Respository -- DAO 层实现
        @Service -- Service 层实现
        @Controller -- WEB 层实现

### 22.Debug 模式下，快捷键有哪些，分别代表什么？

        F5：进入方法内
        F6：执行下一步
        F7：跳出方法外
        F8：执行到下一个断点

### 23.Tomcat 如何修改端口号？如何清除项目缓存？默认并发量是多少？

        端口修改：server.xml
        项目缓存：删除 work 文件夹下的文件
        并发：150-200之间

### 24.final、finally、finalize 的区别？

        final - 修饰符（关键字）
            如果一个类被声明为 final，意味着它不能再派生出新的子类，不能作为父类被继承
            一个类不能既被声明为 abstract 的，又被声明为 final 的
            被声明为 final 的方法也同样只能使用，不能重载
            
        finally - 异常处理时提供 finally 块来执行操作
            finally 块则是无论异常是否发生，都会执行 finally 块的内容
        
        finalize - 方法名
            finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的
            它是在 object 内中定义的，所有的类都继承了它

### 25.一个汉字几个字节？一个 char 类型的变量，可以存储一个汉字吗？为什么可以或不可以。

        两个字节，可以存储，前提是汉字必须是 Unicode 编码

### 26.列举至少9个 linux 系统操作命令，并给出汉字解释？

        cd [../] 切换文件路径
        ls -l 以列表的形式显示当前文件夹下的所有内容
        chmod -R 777 [file] 修改文件或文件夹的读写权限为可读写
        kill -9 [pid] 杀死指定的进程
        netstat -ao | grep [pid] 查看指定的端口号占用情况
        mkdir [filename] 创建文件或文件夹
        vim [filename] 打开并编辑文件
        tail -n -200 -f catalina.out 动态查看文件
        more [filenam] 大比例显示文件内容
        rm -rf 以文件夹关联的形式移除所有内容
        mv 移动文件或修改文件名
        cp 拷贝
        
### 27.谈谈 Spring AOP 的原理？

        AOP 称为面向切面编程
        用于处理系统中分布于各个模块的横切关注点，比如事务管理、日志、缓存等等
        实现 AOP 功能关键是采用代理技术，主要分为静态代理（Aspect）和动态代理
        JDK 中采用 Proxy 类产生动态代理的方式为某个接口生成实现类，如果要为某个类生成子类，则可以用 CGLIB，CGLIB 默认 false，需要手动开启

### 28.简要说明 SSH 框架搭建步骤？

        1.Struts2
            - 导包
            - 加载 struts.xml
            - 配置 web.xml
                - filter
        2.Struts2+Spring
            - 导中间包、Spring 包
            - 增加 spring 的配置文件 ApplicationContext.xml
            - 配置 web.xml
                - context 和监听
        3.Hibernate
            - 导包
            - 增加 hibernate 的配置文件 hibernate.hbm.cfg 和表的映射文件
            - 配置数据库的方言（SQLServer、MySQL、OracleSQL）和连接、加载映射文件
        4.Hibernate+Spring
            - 导中间包
            - 在spring 的配置文件中加载 Hibernate 的配置信息

### 29.简要说明 SSM 框架搭建步骤？

        1.Spring
            - 导包
            - 增加 spring 的配置文件 ApplicationContext.xml
            - 配置 web.xml
        2.SpringMVC（建议优先导入 SpringMVC 的包避免和 Spring 的包冲突）
            - 导包
            - 增加 SpringMVC 的配置文件 context-dispatcher.xml（在包中可以找到头部信息）
            - 配置 web.xml
        3.mybatis
            - 导包
            - 增加 mybatis 的配置文件 mybatis-config.xml
            - 将 mybatis 的配置文件在 Spring 和  SpringMVC 中进行引用和配置

### 30.多线程中 run 和 start 方法有什么区别？

        Thread 的 start 才是正在开启线程
        Run 只是调用了一个普通方法，并没有启动另一个线程，程序还是会按照顺序执行相应的代码
        Start 则表示重新开启一个线程，不必等待其他线程运行完，只要得到 CPU 就可以运行该线程

### 31.静态变量和实例变量有什么区别？

        静态变量前面要加 static，实例变量不用
        实例变量属于对象的属性，必须创建了实例对象才可以被使用
        静态变量不属于某个实例对象，而是属于类，也叫类变量，不用创建任何实例对象就会被使用

### 32.前后台数据交互的方式有哪些？

        json、file、xml、jsonp 等

### 33.字节流和字符流有什么区别？

        字节流：按字节读写
        字符流：按字符读写
            
        通常在处理文本时优先使用字符流，其他的用字节流
        字节流在操作时本身不会用到缓冲区（内存），是文件本身直接操作的，而字符流在操作时使用了缓冲区，通过缓冲区再操作文件

### 34.Redis 支持哪些数据类型的存储？

        string、list、set、zset、hash

### 35.Java 如何调用 Redis 进行数据操作，并列举增删改查操作？

        - 导包
        - Jedis jd = new Jedis(IP);
        - jd.ping();//PONG

### 36.NoSQL 主要支持哪两种数据存储系统？

        Redis:key-value
        MongoDB:文档存储

### 37.MongDB 的体系逻辑结构，主要由什么组成？

        文档（document）、集合（collection）、数据库（database）

### 38.Redis 和 MongoDB 分别应用于哪些应用场景？

        Redis：数据量比较小的侧重性能操作和运算上
        MongoDB：主要解决海量数据的访问效率问题
            
* [NoSQL | Redis、Memcache、MongoDB特点、区别以及应用场景](https://mp.weixin.qq.com/s?__biz=MzIxMjg4NDU1NA==&mid=2247484268&idx=1&sn=5431c00c451ebeca8aa99ae59f05a3a2&chksm=97be0e49a0c9875fa918412aa0d2544c8dbb02b8875382b08217b1e7818e7ae913d72ae4107c&scene=21#wechat_redirect)

### 39.Java 如何连接 MongoDB，写出逻辑代码？

        导包
        //建立连接
        MongoClient mc = new MongoClient("192.168.0.1",27017);
        MongoDatabase db = mc.getDatabase("db1");//数据库名称

### 40.如何给一张表增加一个字段，写出 sql 语句？

        alert table 表名 add 字段 类型 NOT NULL Default 0;

### 41.==与 equals 有什么区别？

        ==：比较两个数据内存地址是否相同
        equals：比较两个数据是否一样

### 42.++i与i++的区别？

        ++i：先赋值，后运算
        i++：先运算，后赋值

### 42.List 和 Map 有什么区别？

        list：
            - 链表
            - 有序
            - 继承 Collection（set 也是）
            - 可以有重复对象值，但是对象下标不能重复
        map：
            - key-value
            - 无序
            - 键不能有重复的，值可以重复或为空

### 42.Integer 与 int 的区别？

        int：是基本数据类型，初值为0
        Integer：是 int 的包装类，初值为 null
        Integer 缓存：注意拆箱和装箱（-128 - 127之间）
        
        原始类型：boolean、char、byte、short、int、long、float、double
        包装类型：Boolean、Character、Byte、Short、Integer、Long、Float、Double

### 45.ArrayList 和 LinkedList 的区别？

        ArrayList、LinkedList、Vector 和 Stack 是 List 的四个实现类，其中 Vector 是基于 JDK1.0，虽然实现了同步，但是效率低，已经不使用了，Stack 继承 Vector
        
        区别：
            - ArrayList 是实现了基于动态数组的数据结构，而 LinkedList 是基于链表的数据结构
            - 对于随机访问 get 和 set，ArrayList 要优于 LinkedList，LinkedList 不支持高效的随机访问
            - ArrayList 适合查找，LinkedList 适合增删

### 46.分别写出 OracleSQL、MySQL 的分页关键词？

        Oracle：rownum 关键词、row_number()函数
        MySQL：limit 0,5    /    limit  5;

### 47.谈谈你对 MVC 的理解？

        MVC：是一种框架设计模式，其中 M（模型）、V（视图）、C（控制器）
        
        视图：
            视图向用户显示相关的数据，并接受用户的输入，视图不进行任何业务逻辑处理。如 jsp、html 等。
        模型：
            表示业务数据和业务处理。属于数据模型，如 entity、jdbc、Hibernate、mybatis 等。
        控制器：
            接收、响应用户请求，servlet、action、controller 等。

### 48.如果 equals 方法比较为 true，那么他们的 Hashcode值一定相同吗？如果 hashcode 相同，那么 equals 方法比较一定为 true 吗？

        第一个不一定相同，第二个一定相同。

### 49.简述 servlet 生命周期？

        通过调用 init() 方法进行初始化
        调用 service() 方法来处理客户端的请求
        调用 destroy() 方法终止（结束）
        Servlet 是由 JVM 的垃圾回收器进行垃圾回收的

### 50.进程和线程的区别是什么？

        - 进程是资源的分配和调度的一个独立单元，而线程是 CPU 调度的基本单元
        - 同一个进程可以包含多个线程
        - 进程结束后它拥有的所有线程都将销毁，而线程的结束不会影响同个进程中其他线程的结束
        - 线程共享整个进程的资源（寄存器、堆栈、上下文），一个进程至少包含一个线程
        - 进程的创建调用 fork 或者 vfork，而线程的创建调用 pthread create
        - 线程中执行时一般都要进行同步或互斥，因为他们共享统一进程的所有资源

### 51.进程的几种状态分别是什么？

* 就绪状态：

        单价形成已分配到除 CPU 以外的所有必要的资源，只要活得处理机便可立即执行，这时的进程状态成为就绪状态
    
* 运行状态：

        当进程已获得处理机，其程序正在处理机上执行，此时的进程状态称为运行状态
    
* 阻塞状态（最容易死锁）：
    
        正在运行的进程，由于等待某个事件发生而无法执行时，变放弃处理机而处于阻塞状态。
        引起进程阻塞的事件可有多种，例如，等待 I/O 完成、申请缓冲区不能满足、等待信件（信号）等。
    
* 状态转换：
    * 就绪+运行：
        
            处于就绪状态的进程，当进程调度程序为之分配了处理机后，该进程就由就绪状态转变为运行状态
    
    * 运行+就绪：
        
            处于运行状态的进程在其运行过程中，因分配给它的一个时间片已用完而不得不让出处理机，于是进程由运行状态转变为就绪状态
    
    * 运行+阻塞：
        
            正在运行的进程因等待某种事件发生而无法继续运行时，便从运行状态变成阻塞状态
    
    * 阻塞+就绪：
        
            处于阻塞状态的进程，若其等待的事件已经发生，于是进程由阻塞状态转变为就绪状态

### 52.重载和重写的区别是什么？

        Override（重写）：
            1.方法名、参数、返回值相同
            2.子类方法不能缩小父类方法的访问权限
            3.子类方法不能抛出比父类方法更多的异常（但子类方法可以不抛出异常）
            4.存在于父类和子类之间
            5.方法被定义为 final 不能被重写
            
        Overload（重载）：
            1.参数类型、个数、顺序至少有一个不相同
            2.不能重载只有返回值不同的方法名
            3.存在于父类和子类、同类中

### 53.JDK 和 JRE 的关系区别是什么？

        JDK 是 java 的开发工具，JDK 包含 JRE
        JRE 只是 java 程序的运行环境，它最核心的内容就是 JVM（Java 虚拟机） 及核心类库

### 54.SpringMVC 运行原理是什么？

        1.客户端请求提交到DispatcherServlet 
        2.由DispatcherServlet控制器查询一个或多个HandlerMapping，找到处理请求的Controller 
        3.DispatcherServlet将请求提交到Controller 
        4.Controller调用业务逻辑处理后，返回ModelAndView 
        5.DispatcherServlet查询一个或多个ViewResoler视图解析器，找到ModelAndView指定的视图 
        6.视图负责将结果显示到客户端
        
        DispatcherServlet是整个Spring MVC的核心。它负责接收HTTP请求组织协调Spring MVC的各个组成部分
        
![](https://i.imgur.com/K1GtUSw.png)

### 55.用户在浏览器中输入 URL 之后，发生了什么？写出请求和响应的流程

        1：域名解析
        2：TCP三次握手
        3：浏览器向服务器发送http请求
        4：浏览器发送请求头信息
        5：服务器处理请求
        6：服务器做出应答
        7：服务器发送应答头信息
        8：服务器发送数据
        9：TCP连接关闭

### 56.响应结果状态码有哪些，并给出中文含义？

        1**：信息性状态码
        2**：成功状态码
            200：请求正常成功
            204：指示请求成功但没有返回新信息
            206：指示服务器已完成对资源的部分 GET 请求
        3**：重定向状态码
            301：永久性重定向
            302：临时性重定向
            304：服务器端允许请求访问资源，但未满足条件
        4**：客户端错误状态码
            400：请求报文中存在语法错误
            401：发送的请求需要有通过HTTP认证的认证信息
            403：对请求资源的访问被服务器拒绝了
            404：服务器上无法找到请求的资源
        5**：服务器错误状态码
            500：服务器端在执行请求时发生了错误
            503：服务器暂时处于超负载或正在进行停机维护，现在无法处理请求

### 57.什么是 ORM？

        对象关系映射（Object Relational Mapping，简称ORM）
        
        为了解决面向对象与关系数据库存在的互不匹配的现象的技术
        ORM是通过使用描述对象和数据库之间映射的元数据(元数据一般采用XML格式)，将程序中的对象自动持久化到关系数据库中
        
        Java典型的ORM中间件有:Hibernate,ibatis,speedframework,mybatis

### 58.什么是 IOC？

        (Inversion of Control,简称IOC)，即控制反转，是一种设计模式，是spring的核心
        
        可以解决代码耦合，由IOC容器来管理对象的生命周期、依赖关系等。
        
        举个栗子：
        
            我们是如何找女朋友的？
        
            常见的情况是，我们到处去看哪里有长得漂亮的mm，然后打听她们的兴趣爱好、微信号、手机号、ip号、………，想办法认识她们，投其所好送其所要，然后....,这个过程是复杂深奥的，我们必须自己设计和面对每个环节。传统的程序开发也是如此，在一个对象中，如果要使用另外的对象，就必须得到它（自己new一个，或者从JNDI中查询一个），使用完之后还要将对象销毁，耦合度比较高。
        
            IOC：相当于第三方“婚姻介绍所”，手里有许多mm的资料，只需要你告诉介绍所，你需要什么样的女朋友，然后介绍所会自动匹配适合你的mm，然后给你，你只需要去和她谈恋爱、结婚就行了。简单明了，如果不符合你的要求，你可以抛出异常啊......虽有的对象都有你自己决定，spring也是如此，所有的对象都被spring控制。
        
        当前比较知名的IOC容器有：Spring、JBoss、EJB等。

### 59.抽象类与接口的区别？

        抽象类（abstract class）：
            1：abstract 关键字修饰，并且没有方法体
            2：抽象类不能直接创建实例
            3：抽象类只能被继承，一个具体类继承一个抽象类，必须实现所有抽象方法
        
        
        接口（interface）：
            1：实现接口的一定要实现接口里定义的所有方法
            2：接口可以实现多重继承
        
        区别：
            1：抽象类和接口都不能够实例化，但可以定义抽象类和接口类型的引用
            2：一个类如果继承了某个抽象类或者实现了某个接口都需要对其中的抽象方法全部进行实现，否则该类仍然需要被声明为抽象类
            3：接口比抽象类更加抽象，因为抽象类中可以定义构造器，可以有抽象方法和具体方法，而接口中不能定义构造器而且其中的方法全部都是抽象方法
            4：抽象类中的成员可以是private、默认、protected、public的，而接口中的成员全都是public的
            5：抽象类中可以定义成员变量，而接口中定义的成员变量实际上都是常量。有抽象方法的类必须被声明为抽象类，而抽象类未必要有抽象方法

### 60.JSP 的作用域有哪些？

        page：当前页面有效
        request：一次会话请求有效
        session：浏览器进程，只要浏览器不关闭，则一直有效
        application：服务器只要运行，则有效

### 61.sleep 和 wait 有什么区别？
### 62.Java 中的final关键字有哪些用法？
### 63.Error和Exception有什么区别？什么时候需要捕获异常，什么时候需要抛出异常？
### 64.阐述JDBC操作数据库的步骤？
### 65.写出冒泡排序的程序代码？


