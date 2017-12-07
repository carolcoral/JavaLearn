package xdl.day14;

import java.util.*;

public class TestCollection {

	public static void main(String[] args) {
		// Collection c1 = new Collection(); 接口不能实例化对象
		// 接口类型的引用指向实现类的对象，形成了多态
		Collection<Object> c1 = new ArrayList<Object>();

		// 在编译阶段应该调用Collection自己的toString()，在运行阶段调用ArrayList()的toString()
		// toString()方法的打印格式为：[元素1， 元素2， 。。。。。]
		System.out.println("c1 = " + c1); // 自动调用toString方法
		System.out.println("——————————————————————————————————————————");

		// 实现向集合c1中增加单个元素
		boolean b1 = c1.add(new Integer(1));
		System.out.println("b1 = " + b1);// true
		System.out.println("c1 = " + c1);// c1 = [1]
		b1 = c1.add(new String("two"));
		System.out.println("b1 = " + b1);// true
		System.out.println("c1 = " + c1);// c1 = [1,two]
		// 需要一个student.java
		b1 = c1.add(new Student(1001, "student", 30));
		System.out.println("b1 = " + b1);// true
		// 打印集合的本质就是打印集合中的每个元素
		// 打印每个元素的本质就是调用每个元素自己的toString（）方法
		System.out.println("c1 = " + c1);

		System.out.println("——————————————————————————————————————————");

		// 实现向集合中添加另外一个集合的所有元素
		// 准备另外一个集合
		@SuppressWarnings("rawtypes")
		Collection<Comparable> c2 = new ArrayList<Comparable>();
		c2.add(new Integer(3));
		c2.add(new String("four"));

		b1 = c1.addAll(c2);
		// b1 = c1.add(c2);
		System.out.println("c1 = " + c1);

		Collection<Object> c4 = new ArrayList<Object>(c1);

		System.out.println("——————————————————————————————————————————");

		// 判断当前集合中是否包含参数指定的单个元素
		// ( o == null ? e == null : o.equals(e) )
		// 当contains（）方法的形参为空时，只需要判断当前集合中是否有元素为空即可
		// 当contains（）方法的形参不为空时，就需要参数对象调用equals（）方法与集合元素比较
		// 因为在student中没有重写equals方法，所以调用的是object中的equals方法，判断的是地址是否相等
		b1 = c1.contains(new Integer(2));
		System.out.println(b1);
		b1 = c1.contains(new String("two"));
		System.out.println(b1);
		b1 = c1.contains(new Student(1001, "zhangfei", 30));
		System.out.println(b1);

		// 判断当前集合中是否包含参数指定的所有元素
		b1 = c1.containsAll(c2);
		System.out.println(b1);// true
		// 因为在上面c2已经被拆分成3，four两个元素，而不再是[3，four]的形式，所以使用contains整体做判断的时候返回false
		b1 = c1.contains(c2);
		System.out.println(b1);

		System.out.println("——————————————————————————————————————————");
		System.out.println("原装c1 = " + c1);
		Collection<Object> c3 = new ArrayList<Object>(c1);
		// 实现单个元素的删除
		b1 = c1.remove(new Integer(1));
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);
		b1 = c1.remove(new String("two"));
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);
		b1 = c1.remove(new Student(1001, "zhangfei", 30));
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);
		// 实现集合中多个元素的删除操作
		c1 = c3;
		b1 = c1.removeAll(c2);
		System.out.println("b1 = " + b1);
		System.out.println("c1 = " + c1);

		// 实现集合中元素的清空
		c1.clear();
		System.out.println("c1 = " + c1);

		System.out.println("——————————————————————————————————————————");

		c1 = c4;
		System.out.println(c1);
		// 判断集合是否为空以及返回元素个数
		System.out.println(c1.isEmpty() ? "什么都没有" : "元素不为空");
		System.out.println("元素的个数是：" + c1.size());
		// 计算两个集合的交集并返回结果
		b1 = c1.retainAll(c2);
		System.out.println("b1=" + b1);
		System.out.println("c1=" + c1);
	}

}
