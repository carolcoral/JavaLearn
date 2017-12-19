JAVASE阶段测试
一、单选题（每题2分，共20分）
1.以下表达式那个是不合法的（B）
A)		String x = "Hello"; 
int y = 9; x += y;
B)		String x = "Hello"; 
int y = 9; 
if(x == y) { }
C)		String x = "Hello"; 
int y = 9; x = x + y;
D)		String x = null; 
int y = ( x!=null) && (x.length()>0) ? x.length() : 0;
2.分析以下程序的执行结果 
public class SwitchTest {
public static void main (String [] args) { 
System.out.println ("value = " + switchIt(4));
}
public static int switchIt(int x) {
int j = 1;
switch (x) {
case 1: j++;
case 2: j++; 
case 3: j++; 
case 4: j++; 
case 5: j++; 
default:j++;
	}
return j + x;
}
}
第三行的输出结果是（D）
A)   value = 5
B)   value = 6
C)   value = 7
D)   value = 8
3.下面程序运行后的结果是（B）
public class MyAr{ 
public static void main(String argv[]){
int[] i = new int[5];
System.out.println(i[5]);
} 
}
A)编译错误
B)运行错误
C)输出0
D)输出“null”
4.关于以下代码描述正确的有（D）
public class Cats {
public static void main(String args[]) {
List<Cat> cats = new ArrayList<Cat>();
cats.add(new Cat());
Animal b = new Animal();
Cat a = null;
if(b instanceof Animal) 
a = (Cat)b;
if(a != null) 
cats.add(a);
  System.out.println(cats.size() +"cats");
}
}
class Animal {}
class Cat extends Animal{}
	•	  编译失败
	•	  输出1 cats
	•	  输出2 cats
	•	  运行时抛出异常
5.以下为AB类的一个无形式参数无返回值的方法method书写方法头，使用类名AB作为前缀就可以调用它，该方法头的形式为（A）
A) static void method( )
B) public void method( )
C) final void method( )
D) abstract void method( )
6.从下面四段代码中选择出正确的代码段（C）
A) abstract class Name {
	private String name;
	public abstract boolean isStupidName(String name) {}
}
B) public class Something {
		void doSomething () {
			private String s = "";
			int l = s.length();
		}
}
C) public class Something {
public static void main(String[] args) {
Other o = new Other();
new Something().addOne(o);
}
public void addOne(final Other o) {
o.i++;
}
}
class Other {
public int i;
}
D) public class Something {
public int addOne(final int x) { 
return ++x;
}
}
7.下列有关线程的说法正确的是（B）
A) 启动一个线程是调用start（）方法，使线程所代表的虚拟处理机处于可运行状态，这意味着线程
此时就会立即运行。
B) notify（）方法可以确切的唤醒某个处于等待状态的线程。
C) wait（）方法可以使一个线程处于等待状态，但不会释放所持有对象的锁。
D) sleep（）方法使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法时，需要捕捉InterruptedException异常。
8.下面哪个流类属于面向字符的输入流（A）
A) BufferedWriter           
B) FileInputStream          
C) ObjectInputStream          
D) InputStreamReader
9.java Thread中，run方法和start方法的区别，下面说法错误的是（C）
A)通过调用Thread类的start()方法来启动一个线程，这时此线程是处于就绪状态，并没有运行。
B)他们都可以实现了多线程运行。
C)run方法是thread的一个普通方法调用。
D)调用start方法后，一旦得到cpu时间片，就开始执行run()方法。
10.Java语言中，负责并发管理的机制是(D)
A)  垃圾回收
B)  虚拟机
C)  代码安全
D)  多线程
二、简答题（每题4分，共40分）
1.简述java语言的跨平台原理。
Java语言可以通过使用 JVM 虚拟机给不同平台进行解释，所以具有了跨平台的功能和特性。 
2.写出单个字节所能表示的整数范围以及推导过程。
一个字节共8个单位，也就是0x00到0xff，0为正，1为负，所以0x0-0x7f 是1到127，0x80-0xff 是-128到-1，按位取反加一，所以一个字节的范围是-128到127共512个。
3.分析一下两种形式的区别
short s1 = 1; s1 = s1 + 1; 
short s1 = 1; s1 += 1; 
第一种是短整型和整形的运算，在计算结果的时候会强制转换，运行时报错；第二种是直接强转类型为整形，不会报错。
4.方法重载与方法重写的区别是什么？两者的作用又是什么？
重载是除了方法名其他都可以不同，重写是子类重写父类，方法名、参数类型、参数个数都要一样。
5.简述面向对象的三大特征并作出解释。
封装、继承和多态
6.写出final、finally以及finalize()的区别。
final 是关键字，代表最终，只能成为父类不能再有子类了；finally 是异常处理的时候使用，无论时候异常出现均执行；finalize()是方法名.
7.写出5个常见的运行时异常。
ArrayIndexOutofBoundsException 数组下标越界异常
ClassCastException 类型转换异常
NumberFormatException 数字格式异常
ArithmeticException 算数异常
NullPointerException	 空指针异常
8.简述抽象类和接口的主要区别。
抽象只能单继承，接口可以多实现；
抽象不能实例化对象；
接口的变量都是常量大写；
9.简述tcp协议和udp协议的主要区别。
TCP 是传输控制协议，服务器资源消耗大，数据发送效率低，但可靠稳定，使用全双工的通信方式；
UDP 是数据报协议，服务器资源消耗小，数据发送效率高，但不够稳定可靠，使用半双工的通信方式；
10.画出集合的框架图以及常用IO流之间的关系图。
三、编程题（每题10分，共40分）
1.实现Person类的封装以及equals()、hashCode()、toString()方法的重写，其中属性有：姓名和年龄。
	public class Person{
		private String name;
		private int age;
		public Test() {
			super();
		}
		public Test(String name, int age) {
			super();
			setAge(age);
			setName(name);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
			return false;
			if (getClass() != obj.getClass())
				return false;
			Test other = (Test) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Test [name=" + name + ", age=" + age + "]";
		}
	} 
2.编程实现单例设计模式的饿汉式和懒汉式。
public class SingerTon{
	private static SingerTon sin = new SingerTon();
	private SingerTon(){}
	public static SingerTon getInstance(){
		return sin;
	}
}
public class SingerTon{
	private static SingerTon sin = null;
	private SingerTon(){}
	public static SingerTon getInstance(){
		if(sin == null){
			sin = new SingerTon();
		}
		return sin;
	}
}
3.使用byte数组的方式实现文件的拷贝。
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy{
	FileInputStream f1 = new FileInputStream("test1.txt");
	FileOutputStream f2 = new FileOutputStream("test2.txt");
	byte[] arr= new byte[1024*8];
	int res = 0;
	while((res = f1.read())!=-1) {
		f2.write(arr, 0, res);
	}
}
4.使用基于tcp协议的编程模型完成以下功能：
要求客户端不断地向服务器发送从键盘输入的内容，服务器收到客户端的消息后不断地向客户端回发消息”I received!”。
https://github.com/carolcoral/JavaLearn/blob/master/JavaSE/Code/ServerSocket.java 
5.老王是卖鞋的，一双鞋进价30元甩卖20元，顾客来买鞋给了张50，老王没零钱，于是拿顾客的50元找邻居换了50元零钱。事后邻居发现钱是假的，老王又赔了邻居50。请问老王一共亏了多少？要求写出分析过程。（选做 10分）
