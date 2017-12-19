	•	简答题（每题5分，共计40分）
	•	请写出匿名内部类的语法格式以及作用。

TestThread tt = new TestThread(){
		方法；
}
让不能实例化的类可以实例化

	•	当使用接口类型的引用作为方法的形参时，实参的传递方式有两种：

定义内部类
接口实现类

	•	简述Java中常用的包和包中的内容。
java.lang  —该包是java语言的核心包，该包中的所有内容由java虚拟机自动导入；
java.util    —该包是java语言的工具包，该包提供了大量的工具类和集合类等； 
	java.io     —该包是java语言的输入输出包，该包提供了大量的操作文件以及读写的类等； 
	java.net   —该包是java语言的网络包，该包提供了大量的进行网络通行的类等；

简述String类、StringBuilder类以及StringBuffer类之间的主要区别。
String 是描述字符串类型的，StringBuilder属于非线程安全类，效率高，StringBuffer 类属于线程安全类，效率低。
	•	请写出String类中常用的方法名和功能（至少写出5个）。
toString()重写输出格式
equals()重写比较内容
hashCode()重写哈希码值
indexOf()获取下标
charAt()拆分数组
	•	简述List接口的特性和主要实现类的底层实现。
Collection 的子类，放入有序，允许重复
List I = new LinkedList();
7. 写出常见的5种异常类型，要求写出英文名称以及汉语解释。
类型转换异常：java.lang.ClassCastException
数组下表越界异常：java.lang.ArrayIndexOutOfBoundsException  
算数异常：java.lang.ArithmeticException 
空指针异常：java.lang.NullPointerException 
数字格式异常： java.lang.NumberFormatException
8. 简述异常捕获的语法格式以及是否发生异常的执行流程。
Try(){}catch{}
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
二、画图题(每图5分，共10分)
1. 画出框架类相关的两张图。

2. 画出一棵有序二叉树并标出根节点、枝节点、叶子节点，以及高度和大小。

高度3；根节点：30；枝节点：25、40；叶节点：20、27、35、45
三、编程题（每题10分，共50分）
	•	分别使用两种方式实现字符串向十进制整数转换的功能，字符串由参数传入。


public class StringToInt {

	public static void main(String[] args) {
		String a = new String("10000");
		// 方法一
		int arr = 0;
		for (int i = 0; i < a.length(); i++) {
			arr = arr * 10 + a.charAt(i) - '0';
		}
		System.out.print(arr);
		
		System.out.println("\n ——————————————————————————");
		// 方法二
		int b = Integer.parseInt(a);
		System.out.println(b);

	}


}
	•	编程实现Student类的封装并重写equals()、hashCode()以及toString()方法，属性有：学号和姓名。
public class Student {
	private int id;
	private String name;
	public Student() {
		super();
	}
	public Student(int id, String name) {
		super();
		setId(id);
		setName(name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//为了比较对象内容是否一致，重写equals（）方法
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}else if(obj == null){
			return false;
		}else if(obj instanceof Student){
			Student s = (Student)obj;
			int res1 = this.getId();
			int res2 = s.getId();
			String res3 = this.getName();
			String res4 = s.getName();
			if(res1 == res2 && res3 == res4){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	//为了使得hashcode（）方法的结果与equals（）方法的结果一致
	@Override
	public int hashCode(){
		//直接返回当前调用对象的学号来保持一致性
		return getId();
	}
	
	//为了使得toString（0方法返回更有意义的数据，则需要重写
	@Override
	public String toString(){
		return "Student[id="+getId()+",name="+getName()+"]";
	}
}


	•	采用LinkedList集合中的相关方法实现MyStack类，要求提供入栈、出栈、查看栈顶元素、计算栈中元素个数以及判断是否为空的方法。

import java.util.LinkedList;
import java.util.Queue;

public class MyStrack {

	public static void main(String[] args) {
		Queue<Object> lk = new LinkedList<Object>();
		for(int i =0;i<10;i++) {
			boolean b = lk.offer(i*10);
		}
		System.out.println(lk);
		for (int i = lk.size(); i >= 0; i--) {
			if (lk.peek() != null) {
				Integer j = (Integer) lk.poll();
				System.out.println("移除的元素分别是:" + j);
			} else if (lk.poll() == null) {
				System.out.println("已经移除了所有元素了！");
			}
		}
	}
}

	•	定义一个乐器(Instrument)接口，其中有抽象方法void  play();  在InstrumentTest类中，定义方法void playInstrument(Instrument ins);  要求在该类的main方法中调用上述方法，采用两种方式实现。

package xdl.day20;

public class InstrumentTest  {

    public void playInstrument(Instrument ins){
     System.out.println("调用成功");
    }
 @SuppressWarnings("unused")
public static void main(String[] args) {
   InstrumentTest itt = new InstrumentTest();
   itt.playInstrument(null);
   
         System.out.println("===================");
         
   Instrument it = new Instrument(){
   @SuppressWarnings("unused")
public void play() {
    System.out.println("调用不成功");
    
   }
   };  
   Instrument.play();
        
}
}


	•	使用HashSet类编写一个程序，生成10个1至20的随机数，要求随机数不能重复。并把最终的随机数输出到控制台。

package xdl.day20;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> in = new HashSet<String>();
		Random random = new Random();
		int i =0;
		int ran = 0;
		for(i =0;i<10;i++) {
			ran = random.nextInt(20);
			in.add(String.valueOf(ran));
		}		
		System.out.println(in);

	}

}

