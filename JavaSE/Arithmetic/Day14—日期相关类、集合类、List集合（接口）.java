总结多态的三种用法：
	Student类继承Person类
	1.通过实参传递子类对象给父类类型的形参引用赋值形成多态；
		void show(Person p){ ……}
		show(new Student());
	2.在方法体中直接使用父类的引用指向子类的对象形成多态；
		Person p = new Student();
	3.通过返回值类型为父类类型而方法体中正真返回子类对象的形式形成多态；
		Person show(){
			return new Student();
		}

今日内容：
	1.日期相关的类
	2.集合类
	3.List集合（接口）

1.日期相关的类（查手册会用即可）
	标准时间：1970年1月1日0时0分0秒。每个地区的标准时间是不一样的，因为存在时区的差异新，中国属于东八区，因此标准时间是1970年1月1日8时0分0秒
	1.Date（）类
		1.基本概念：
			java.util.Date类用于描述日期信息：年月日时分秒，可以精确到毫秒。1秒=1000毫秒。
		2.常用方法：
			Date（）   — 用于无参的方式构造对象，默认使用当前的系统时间。
			Date（long date）  — 根据参数指定的毫秒数来构造对象
					— 其中参数为距离1970年1月1日0时0分0秒的毫秒数（与File类搭配使用）
			Date getTime（）   — 获取当前对象距离1970年1月1日0时0分0秒的毫秒数
			Date setTime（long time）  — 用于设置当前对象的时间为参数指定的毫秒数，距离标准时间

	2.SimpleDateFormat类
		1.基本概念：
			java.text.SimpleDateFormat类用于格式化和解析日期，也就是实现日期类型和字符串之间的相关转换。
		2.常用方法：
			SimpleDateFormat（String pattern）	— 根据参数指定的字符串模式来构造对象。
					— y代表年，M代表月，d代表日，H代表时，m代表分，s代表秒
			public final String format(Date date) 	— 用于将Date类型转换成String类型
			public Date parse(String source)	throws ParseException
					— 用于将String类型转换成Date类型
	3.Calendar类
		1.基本概念：
			java.util.Calendar类用于描述日期信息的，该类中很多方法取代了Date类的过时方法。
			该类是一个抽象类，不能实例化对象。
		2.常用方法：
			static Calendar getInstance（）	 — 用户获取当前类的引用
				— 该方法的返回值真正指向的是Calendar类的子类对象，这是多态的第三种用法。
			void set(int year, int month, int date, int hourOfDay, int minute, int second)
				— 根据参数设置年月日时分秒。
			Date getTime()  — 用于将Calendar类型转换为Date类型并返回。

========================================================================================

2.集合类（熟悉）
2.1.数组和集合的区别（理解，笔试题  容器）
（1）数组的特点：
	a.数组本质上就是一段连续的内存空间，可以记录多个类型相同的数据；
	b.数组支持下标访问，可以实现随机访问；
	c.数组一旦定义则内存空间的大小固定，无法增大或变小；
	d.插入和删除元素时，可能会移动大量的元素，因此效率比较低；
	e.数组的元素类型可以是基本数据类型，也可以是引用数据类型；

（2）集合的特点
	a.集合的内存空间可连续可不连续，数据类型可相同可不相同；
	b.集合部分支持部分不支持下标访问；
	c.集合的内存空间不会固定，随时可以动态调整；
	d.集合中增删元素可以不移动大量元素；
	e.集合中的元素类型必须是引用数据类型；（八种包装类处理八种基本数据类型）

2.2 基本概念：
	集合类主要指用于描述集合的相关类和接口，顶层集合分别是：Collection接口和Map接口
	其中java.util.Collection集合操作元素的基本单位是：单个元素；（一个元素一个元素的放）
	其中java.util.Map集合操作元素的基本单位是：单对元素；（一对一对的元素放）

	在以后的开发中Collection接口本身很少使用，更多的使用该接口的子接口：List接口、Queue接口以及Set接口。

