package xdl.day15;

import java.util.ArrayList;
import java.util.Collection;

public class TestCode {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Collection<Comparable> c1 = new ArrayList<Comparable>();
		boolean b1 = c1.add(new Integer(1));
		b1 = c1.add(new String("two"));
		b1 = c1.add(new Integer(2));
		System.out.println(c1);
		Collection<Comparable> c2 = new ArrayList<Comparable>();
		b1 = c2.add(3);
		b1 = c2.add("four");
		b1 = c1.addAll(c2);
		System.out.println("b1 = "+b1+",c2 = "+c1);

	}

}
