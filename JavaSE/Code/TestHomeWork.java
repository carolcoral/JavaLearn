package xdl.day13;

import java.util.Scanner;

public class TestHomework {

	public static void main(String[] args) {
		// 笔试题：“abcdef1234@#$%”统计该字符串中字母、数字、字符的个数
		Scanner scanner = new Scanner(System.in);
		// String num = new String("abcdef1234@#$%");
		System.out.print("请输入一串字符：");
		String num = scanner.next();
		int[] arr = new int[3];
		for (int i = 0; i < num.length(); i++) {
			int re = num.charAt(i);
			if ((re >= 'a' && re <= 'z') || (re >= 'A' && re <= 'Z')) {
				arr[0]++;
			} else if (re >= '0' && re <= '9') {
				arr[1]++;
			} else {
				arr[2]++;
			}
		}
		scanner.close();
		System.out.println("输入了“" + num + "”这个字符串，该字符串一共有" + arr[0] + "个字母和" + arr[1] + "数字以及" + arr[2] + "个其他符号");

		System.out.println("-------------------------------------------------");
		// 笔试题：自定义成员方法将字符串“123456”转换成整数123456并打印出来
		String pr = new String("123456");
		int sum = 0;
		for (int j = 0; j < pr.length(); j++) {
			// int num2 = pr.charAt(j) - '0';
			sum = sum * 10 + pr.charAt(j) - '0';
		}
		System.out.println(sum);
	}

}
