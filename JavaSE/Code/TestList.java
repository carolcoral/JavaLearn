package xdl.day15;

import java.util.LinkedList;
import java.util.List;

public class TestList {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		//父类的引用指向子类的对象
		List<Comparable> l1 = new LinkedList<Comparable>();
		boolean b1 = l1.add(1);
		System.out.println("b1 = "+b1+"l1 = "+l1);
		l1.add("two");
		System.out.println(l1);
		List<Object> l2 = new LinkedList<Object>();
		l2.add(3);
		l2.add(0,"two");
		l2.add(1,l1);
		System.out.println(l2);
		
		//实现将指定位置的元素修改为制定的数值
		Integer it2 = (Integer)l1.set(0, new String("one"));
		System.out.println("被修改的元素时："+it2);
		System.out.println("集合的元素时："+l1);
		String it3 = (String)l1.set(1, new String("three"));
		System.out.println("被修改的元素时："+it3);
		System.out.println("集合的元素时："+l1);
		
		//获取指定位置的元素并打印
		String s1 = (String)l1.get(0);
		System.out.println("下标为0的位置元素时;"+s1);
		String s3 = (String)l1.get(1);
		System.out.println("下标为1的位置元素时;"+s3);
		
		//实现类似toString()的方法
		for(int i =0;i<l1.size();i++){
			if(i == l1.size()-1){
				System.out.println(l1.get(i)+"]");
			}else{
				System.out.print("["+l1.get(i)+",");
			}
		}

	}

}
