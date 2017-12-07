1.编程题
  自定义Student类实现封装，特征有：学号和姓名，要求重写equals()、hashCode()以及toString()方法。
--------------------------------------------------------------------------------
今天内容：
    (1)String类
    (2)StringBuilder类和StringBuffer类
    (3)日期相关的类

1.String类(重中之重)
1.1 常用的方法   
(1)常用的构造方法
   String() - 使用无参的形式创建空对象，该对象中没有字符串内容。
   String(byte[] bytes) - 根据参数指定的数组内容来构造字符串对象。
   String(byte[] bytes, int offset, int length) 
       - 根据参数指定数组中从offset位置开始供length字节的数据来构造对象。
   String(char[] value) - 根据参数指定的字符数组构造对象。
   String(char[] value, int offset, int count) - 使用数组中的一部分构造对象。
   String(String original) - 根据字符串内容来构造对象。
   String(StringBuffer buffer) - 将StringBuffer类型转换为String类型。
   String(StringBuilder builder) - 将StringBuilder类型转换为String类型。
 
(2)常用的普通方法
   该类中重写了equals()、hashCode()以及toString()方法。
   char charAt(int index) - 用于获取当前字符串中下标为index位置的单个字符并返回。
   int length() - 用于返回当前字符串的长度，也就是字符的个数。

   int compareTo(String anotherString) 
      - 用于比较调用对象和参数对象的字符串大小关系并返回。
      - 使用当前字符串中第一个字符起的每个字符减去参数字符串中对应位置的字符
        若第一个字符不相等则可以代表字符串大小关系，若相等则使用下一个字符继续比较 
      - 若存在的字符都相同时，则大小取决于长度。
   int compareToIgnoreCase(String str) 
      - 用于比较调用对象和参数对象的字符串大小关系并返回。
      - 不考虑大小写，也就是'A'和'a'在该方法中认为是相等的关系。
如：
   "abc" 和 "bcd"比较大小：由于第一个字符'a'小于'b'，因此字符串"bcd"比较大；
   "abc" 和 "abd"比较大小：由于前两个字符相等，第三个字符'c'小于'd'，因此"abd"大；
   "abc" 和 "abcd"比较大小：由于前面字符相等，则大小取决于字符创长度，因此"abcd"大     
   boolean contains(CharSequence s) - 用于判断调用对象中是否包含参数指定的内容。
        - 其中参数是接口类型的引用，因此实参的传递有两种方式：
              a.创建实现类的对象作为实参传递，而String类就是该接口的实现类；
              b.使用匿名内部类来创建接口类型的对象作为实参传递；
   boolean endsWith(String suffix) 
        - 用于判断当前字符串中是否以参数指定的内容为结尾；
   boolean startsWith(String prefix) 
        - 用于判断当前字符串中是否以参数指定的内容为开头；
   String toLowerCase()  
        - 用于将当前字符串中所有的字符转换为小写并返回；
   String toUpperCase() 
        - 用于将当前字符串中所有字符串转换为大写并返回；
   String trim()
        - 用于去除当前字符串中两端的空白字符并返回； 
 
   boolean equals(Object anObject) 
        - 用于比较字符串内容是否相等并返回；
   boolean equalsIgnoreCase(String anotherString) 
        - 用于比较字符串内容是否相等并返回，不考虑大小写，如：'A'和'a'是相等。
练习：
   使用上述方法来模拟用户登录的过程，提示用户输入用户名和密码，若用户输入的用户名和密码为"admin"和"123456"，则提示"登录成功"，否则提示"用户名或密码错误"，直到3次输入
都失败，则提示"账号已冻结，请联系客服人员！"。

   byte[] getBytes() - 用于将当前字符串内容转换为byte数组并返回。
   char[] toCharArray() - 用于将当前字符串内容转换为char数组并返回。
   
   int indexOf(int ch) - 用于返回当前字符串中参数ch指定的字符第一次出现的下标。
   int indexOf(int ch, int fromIndex) - 用于从fromIndex位置开始查找ch指定的字符。
       - 上述方法若查找失败，则返回-1.
   int indexOf(String str) - 用于查找参数str指定的字符串并返回下标。
   int indexOf(String str, int fromIndex) - 用于从fromIndex位置开始查找。
 
   int lastIndexOf(int ch) - 用于返回参数ch指定的字符最后一次出现的下标。
   int lastIndexOf(int ch, int fromIndex) 
        - 用于从fromIndex位置开始查找ch指定字符出现的下标，反向搜索的第一次。
   int lastIndexOf(String str) - 用于返回str指定字符串最后一次出现的下标。
   int lastIndexOf(String str, int fromIndex) 
        - 用于从fromIndex位置开始反向搜索的第一次。
 
   String substring(int beginIndex) 
        - 用于获取当前字符串中从beginIndex位置开始的子字符串并返回。
   String substring(int beginIndex, int endIndex) 
        - 用于获取当前字符串中从beginIndex位置开始到endIndex结尾的子字符串并返回。

