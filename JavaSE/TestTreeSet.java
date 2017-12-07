package xdl.day16;

import java.util.*;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// 1.使用set类型的引用指向TreeSet类型的对象
		Set<Integer> s1 = new TreeSet<Integer>();
		// 2.向集合中添加元素
		s1.add(10);
		s1.add(20);
		s1.add(30);
		// 3.打印集合中的所有元素
		// 在打印的时候按照中序遍历打印：先左-根-后右
		System.out.println(s1);

		System.out.println("———————按照学号排序的方式（自然排序）————————");
		Set<Student> s2 = new TreeSet<Student>();
		try {
			s2.add(new Student(1002, "zhaoyun", 30));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s2.add(new Student(1001, "guanyu", 35));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s2.add(new Student(1003, "zhangfei", 25));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Student s : s2) {
			System.out.println(s);
		}

		System.out.println("————————按照姓名排序的方式————————");
		// 使用匿名内部类的方式构建接口类型的对象
		Comparator<Student> c1 = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// 其中该方法的o1代表新增加的元素，o2代表已有的对象
				// 比较姓名的大小
				return o1.getName().compareTo(o2.getName());
			}

		};
		Set<Student> s3 = new TreeSet<Student>(c1);
		try {
			s3.add(new Student(1002, "zhaoyun", 30));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s3.add(new Student(1001, "guanyu", 35));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s3.add(new Student(1003, "zhangfei", 25));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Student s : s3) {
			System.out.println(s);
		}

		System.out.println("————————按照年龄排序的方式———————");
		Comparator<Student> c2 = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// 其中该方法的o1代表新增加的元素，o2代表已有的对象
				// 比较年龄的大小
				return o1.getAge() - o2.getAge();
			}

		};
		Set<Student> s4 = new TreeSet<Student>(c2);
		try {
			s4.add(new Student(1002, "zhaoyun", 30));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s4.add(new Student(1001, "guanyu", 35));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s4.add(new Student(1003, "zhangfei", 25));
		} catch (AgeExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Student s : s4) {
			System.out.println(s);
		}

	}

}