2.3 Collection集合的常用方法（练熟、记住）
	boolean add（E e）	— 用于将参数指定的元素e放入当前集合，成功返回true，否则false；
	boolean addAll（Collection<？extends E> c）
			— 用于将参数指定的集合 c 中所有的元素放入当前集合中

	boolean contains(Object o)	— 用于判断当前集合中是否包含参数指定的对象o；
	boolean containsAll(contains<?> o)	— 用于判断是否包含参数指定集合的所有元素；

	boolean remove(Object o) 	— 用于才能够当前集合中删除参数指定的单个元素；
	boolean removeAll(Collection<?> c)	— 用于从当前集合中删除参数指定的所有元素；
	void clear()	— 用于删除当前集合的所有元素;

	boolean isEmpty()	— 用于判断当前集合是否为空，空返回true；
	int size()		— 用于获取集合中元素的个数；
	boolean retainAll(Collection<?> c)	
				— 用于计算当前集合与参数集合的交集，并放入当前集合中；
				— 当前集合中的元素发生改变则返回true，否则返回false；

package xdl.day14;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws Exception{
		// 每个地区的标准时间是不一样的，因为存在时区的差异新，中国属于东八区，因此标准时间是1970年1月1日8时0分0秒
		// 1.使用各种不同的版本构造对象
		Date d1 = new Date();
		System.out.println("d1=" + d1);// 打印系统时间

		Date d2 = new Date(1000);
		System.out.println("d2=" + d2);// 1000毫秒
		
		

		// Date d3 = new Date(2008 - 1900, 8 - 1, 8, 20, 8, 8);//
		// 此方法已过时，年份减去1900年，月份减去1，表示当前计算时间
		// System.out.println("d3=" + d3);
		//2.使用取代的方法来构造年月日时分秒
		//2.1获取calendar类型的对象
		Calendar c1 = Calendar.getInstance();
		//2.2调用set（）方法来设置年月日时分秒
		c1.set(2008, 8-1,8,20,8,8);
		//2.3转换成Date类型
		Date d6 = c1.getTime();
		System.out.println("d6 = "+d6);
		//3.调整输出格式
		
		
			
		long msec = d1.getTime();
		System.out.println("距离当前系统时间标准时间的好秒速msec=" + msec);
		d1.setTime(2000);
		System.out.println("d1 = " + d1);// 距离1970 1 1 8 0 2

		// 1.创建SimpleDateFormat类型的对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		// 将上述日期信息按照构造方法指定的格式来转换成字符串类型
		String str = sdf.format(d1);
		System.out.println(str);
		//根据字符串转换成日期类型
		Date d5 = sdf.parse(str);
		System.out.println(d5);

	}

}

package xdl.day14;

import java.util.*;

public class TestCollection {

