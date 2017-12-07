package xdl.day12;

public class TestStringConstractor {

	public static void main(String[] args) {
		// 1.使用String类型的各种构造方法构造
		String s1 = new String();
		System.out.println("s1="+s1);//自动调用toString类
		//2.使用整个byte数组中的内容来构造对象
		byte[] data = {65,66,67,68,69,70,71};
		String s2 = new String(data);
		System.out.println("s2="+s2);
		//3.表示使用数组从小标从3的位置开始总共2个字节的数据来构造对象
		String s3 = new String(data,3,2);
		System.out.println("s3="+s3);
		//4.使用真个char数组中的所有内容来构造对象
		char[] cdata = {'a','b','c','d','e','f'};
		String s4 = new String(cdata);
		System.out.println("s4="+s4);
		//5.表示使用数组从小标从3的位置开始总共2个字节的数据来构造对象
		String s5 = new String(cdata,3,2);
		System.out.println("s5="+s5);
		//6.使用整个字符串构造方法
		String s6 = new String("abcdef");
		System.out.println("s6="+s6);
	}

}
