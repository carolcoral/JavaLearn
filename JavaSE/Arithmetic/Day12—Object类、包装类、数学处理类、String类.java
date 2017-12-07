今日内容：
	1.Object类（详情看11.rtf的4.2章节）
	2.包装类和数学处理类
	3.String类


2.包装类和数学处理类
2.1 包装类的由来
	java语言是一门纯面向对象的编程语言；
	Person p = new Person();   — Person是引用数据类型，p是对象
	int num = 10;                    — int是基本数据类型，num是变量

	在某些特殊场合中（集合），要求所有数据都必须是对象，但对于八种基本数据类型来说不满足此需求，此时就需要对基本数据类型声明的变量进行对象化处理，因此需要借助包装类进行包装。 

2.2 Integer类（重点）
	1.基本概念：
		java.lang.Integer类实现对int类型的包装，也就是让int类型的变量作为该类成员。
		该类由final修饰表示不能被继承。
	2.常用的方法：
		integer(int value)       — 根据参数指定的整数来构造对象
		Integer(String value)   — 根据参数指定的字符串来构造对象
		该类重写了equals（）、hashCode（）、toString（）方法

		int intValue() 		— 用于将Integer类型的数据转换为int类型并返回
		static Integer valueOf（int i）	— 用于将int类型转换为Integer类型并返回
	
		static int parseInt(String s)  — 用于将String类型转换为int类型并返回
	
	3.装箱和拆箱
		从int类型向Integer类型的转换叫装箱
		从Integer类型向int类型的转换叫拆箱

		从JDk1.5开始支持自动装箱和自动拆箱的机制。

	4.自动装箱池（底层原理）
		由于开发中可能会经常涉及装箱的实现，因此在Integer类的内部提供了一个自动装箱池，将-128 ~ 127 之间的整数提前装箱完毕，若程序中使用该范围的数据则可以直接从池中获取，从而提高了效率。

2.3 BigDecimal类（熟悉）
	1.基本概念：
		由于float和double类型在运算时有误差，因此可以使用  java.math.BigDecimal  类型，实现精确运算。
	2.常用方法：
		BigDecimal（String val）  — 根据参数指定的字符串来构造对象
		
		BigDecimal add（BigDecimal augend）   — 用于计算调用对象和参数对象的和并返回
		BigDecimal  subtract（BigDecimal augend）   — 用于计算调用对象和参数对象的差并返回
		BigDecimal multiply（BigDecimal multiply）   — 用于计算调用对象和参数对象的积并返回
		BigDecimal divide（BigDecimal divide）   — 用于计算调用对象和参数对象的商并返回

	注意：当使用divide（）计算除不尽的时候，可以使用divide（BigDecimal divide，BigDecimal.ROUND_HALF_UP）进行精度确认，精度确认的方式一共有十一种，详细参考该类的手册内容。

2.4 BigInteger类（熟悉）
	1.基本概念：
		由于long类型表示的整数范围依然有限，若希望表示更大的整数则需要借助  java.math.BigInteger  类。
	2.常用方法：
		BigInteger（String val）  — 根据参数指定的字符串来构造对象
		
		BigInteger add（BigInteger  val）  — 用于实现调用对象和参数对象的和并返回
		BigInteger subtract（BigInteger  val）  — 用于实现调用对象和参数对象的差并返回
		BigInteger multiply（BigInteger  val）  — 用于实现调用对象和参数对象的积并返回
		BigInteger divide（BigInteger  val）  — 用于实现调用对象和参数对象的商并返回
		BigInteger[] divideAndRemainder（BigInteger  val）  
					— 用于实现调用对象和参数对象的商和余数组成的数组并返回。
					— 以后的编程中若希望在方法体中返回多个数据时，可以采用组成数组并返回的手法

