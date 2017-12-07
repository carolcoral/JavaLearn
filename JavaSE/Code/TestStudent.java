package xdl.day13;

import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {
		// 首先输入学生人数，循环输入班级的学生信息，然后放入Student数组中，并打印所有姓zhang的学生信息。
		// 要求姓名用拼音(不要用汉字),学生所有信息用String格式输入，中间用逗号隔开。
		// 其中学生信息有：学号、姓名以及年龄。
		// 提示：
		// 需要查询String类中的split()方法进行字符串拆分，实参传递逗号(",")即可。
		// Student[] arr = new Student[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生人数：");
		int sum = sc.nextInt();
		Student[] arr = new Student[sum];
		for (int i = 0; i < sum; sum++) {
			System.out.println("请输入第" + (i + 1) + "个学生的信息（学号，姓名，年龄）:");
			String str = sc.next();
			String[] strs = str.split(",");
			arr[i] = new Student(Integer.parseInt(strs[0]), strs[1], Integer.parseInt(strs[2]));
		}
		System.out.println("输入需要查找的姓名：");
		String serch = sc.next();
		for (int i = 0; i < sum; i++) {
			if (arr[i].getName().startsWith(serch)) {
				System.out.println(arr[i]);
			}
		}
		sc.close();
	}
}
