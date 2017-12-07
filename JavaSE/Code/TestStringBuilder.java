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
