package xdl.day14;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws Exception{
		// 每个地区的标准时间是不一样的，因为存在时区的差异新，中国属于东八区，因此标准时间是1970年1月1日8时0分0秒
		// 1.使用各种不同的版本构造对象
		Date d1 = new Date();
		System.out.println("d1=" + d1);// 打印系统时间

		Date d2 = new Date(1000);
		System.out.println("d2=" + d2);// 1000毫秒
		
		

		// Date d3 = new Date(2008 - 1900, 8 - 1, 8, 20, 8, 8);//
		// 此方法已过时，年份减去1900年，月份减去1，表示当前计算时间
		// System.out.println("d3=" + d3);
		//2.使用取代的方法来构造年月日时分秒
		//2.1获取calendar类型的对象
		Calendar c1 = Calendar.getInstance();
		//2.2调用set（）方法来设置年月日时分秒
		c1.set(2008, 8-1,8,20,8,8);
		//2.3转换成Date类型
		Date d6 = c1.getTime();
		System.out.println("d6 = "+d6);
		//3.调整输出格式
		
		
			
		long msec = d1.getTime();
		System.out.println("距离当前系统时间标准时间的好秒速msec=" + msec);
		d1.setTime(2000);
		System.out.println("d1 = " + d1);// 距离1970 1 1 8 0 2

		// 1.创建SimpleDateFormat类型的对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		// 将上述日期信息按照构造方法指定的格式来转换成字符串类型
		String str = sdf.format(d1);
		System.out.println(str);
		//根据字符串转换成日期类型
		Date d5 = sdf.parse(str);
		System.out.println(d5);

	}

}
