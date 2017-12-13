今日内容：
	1.反射机制
	2.常用的设计原则
	3.常用的设计模式

1.反射机制（难点、原理、尽量理解）
如：
	Person p = new Person();   — 表示创建 Person 类型的对象记录到引用变量 p 中
	p.show()；    — 表示调用 Person 类中的 show() 方法。

1.1 基本概念
	通常情况下编写的代码都是固定的，在运行阶段只能创建对应的对象，以及调用对应的方法，但若希望在编译阶段不确定创建何种对象以及调用何种方法，此时就需要使用动态编程的技术，通过运行阶段传入的参数来决定何种对象和方法，这种技术就叫做反射机制。
	目前主流的框架技术底层原理都是采用反射机制，如：SSH 、SSM 等。

1.2 CLass 类
（1）基本概念
	java.lang.Class 类的实例（对象）用于代表应用程序中的类和接口，也就是一种数据类型。
	Class 类没有公共构造方法，该类的实例是由 Java 虚拟机和类加载器自动构造。

（2）获取 Class 类实例的主要方式
	a.使用  数据类型.class   的方式获取；
	b.使用  对象.getClass()  的方式获取；
	c.使用  包装类.TYPE     的方式获取；
	d.使用  Class.forName()的方式来获取（掌握）；

（3）常用的方法
	static Class<?> forName(String className)   — 用于获取参数指定 class 对象并返回；
	T newInstance() — 用于创建此 Class 对象所表示类的新实例。
		— 当此 Class 对象表示 String 类型时，调用该方法相当于无参方式创建 String 类型对象
	Constructor<T> getConstructor(Class<?> … parameterTypes) 
		— 用于获取吃 Class 对象中参数指定的公共构造方法并返回；
	Constructor<?>[]  getConstructors()  — 用于获取此 Class 对象中所有公共构造方法；
	Field getDeclaredField(String name) — 用于获取此 Class 对象对应类中参数 name 指定的成员变量并返回；
	Field getDeclaredFields() — 用于获取此 Class 对象对应类中所有的成员变量并返回（数组）；
	Method getMethod(String name , Class<?> … parameterTypes) — 用于获取此 Class 对象对应类中参数 name 指定的公共成员方法并返回；
	Method[] getMethods() — 用于获取此 Class 对象对应类中所有的公共成员方法并返回


1.3 Constructor 类
（1）基本概念
	java.lang.reflect.Constructor 类用于描述获取到的单个构造方法信息。
（2）常用的方法
	T newInstance(Object … initargs)
			— 使用调用对象描述的构造方法来构造 Class 对象所描述类的新实例
			— 参数用于初始化该新实例的成员变量信息

1.4 Filed 类
（1）基本概念
	java.lang.reflect.Field 类用于描述获取到的单个成员变量信息。
（2）常用的方法
	Object get(Object obj) — 用于获取对象 obj 中当前调用对象描述的成员变量的数字并返回
	void set(Object obj , Object value) — 用于将 obj 中当前调用对象描述的成员变量值修改为参数 value 指定的数值
			如：obj.name = value;
	void setAccessible(boolean flag) — 设置是否进行 Java 语言的访问检查

1.5 Method 类
（1）基本概念
	java.lang.reflect.Method 类用于描述获取到的单个成员方法信息
（2）常用的方法
	Object invoke(Object obj , Object …. args) — 用于让对象 obj 调用当前 Method 对象描述的方法，实参传递 args 并返回结果；

1.6 Java Bean 的概念
	Java Bean 用于表示一种编程规范，不是语法要求或者编程规则，通常建议如下：
		a.要求满足 Java Bean 规范的类必须在一个包中；
		b.要求满足 Java Bean 规范的类必须有无参构造方法；
		c.要求满足 Java Bean 规范的类必须私有化成员变量；
		d.要求满足 Java Bean 规范的类必须提供公有的 get 和 set 方法；
		e.要求满足 Java Bean 规范的类必须支持序列化功能（Serializable）；

2.常用的设计原则
2.1 项目/软件开发的流程
	需求分析文档 => 概要设计文档 => 详细设计文档 => 编码和测试 => 安装和调试 => 维护和升级

2.2 常用的设计原则
	开闭原则（OCP） — 对扩张开放，对修改关闭，实现热插拔的效果
					 — 提高了项目的可维护性和可扩展性
					 — 任何软件都是有 bug 的
	里氏代换原则（LSP） — 任何父类可以出现的地方，子类一定可以出现；
						— 建议以后的开发中尽量多用继承和多态，子类  is  a 父类；
	依赖倒转原则（DIP） — 尽量依赖于抽象类或接口，而不是具体实现类；
					      — 抽象类和接口对子类具有强制性和规范性；
	接口隔离原则（ISP） — 尽量依赖于小接口而不是大接口，避免接口的污染；
	迪米特法则（最少知道原则）（DP） — 尽量让一个实体少与其他实体之间发生相互作用
						— 高内聚、低耦合
						— 内聚就是指将一个实体应当有的功能尽量聚集在该实体的内部；
						— 耦合就是指一个实体与其他实体之间的关联度
	合成复用原则（CRP） — 尽量多使用合成的方式而不是继承的方式

3.常用的设计模式
3.1基本概念
	设计模式（Design pattern）是一套被反复使用、多数人知晓、进过分类编目、代码设计经验的总结。
	设计模式本质上就是使用在固定场合的固定套路。

3.2基本分类（三大类共23小类）
	创建型模式 — 工厂方法模式、抽象工厂模式、单例模式（掌握，会写）
	结构型模式 — 装饰器模式、代理模式（看懂）
	行为型模式 — 模版方法模式、观察者模式

