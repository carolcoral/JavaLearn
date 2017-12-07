package xdl.day13;

public class TestStringindexOf {

	public static void main(String[] args) {
		String s1 = new String("Good Good Study ,Day Day up !");
		// 查找指定字符
		int pos = s1.indexOf("s");
		System.out.println("pos = " + pos);// -1
		pos = s1.indexOf("S");
		System.out.println("pos = " + pos);// 10
		
		System.out.println("————————————————————————————————————————————————");
		// 查找字符串
		pos = s1.indexOf("day");
		System.out.println("pos = " + pos);// -1
		pos = s1.indexOf("Day");
		System.out.println("pos = " + pos);// 17
		
		System.out.println("————————————————————————————————————————————————");
		// 从指定的位置开始查找
		pos = s1.indexOf("Day", 17);
		System.out.println("pos = " + pos);// 17
		pos = s1.indexOf("Day", 18);
		System.out.println("pos = " + pos);// 21
		
		System.out.println("————————————————————————————————————————————————");
		// 查找所有“Day”出现的位置并打印出来
		pos = s1.indexOf("Day");
		while (pos != -1) {
			System.out.println(pos);
			pos = s1.indexOf("Day", pos + 1);
		}
		
		System.out.println("————————————————————————————————————————————————");
		// 风骚模式
		pos = 0;
		while ((pos = s1.indexOf("Day", pos)) != -1) {
			System.out.println(pos);
			// pos++;
			pos += "Day".length();//优化了运算，跨过“day”的3个不可能字符
		}
		
		//"Good Good Study ,Day Day up !"
		pos = s1.lastIndexOf("O");
		System.out.println(pos);//-1
		pos = s1.lastIndexOf("o");
		System.out.println(pos);//7
		pos = s1.lastIndexOf("o",7);
		System.out.println(pos);//7
		pos = s1.lastIndexOf("o",6);
		System.out.println(pos);//6
		
		//"Good Good Study ,Day Day up !"
		//从指定的字符串下标位置开始从后往前返回值
		pos = s1.lastIndexOf("good");
		System.out.println(pos);
		pos = s1.lastIndexOf("Good");
		System.out.println(pos);
		pos = s1.lastIndexOf("good",7);
		System.out.println(pos);
		pos = s1.lastIndexOf("good",6);
		System.out.println(pos);
		
		//从指定位置开始返回值
		String s2 = s1.substring(5);
		System.out.println(s2);//Good Study ,Day Day up !
		String s3 = s1.substring(8,15);
		System.out.println(s3);//d Study

	}

}
