package xdl.day15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		boolean b1 = s1.add("one");
		System.out.println("b1 = " + b1);
		System.out.println("s1 = " + s1);
		b1 = s1.add("two");
		System.out.println("b1 = " + b1);
		System.out.println("s1 = " + s1);
		b1 = s1.add("three");
		System.out.println("b1 = " + b1);
		System.out.println("s1 = " + s1);
		b1 = s1.add("one");
		System.out.println("b1 = " + b1);//false  实现了去重的效果
		System.out.println("s1 = " + s1);
		
		System.out.println("——————————————————————————————————————————-");
		
		Iterator<String> it = s1.iterator();
		//判断该集合中是否有可访问的元素
		// System.out.println(it.hasNext());
		// System.out.println(it.next());
		// System.out.println(it.next());
		// System.out.println(it.next());
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("——————————————————————————————————————————-");
		//
		it = s1.iterator();
		while(it.hasNext()){
			String str = it.next();
			if(str.equals("two")){
				it.remove();
			}else{
				System.out.println("删除的数据是："+str);
			}
		}
		System.out.println("删除后的新结果是："+s1);
		
		System.out.println("——————————————————————————————————————————-");
		//使用增强版的for循环遍历集合s1
		for(String tr : s1){
			System.out.println(tr);
		}
		
		System.out.println("——————————————————————————————————————————-");
		//使用增强版的for循环遍历数组的所有元素
		int[] arr ={11,22,33,44,55,66};
		for(int i : arr){
			System.out.println(i);
		}
		
	}

}