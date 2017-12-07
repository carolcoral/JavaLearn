package xdl.day13;

public class TestStringmanyMethod {

	public static void main(String[] args) {
		//1.构造字符串类型对象
		String s1 = new String("    let me Give you SoMe coloR to sEE see !    ");
		//2.判断当前字符串中是否包含自定的内容
		boolean b1 = s1.contains("SoMe");
		System.out.println("b1="+b1);//true
		b1 = s1.contains("some");
		System.out.println("b1="+b1);//false
		
		//3.判断当前字符串是否以。。开头以及以。。。结尾
		b1 = s1.startsWith("let");
		System.out.println("b1="+b1);//false
		b1 = s1.startsWith(" ");
		System.out.println("b1="+b1);//true
		b1 = s1.endsWith("let");
		System.out.println("b1="+b1);//false
		b1 = s1.endsWith("!");
		System.out.println("b1="+b1);//false
		
		//4.将当前字符串转换为大写、小写
		System.out.println("s1="+s1);//    let me Give you SoMe coloR to sEE see !    
		String s2 = s1.toUpperCase();//    LET ME GIVE YOU SOME COLOR TO SEE SEE !    
		//s1指向的字符串内容本身没有发生任何的改变
		System.out.println("s1="+s1);//    let me Give you SoMe coloR to sEE see !    
		System.out.println("s2="+s2);//    LET ME GIVE YOU SOME COLOR TO SEE SEE !    
		String s3 = s2.toLowerCase();
		System.out.println("s3="+s3);//    let me give you some color to see see !    
		
		//5.去除当前字符串中两端的空白字符
		String s4 = s1.trim();//let me Give you SoMe coloR to sEE see !
		System.out.println("s4="+s4);//let me Give you SoMe coloR to sEE see !

	}

}
