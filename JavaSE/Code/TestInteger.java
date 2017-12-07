package xdl.day12;

public class TestInteger {

	public static void main(String[] args) {
		//1.实现Integer类型的构造方法来构造对象
		Integer it1 = new Integer(12345);
		System.out.println("it1="+it1);
		Integer it2 = new Integer(213123123);
		System.out.println("it2="+it2);
		//2.实现int类型向Integer类型的转换
		//实现了从Integer类型到int类型的转换
		int num = it1.intValue();
		System.out.println("num="+num);
		//实现了从int类型到Integer类型的转换
		Integer it3 = Integer.valueOf(num);
		System.out.println(it3);
		
		//3.String类型向int类型转换
		int res = Integer.parseInt("1234566");
		System.out.println("res="+res);//结果是1234566，int类型
		
		//4.观察自动装箱和自动拆箱
		Integer it4 = 66; //自动装箱，完成int向Integer转换
		res = it4;        // Integer => int
		
	}

}
