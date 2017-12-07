package xdl.day16;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		// 声明Map类型的引用指向hashMap类型的对象
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		// 向集合中增加元素
		String s1 = m1.put(1, "one");
		System.out.println("s1 = " + s1);
		System.out.println("m1:" + m1);
		s1 = m1.put(2, "two");
		System.out.println("s1 = " + s1);
		System.out.println("m1:" + m1);
		s1 = m1.put(3, "three");
		System.out.println("s1 = " + s1);
		System.out.println("m1:" + m1);
		// 实现元素的修改
		s1 = m1.put(1, "eleven");
		System.out.println("s1 = " + s1);
		System.out.println("m1:" + m1);

		// 实现元素的查找功能
		boolean b1 = m1.containsKey(1);
		System.out.println("b1 = " + b1);
		b1 = m1.containsValue("two");
		System.out.println("b1 = " + b1);

		// 遍历元素类所有值
		for (int i = m1.size(); i > 0; i--) {
			System.out.println(m1.get(i));
		}

		// 移除元素中的数据
		String s2 = m1.remove(1);
		System.out.println("移除的元素是：" + s2);
		System.out.println("现在的元素有：" + m1);

		// 转换 Map 类型为 Set 类型
		Set<Map.Entry<Integer, String>> sm = m1.entrySet();
		for (Map.Entry<Integer, String> it : sm) {
			System.out.println(it);
			System.out.println("拼接：" + it.getKey() + " = " + it.getValue());
		}

		// 将 Map 集合中的所有 key 转换为 Set 集合的视图
		Set<Integer> s4 = m1.keySet();
		for (Integer im : s4) {
			System.out.println("s4");
			System.out.println("拼接后的:" + im + " = " + m1.get(im));
		}

	}

}
