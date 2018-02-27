# 1.Spring 框架的构成

        IOC   控制反转  构成Spring框架的核心
        DAO   Spring 对JDBC的封装和支持 
        MVC   Spring 对 Web部分支持
        AOP   面向切面编程 
        ORM   对象关系映射 (mybatis)
        JEE   远程调用  消息 邮件
  
# 2.什么是IOC

        Inversion  Of  Control    控制反转 (对象的创建由原来的new的方式 
        变成由Spring来进行创建和管理)   降低组件之间的耦合度 
        IOC的作用 可以创建组件  和 管理组件 以及维护组件之间的关系
  
# 3.Spring 容器

        用来管理和创建对象  以及维护对象的关系一个对象
        Spring 容器 实现了 IOC 和 AOP 机制 
        Spring 容器的类型 是 ApplicationContext  和 BeanFactory 类型
  
# 4.Spring 容器的使用步骤

## 4.1 建立一个项目  导入ioc对应的jar包  拷贝Spring容器对应的配置文件到src下
  
## 4.2 在Spring 容器对应的配置文件中 写bean组件对应的配置
  
        <bean  id="对象标识"  class="包名+类名" > </bean> 
     
## 4.3 在主方法中 创建Spring 容器对象  并通过相应的API 获取对应的组件
  
        // 创建Spring 容器对象 
		ApplicationContext  app = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过容器的API 获取对应的组件 
		Date date = (Date)app.getBean("date");
		System.out.println(date);
		// 推荐使用的方式
		Date date2 = app.getBean("date", Date.class);
		System.out.println(date2); 
		
# 5.定义一个Emp类型   类型中有 String  eno  String  ename  double  salary

        并为这些成员变量提供get set 方法。为这个类型提供 无参构造和全参构造 以及
        toString 方法。在Spring 的配置文件中 配置Emp 可以通过Spring 容器获取
        对应Emp 类型对象。   

# 6.Spring 容器创建对象的三种形式

## 6.1 构造器实例化  默认调用无参构造方法

        <bean  id="标识符"  class="包名+类名" > </bean>
     
## 6.2 静态工厂方法实例化

        在Spring容器中构建一个java.util.Calendar 类型的对象    
    
        <bean id="目标对象的标识"  class="包名+工厂类名"  factory-method="静态方法名"></bean>
        
## 6.3 实例化工厂方法  实例化
  
        <bean id="目标对象的标识"   factory-bean="工厂对象"  factory-method="实例化方法名">  </bean>
      
# 7.bean 对象的作用域

        bean 对象默认(singleton)作用域是单例的   可以通过bean 标记中的 scope 属性 来指定作用域 
        当指定成   prototype 时  是 非单例的(请求几次就创建几个对象)。
        其它的如  request  session  在web 部分中使用
    
# 8.bean 对象的初始化

        在构造方法调用完成之后  可以通过beans标记中 加  default-init-method 指定初始化方法名 
        由于这样配置 影响的范围比较大,所以bean 组件对应的类型中 没有 对应的方法 也不会报错。
        也可以在bean 标签中 加 init-method 指定初始化方法,由于影响比较小 所以没有对应的
        初始化方法则会报错。
        
# 9.bean 对象的销毁

        在对象销毁之前  可以通过beans标记中 加  default-destroy-method 指定销毁方法名 
        由于这样配置 影响的范围比较大,所以bean 组件对应的类型中 没有 对应的方法 也不会报错。
        也可以在bean 标签中 加 destroy-method 指定销毁方法,由于影响比较小 所以没有对应的
        销毁方法则会报错。
        
# 10.bean 对象的延迟实例化 

        bean 对象 默认在容器启动时(单例) 创建，可以通过beans 标签中加default-lazy-init="true" 可以推迟对象实例化,也可以在bean 标签中加 lazy-init="true" 来推迟对象的实例化。
    
# 11.定义一个扑克牌类 Card  成员变量有 String  suits  String point 

        提供get set  无参 和 带参构造  toString。
        定义一个玩家类 Player   成员变量有  String  name  int  age   Card  card 
        提供get set  无参 和 带参构造  toString。 
        使用构造器方式 来创建对象  并进行获取。
        
# Schema和DTD的区别

        Schema是对XML文档结构的定义和描述，其主要的作用是用来约束XML文件，并验证XML文件有效性。DTD的作用是定义XML的合法构建模块，它使用一系列的合法元素来定义文档结构。它们之间的区别有下面几点：

>1、Schema本身也是XML文档，DTD定义跟XML没有什么关系，Schema在理解和实际应用有很多的好处。

>2、DTD文档的结构是“平铺型”的，如果定义复杂的XML文档，很难把握各元素之间的嵌套关系；Schema文档结构性强，各元素之间的嵌套关系非常直观。

>3、DTD只能指定元素含有文本，不能定义元素文本的具体类型，如字符型、整型、日期型、自定义类型等。Schema在这方面比DTD强大。

>4、Schema支持元素节点顺序的描述，DTD没有提供无序情况的描述，要定义无序必需穷举排列的所有情况。Schema可以利用xs:all来表示无序的情况。

>5、对命名空间的支持。DTD无法利用XML的命名空间，Schema很好满足命名空间。并且，Schema还提供了include和import两种引用命名空间的方法
  
