package xdl.day13;

public class TestStringCompareTo {

	public static void main(String[] args) {
		String s1 = new String("abc");
		//从第一个字符起对应的位置的字符做减法运算，若第一个字符能比较出来大小，则后面的不在比较
		//如第一个字符相等则使用下一个位置的字符比较，一次类推
		//直到最后一个字符也不能比较出大小关系时，则使用长度比较
		System.out.println(s1.compareTo("abd"));
		System.out.println(s1.compareTo("acd"));
		System.out.println(s1.compareTo("abd"));
		System.out.println(s1.compareTo("abcd"));
		System.out.println(s1.compareTo("aaa"));
		
		System.out.println("————————————————————————————————————");
		System.out.println(s1.compareToIgnoreCase("abc"));
		System.out.println(s1.compareToIgnoreCase("abcd"));
		System.out.println(s1.compareToIgnoreCase("acd"));
		System.out.println(s1.compareToIgnoreCase("acd"));
		System.out.println(s1.compareToIgnoreCase("ab"));
		
		System.out.println("————————————————————————————————————");

	}

}