1.2 正则表达式（熟悉）
	1.基本概念：
		正则表达式本质上就是一个字符串，通常使用 ^ 开始 $ 结尾，用于对用户输入的数据格式进行验证或匹配，其中 ^ 和 $ 可以省略。
	2.常用规则：
		[abc]   — 可以出现a，b，c，其他不允许
		[^abc]    — 不可以出现a，b，c，其他允许
		
		\d          — 表示可以出现任意数字：[ 0 - 9 ]
		\D         — 表示可以出现任意非数字：[^0-9]
		\s          — 表示可以出现任意空白字符：[\t\n\x0B\f\r]
		\S          — 表示可以出现任意非空白字符：[^\s]
		\w         — 表示可以出现任意单词字符：[a-zA-Z_0-9]
		\W        — 表示可以出现任意非单词字符：[^\w]

		X？       — 表示X可以出现一次或一次也没有，也就是0-1次
		X*         — 表示X可以出现零次或多次，也就是0-n次
		X+        — 表示X可以出现一次或多次，也就是1-n次
		X{n}     — 表示X可以出现恰好n次
		X{n,}    — 表示X可以出现至少n次，也就是>=n次
		X{n,m} —  表示X可以出现至少n次，但是不超过m次，也就是>=n 并且 <=m次

	3.常用的方法
		boolean matches(String regex)  — 判断单钱字符串是否满足参数指定的规则

2.StringBuilder类和StringBuffer类（熟悉）
	1.基本概念：
		由于String类描述的字符序列是不可更改的，当程序中需要使用大量类似的字符串时就得分别申请空间存储，此时就会对内存空间的消耗比较大，巍峨节省空间希望直接对字符序列本身进行修改，则可以使用StringBuilder类和StringBuffer类取代之。
	StringBuffer类从jdk1.0开始存在，属于线程安全的类，因此效率比较低；
	StringBuilder类从jdk1.5版本开始存在，属于非线程安全类，因此效率高（推荐使用）。

	2.StringBuilder类
		1.基本概念：
			java.lang.StringBuilder类用于可变的字符序列，而且不保证线程安全；
		2.常用方法：
			StringBuilder（String str） — 根据参数指定字符串构造对象，初始容量：16+字符串的长度
			StringBuilder insert（int offset，String str） 
				— 将str插入到当前字符串中offset指向的位置上；
			StringBuilder append（String str）
				— 将str插入到当前字符串的末尾位置；
			StringBuilder delete（int start ，int end）
				— 将当前字符串中从start（包含）开始到end（不包含）之间的内容移除；
			StringBuilder replace（int start , int end , String str）
				— 将当前字符串中start到end之间的内容全部用str的内容替换；
			StringBuilder reverse（）
				— 实现字符串的反转；
			StringBuilder substring（）
			StringBuilder indexOf（）
			int capacity（）
				— 用于获取容量并返回
			int length（）
				— 用户返回字符串的长度
			该类只重写了toString()方法；


package xdl.day13;

public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");
		//字符串的容量和长度
		System.out.println("容量是："+sb.capacity());//16+5=21
		System.out.println("长度是："+sb.length());//5
		
		//StringBuilder insert（int offset，String str） 
		// — 将str插入到当前字符串中offset指向的位置上；
		System.out.println("插入后新字符串："+sb.insert(3,"yes"));
		
		// StringBuilder append（String str）
		// — 将str插入到当前字符串的末尾位置；
		System.out.println("插入末尾后的新字符串："+sb.append("world"));
		
		// StringBuilder delete（int start ，int end）
		// — 将当前字符串中从start（包含）开始到end（不包含）之间的内容移除；
		System.out.println("删除后的新字符串："+sb.delete(2, 4));
		
		// StringBuilder replace（int start , int end , String str）
		// — 将当前字符串中start到end之间的内容全部用str的内容替换；
		System.out.println("替换内容后的新字符串："+sb.replace(2, 4, "XXOO"));
		
		// StringBuilder reverse（）
		// — 实现字符串的反转；
		System.out.println("反转后的新字符串："+sb.reverse());
		
		// StringBuilder substring（）
		System.out.println("下标2的新字符："+sb.substring(2));
		
		// StringBuilder indexOf（）
		// — 从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
		System.out.println("从下标2开始查找的字符“l”出现的位置："+sb.indexOf("l",2));
	}

}


package xdl.day13;

import java.util.Scanner;

public class TestHomework {

	public static void main(String[] args) {
		// 笔试题：“abcdef1234@#$%”统计该字符串中字母、数字、字符的个数
		Scanner scanner = new Scanner(System.in);
		// String num = new String("abcdef1234@#$%");
		System.out.print("请输入一串字符：");
		String num = scanner.next();
		int[] arr = new int[3];
		for (int i = 0; i < num.length(); i++) {
			int re = num.charAt(i);
			if ((re >= 'a' && re <= 'z') || (re >= 'A' && re <= 'Z')) {
				arr[0]++;
			} else if (re >= '0' && re <= '9') {
				arr[1]++;
			} else {
				arr[2]++;
			}
		}
		scanner.close();
		System.out.println("输入了“" + num + "”这个字符串，该字符串一共有" + arr[0] + "个字母和" + arr[1] + "数字以及" + arr[2] + "个其他符号");

		System.out.println("-------------------------------------------------");
		// 笔试题：自定义成员方法将字符串“123456”转换成整数123456并打印出来
		String pr = new String("123456");
		int sum = 0;
		for (int j = 0; j < pr.length(); j++) {
			// int num2 = pr.charAt(j) - '0';
			sum = sum * 10 + pr.charAt(j) - '0';
		}
		System.out.println(sum);
	}

}