3.String类（重中之重）
3.1 基本概念：
	 java.lang.String 类用于描述字符串数据。java程序中所有字符串字面值都可以使用该类的对象加以描述和处理。如：“ab”等，双引号描述。
	该类描述的字符创数据是常量，不可更改，因此可以共享使用  public final。
	该类由  final  关键字修饰表示不能继承。
	如：
		String s1 = “hello”；   — 其中“hello”是个常量，不可更改
		s1 = “world”；           — 使得引用变量 s1 由指向 “hello” 更改为指向 “world” ，改变指向。

	注意：
		String s1 = null； 和String s1 = “”；
		其中前者的s1表示没有明确的指向，也就是没有String字符串对象。容易引发空指针异常。
		其中后者的s1有明确的指向，只是该字符串对象中没有内容而已。

3.2 常用方法
	1.常用的构造方法：
		String（）  — 使用无参的形式创建空对象，该对象中没有字符串内容。
		String（byte[] bytes）  — 根据参数指定的数组内容来构造字符串对象。
		String（byte[]  , int offset , int length）
				— 根据参数指定的数组中从offset位置开始供length字节的数据来构造对象。
		String（char[] value）    — 根据参数指定的字符数组构造对象
		String（char[] , int offset , int count）   — 使用数组中的一部分构造对象。
		String（String original）    — 根据字符串内容来构造对象。
		String（StringBuffer buffer）   — 可以将StringBuffer类型转换成String类型。
		String（StringBuilder builder）  — 可以将StringBuilder类型转换成String类型。

	2.常用的构造方法
		重写了toString（）、equals（）、hashCode（）方法。
		char charAt(int index)   — 用于获取当前字符串中下标为index位置的单个字符并返回。
		int length()   — 用于返回当前字符串的长度，也就是个数。

package xdl.day12;

import java.math.BigDecimal;

public class TestBigDecimal {

	public static void main(String[] args) {
		BigDecimal bd1 = new BigDecimal("5.3");
		BigDecimal bd2 = new BigDecimal("1.3");
		
		//2.计算b1和b2的和差积商
		BigDecimal res = bd1.add(bd2);
		System.out.println("计算和res="+res);  //自动调用toString方法
		res = bd1.subtract(bd2);
		System.out.println("计算差res="+res);  //自动调用toString方法
		res = bd1.multiply(bd2);
		System.out.println("计算积res="+res);  //自动调用toString方法
		res = bd1.divide(bd2,BigDecimal.ROUND_FLOOR);//BigDecimal.ROUND_FLOOR接近负无穷大的舍入模式
		System.out.println("计算商res="+res);  //自动调用toString方法
		
		//3.对比double类型的运算精度
		System.out.println(0.1+0.2);
		BigDecimal bd3 = new BigDecimal("5.3");
		BigDecimal bd4 = new BigDecimal("1.3");
		System.out.println(bd3.add(bd4));
		//4.商除不尽的情况处理
		BigDecimal bd5 = new BigDecimal("5");
		BigDecimal bd6 = new BigDecimal("3");
		BigDecimal res2 = bd5.divide(bd6,BigDecimal.ROUND_HALF_UP);
		System.out.println(res2);//使用BigDecimal后面加上ROUND_HALF_UP进行四舍五入
	}

}


package xdl.day12;

public class TestHomework {

	public static void main(String[] args) {
		//笔试题：“abcdef1234@#$%”统计该字符串中字母、数字、字符的个数
		String num = new String("abcdef1234@#$%");
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(int i=0;i<num.length();i++){
			int re = num.charAt(i);
			if((re>='a'&&re<='z')||(re>='A'&&re<='Z')){
				count1 ++;
			}else if(re>='0'&&re<='9'){
				count2 ++;
			}else{
				count3 ++;
			}
		}
		System.out.println("“"+num+"”字符串，该字符串一共有"+count1+"个字母和"+count2+"数字以及"+count3+"个其他符号");
		//笔试题：自定义成员方法将字符串“123456”转换成整数123456并打印出来
		String pr = new String("123456");
		for(int j=0;j<pr.length();j++){
			int num2 = pr.charAt(j) - '0';
			System.out.print(num2);
			
		}
	}

}
