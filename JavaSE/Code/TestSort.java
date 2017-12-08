package xdl.day16;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestSort {

	public static void main(String[] args) throws AgeExcption {

		Comparator<Student> c1 = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getId() - o2.getId();
			}
		};

		Comparator<Student> c2 = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		Set<Student> s1 = new TreeSet<Student>(c1);
		s1.add(new Student(9, "b", 3));
		s1.add(new Student(5, "a", 2));
		s1.add(new Student(7, "c", 3));
		for(Student m:s1){
			System.out.println(m);
		}
		
		s1 = new TreeSet<Student>(c2);
		s1.add(new Student(9, "b", 3));
		s1.add(new Student(5, "a", 2));
		s1.add(new Student(7, "c", 3));
		for(Student m:s1){
			System.out.println(m);
		}

	}

}
