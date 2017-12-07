package xdl.day13;

import java.util.Scanner;

public class TestStringReg {

	public static void main(String[] args) {
		// 1.准备一个描述正则表达式的字符串
		// 描述银行卡密码的规则，要求由六位数字组成
		// String reg = "^[0-9]{6}$";
		// 在编码中需要两个\组成一个\识别
		// String reg = "\\d{6}";

		// 描述手机号码的规则，要求由11位数字组成，其中1开头，第二位必须是345789
		// String reg = "[1]{1}[345789]{1}\\d{9}";

		// 描述座机号码的规则，要求3-4位区号，中间使用-连接，后面7-8位号码
		// String reg = "\\d{3,4}[-]{1}\\d{7,8}";

		// 描述身份证号码的规则，要求由17位数字与最后一位是X或者数字组成，前6位要求表示地区，4位表示年份，4位表示月日，3位校验码，最后一位可能是数字可能是X
		// String reg = "\\d{6}\\d{8}\\d{3}[0-9X]{1}";

		// 描述用户名规则，要求6-8位数字、字母以及下划线组成
		// String reg = "\\w{6,8}";

		// 描述邮箱的规则，要求字母、数字以及下划线组成名称，中间@符号，后面2-5位的字母或者数字组成.最后加上后缀.com\.org\.cn\.edu\.com.cn
		String reg = "\\w{1,}[@]{1}[0-9a-zA-Z]{2-5}(.com|.org|.cn|.edu|.com.cn)";

		// 2.不断的提示用户输入一个字符串，若匹配上诉规则则结束输入，否则继续输入
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入邮箱号码：");
			String str = sc.next();
			if (str.matches(reg)) {
				System.out.println("格式正确！");
				break;
			} else {
				System.out.println("格式不正确！");
				continue;
			}
		}
		sc.close();
	}

}
