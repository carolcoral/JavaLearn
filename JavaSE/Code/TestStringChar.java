package xdl.day12;

public class TestStringChar {
	
	public static void main(String[] args) {
		String s1 = new String("goodMorning");
		System.out.println("s1="+s1);
		System.out.println("s1  lenghth="+s1.length());
		int[] data = new int[10];
		System.out.println("s1  length="+data.length);//数组的长度不加括号,不是类
		
		//char cv = s1.charAt(0);
		for(int i=0;i<s1.length();i++){
			System.out.println(s1.charAt(i));
		}
		System.out.println("");
		
	}
}
