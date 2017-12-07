今日内容：
	1.Set集合
	2.Map集合
	3.异常机制

1.Set集合（重点）
1.1 TreeSet类
（1）什么是二叉树？
	二叉树就是指每个节点最多只有两个子节点的树形结构。
（2）什么是有序二叉树？
	满足以下三个条件的二叉树叫做有序二叉树，又叫二叉查找树。
	a.要求左子树中任意节点的元素值都小于根节点元素；
	b.要求右子树中任意节点的元素值都大于根节点元素；
	c.左右子树的内部也遵循上述原则；
（3）向TreeSet中放入元素时需要指定元素比较大小的规则，具体方式如下：
	a.使用元素的自然排序指定，也就是元素类型实现  java.lang.Comparable   接口；
	b.使用比较器进行指定，也就是在构造方法中传入  java.util.Comparator     接口；

总结：
	当该集合中放入元素时，默认按照元素的自然排序进行处理，但自然排序只能指定一种排序规则，若希望进行多元化排序，则应该使用比较器处理。

1.2 常用的工具类
	java.util.Arrays类中提供了大量操作数组的静态方法；
	java.util.Collections类中提供了大量操作集合的静态方法；

2.Map集合（重点）
2.1 基本概念：
	java.util.Map<K, V>接口拥有两个泛型，具体如下：
		K	— key（键）的类型
		V	— Value（值）的类型
	该接口的两个主要实现类：HashMap类  和   TreeMap类。
2.2 常用方法：
	V put(K key, V value) 	— 用于将key和value组成一队放入当前集合中。
		— 当实现增加时，返回null；当实现修改时，则返回key之前对应的value。
	V remove(Object key) — 用于从集合中删除参数key和对应的value。
		— 若有key，则返回value；若没有key，则返回null。
	boolean containsKey(Object key) — 用于判断参数指定的key是否存在。
	boolean containsValue(Object value) — 用于判断参数指定的value是否存在。
	V get(Object key) — 用于根据参数key返回对应的value。

	Set<Map.Entry<K, V>>   entrySet() — 用于将Map集合转换为Set集合的视图。
			K getKey() — 用于返回调用对象中的 key。
			V getValue() — 用于返回调用对象中的 value。
	Set<K> keySet() — 用于将 Map 集合中所有的 key 转换为 Set 集合的视图。

3.异常处理（重点，简单）
3.1 基本概念：
	异常就是“不正常”的意思。在 java 里面主要指在运行阶段发生的错误。
	java.lang.Throwable 类似 java 语言中错误（Error 类）或异常（Exception 类）的超类。
	其中 Error 类通常描述比较严重的错误，如：JVM 内存耗尽等；
	其中 Exception 类通常描述比较轻微的错误，如：零做除数等。
3.2 基本分类：
	Exception 类的主要分类：
		RuntimeException 类 — 运行时异常，也叫做非检测性异常；
		IOException 类和其他类异常 — 其他异常，也叫做非检测性异常；
				— 所谓检测性异常就是指在编译阶段可以被编译器检测出来并报错的异常。
	
		RuntimeException 类的主要子类有：
			ArithmeticException — 算数异常
			ArrayIndexOutOfBoundsException — 数组下标越界异常
			NullPointerException — 空指针异常
			ClassCastException — 类型转换异常
			NumberFormatException —  数字格式异常

注意：
	当程序中发生异常并没有手动处理的时候，由 JVM 采用默认方式处理，默认的处理方式就是：打印异常名称、异常原因、异常位置等信息并终止程序，后续代码无法执行。

3.3 异常的避免
	对于绝大多数非检测性异常来说，都可以使用 if（）分支表达式结构进行避免。

3.4 异常的捕获
（1）语法格式
	try{
		编写所有可能发生异常的语句块；
	}
	catch(异常类型  变量名){
		编写处理该类型异常的语句块；
	}
	…….
	finally{
		编写无论是否发生异常都应该执行的语句块；
	}

（2）注意事项
	当需要编写多个 catch 分支时，切记小类型的异常应当放在大类型异常的上面。
	懒人写法：
		catch(Exception e){
			…….
		}
	finally{} 中通常用于编写负责善后工作的语句块，如：关闭打开的文件等。

（3） 执行流程
	try{
		a;
		b;  — 可能发生异常的语句
		c;
	} catch(Exception e){
		d;
	}finally{
		e;
	}
	当程序中没有异常时执行的流程为：a b c e
	当程序中发生异常时执行的流程为：a b d e

3.5 异常的抛出
（1）基本概念
	某些特殊场合中产生了异常，但不便于或者无法处理该异常，此时就可以将该异常转移给该方法的调用者，这种异常转移的方式就叫异常的抛出。

（2）语法格式
	访问权限  返回值类型  方法名（形参列表） throws  异常类型1，异常类型2，。。。。{}
	如：
		public void show() throws IOException{}

方法重写的原则：
	（1）要求方法名相同、参数列表相同、返回值类型相同，从 jdk1.5开始允许返回子类类型；
	（2）访问权限不能变小，可以相同或者变大；
	（3）不能抛出更大的异常；

总结：
	对于子类中重写的方法来说，可以选择抛出与户内一样的异常、更小的异常、不抛出异常，但不能抛出更大的异常以及平级当不一样的异常。

3.6 自定义异常
（1） 自定义异常的由来
	在以后的开发中若希望表达年龄不合理的异常，此时 Java 官方虽然提供的异常类很多，当没有专门针对性的年龄异常类，此时就需要自定义异常类加以描述。

（2） 自定义异常的流程
	a.自定义一个异常类继承自 Exception 类 或者其子类；
	b.提供两个版本的构造方法，一个是无参构造，另外一个是字符串作为参数构造；

（3） 异常对象的产生
	throw  new 异常类型（实参）;
	如：throw new AgeException（“年龄不合理！”）；