	public static void main(String[] args) {
		// Collection c1 = new Collection(); 接口不能实例化对象
		// 接口类型的引用指向实现类的对象，形成了多态
		Collection<Object> c1 = new ArrayList<Object>();

		// 在编译阶段应该调用Collection自己的toString()，在运行阶段调用ArrayList()的toString()
		// toString()方法的打印格式为：[元素1， 元素2， 。。。。。]
		System.out.println("c1 = " + c1); // 自动调用toString方法
		System.out.println("——————————————————————————————————————————");

		// 实现向集合c1中增加单个元素
		boolean b1 = c1.add(new Integer(1));
		System.out.println("b1 = " + b1);// true
		System.out.println("c1 = " + c1);// c1 = [1]
		b1 = c1.add(new String("two"));
		System.out.println("b1 = " + b1);// true
		System.out.println("c1 = " + c1);// c1 = [1,two]
		// 需要一个student.java
		b1 = c1.add(new Student(1001, "student", 30));
		System.out.println("b1 = " + b1);// true
		// 打印集合的本质就是打印集合中的每个元素
		// 打印每个元素的本质就是调用每个元素自己的toString（）方法
		System.out.println("c1 = " + c1);

		System.out.println("——————————————————————————————————————————");

		// 实现向集合中添加另外一个集合的所有元素
		// 准备另外一个集合
		@SuppressWarnings("rawtypes")
		Collection<Comparable> c2 = new ArrayList<Comparable>();
		c2.add(new Integer(3));
		c2.add(new String("four"));

		b1 = c1.addAll(c2);
		// b1 = c1.add(c2);
		System.out.println("c1 = " + c1);

		Collection<Object> c4 = new ArrayList<Object>(c1);

		System.out.println("——————————————————————————————————————————");

		// 判断当前集合中是否包含参数指定的单个元素
		// ( o == null ? e == null : o.equals(e) )
		// 当contains（）方法的形参为空时，只需要判断当前集合中是否有元素为空即可
		// 当contains（）方法的形参不为空时，就需要参数对象调用equals（）方法与集合元素比较
		// 因为在student中没有重写equals方法，所以调用的是object中的equals方法，判断的是地址是否相等
		b1 = c1.contains(new Integer(2));
		System.out.println(b1);
		b1 = c1.contains(new String("two"));
		System.out.println(b1);
		b1 = c1.contains(new Student(1001, "zhangfei", 30));
		System.out.println(b1);

		// 判断当前集合中是否包含参数指定的所有元素
		b1 = c1.containsAll(c2);
		System.out.println(b1);// true
		// 因为在上面c2已经被拆分成3，four两个元素，而不再是[3，four]的形式，所以使用contains整体做判断的时候返回false
		b1 = c1.contains(c2);
		System.out.println(b1);

		System.out.println("——————————————————————————————————————————");
		System.out.println("原装c1 = " + c1);
		Collection<Object> c3 = new ArrayList<Object>(c1);
		// 实现单个元素的删除
		b1 = c1.remove(new Integer(1));
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);
		b1 = c1.remove(new String("two"));
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);
		b1 = c1.remove(new Student(1001, "zhangfei", 30));
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);
		// 实现集合中多个元素的删除操作
		c1 = c3;
		b1 = c1.removeAll(c2);
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);

		// 实现集合中元素的清空
		c1.clear();
		System.out.println("c1 = " + c1);

		System.out.println("——————————————————————————————————————————");

		c1 = c4;
		System.out.println(c1);
		// 判断集合是否为空以及返回元素个数
		System.out.println(c1.isEmpty() ? "什么都没有" : "元素不为空");
		System.out.println("元素的个数是：" + c1.size());
		// 计算两个集合的交集并返回结果
		b1 = c1.retainAll(c2);
		System.out.println("b1=" + b1);
		System.out.println("c1=" + c1);
	}

}


package xdl.day15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestHomeWork {

	public static void main(String[] args) throws ParseException {
		// 1.提示用户按照指定的格式输入生日信息，计算距离1970年1月1日的天数并打印出来
		// 如输入格式：1998年1月5日
		Scanner sc = new Scanner(System.in);
		System.out.println("请按照格式输入您的生日信息(yyyy年MM月dd日)：");
		String input = sc.next();
//		String regx = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})年(((0[13578]|1[02])月(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)月(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))日)";
//		boolean re = input.matches(regx);
		boolean re = true;
		if (re == false) {
			System.out.println("您输入的日期格式不正确！请重新输入！");
		} else {
			SimpleDateFormat stf = new SimpleDateFormat("yyyy年MM月dd日");
			Date sr = stf.parse(input);
			long res1 = sr.getTime();
			// 因为当前地区处于东八区，多余8小时，因此需要减去8小时的毫秒数，然后除去一天的毫秒数
			// 因为当前一天减去的数量没有计算前面一天，因此需要在总数上加1
			long res = (res1 - 8 * 60 * 1000) / (24 * 60 * 60 * 1000) ;

			System.out.println("您输入的生日日期已经距离1970年1月1日共：" + res + "天！！");
		}
		sc.close();
	}

}
