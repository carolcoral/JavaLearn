package xdl.day15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestHomeWork {

	public static void main(String[] args) throws ParseException {
		// 1.提示用户按照指定的格式输入生日信息，计算距离1970年1月1日的天数并打印出来
		// 如输入格式：1998年1月5日
		Scanner sc = new Scanner(System.in);
		System.out.println("请按照格式输入您的生日信息(yyyy年MM月dd日)：");
		String input = sc.next();
//		String regx = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})年(((0[13578]|1[02])月(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)月(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))日)";
//		boolean re = input.matches(regx);
		boolean re = true;
		if (re == false) {
			System.out.println("您输入的日期格式不正确！请重新输入！");
		} else {
			SimpleDateFormat stf = new SimpleDateFormat("yyyy年MM月dd日");
			Date sr = stf.parse(input);
			long res1 = sr.getTime();
			// 因为当前地区处于东八区，多余8小时，因此需要减去8小时的毫秒数，然后除去一天的毫秒数
			// 因为当前一天减去的数量没有计算前面一天，因此需要在总数上加1
			long res = (res1 - 8 * 60 * 1000) / (24 * 60 * 60 * 1000) ;

			System.out.println("您输入的生日日期已经距离1970年1月1日共：" + res + "天！！");
		}
		sc.close();
	}

}
