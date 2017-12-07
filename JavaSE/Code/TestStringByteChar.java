package xdl.day13;

public class TestStringByteChar {

	public static void main(String[] args) {
		String s1 = new String("GoodMorning!");
		//将string类型转换成byte数组然后转换回来
		//byte类型意思为转化字符为ASC编码的样式
		byte[] barr = s1.getBytes();
		//打印数组中的每个元素值
		for(int i=0;i<s1.length();i++){
			System.out.println(barr[i]);
		}
		//使用构造方法转换成string类型
		String s2 = new String(s1);
		System.out.println(s2);
		
		//将string类型转换成char类型转换回来
		//char类型主要用于net网络部分
		char carr[] = s1.toCharArray();
		for(int i=0;i<s1.length();i++){
			System.out.println(carr[i]);
		}
		String s3 = new String(carr);
		System.out.println(s3);

	}

}
