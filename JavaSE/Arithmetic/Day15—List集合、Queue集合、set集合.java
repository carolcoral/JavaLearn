￼今日内容：
	1.List集合
	2.Queue集合
	3.Set集合

1.List集合（重中之重）
1.1 基本概念：
	java.util.List接口是Collection接口的子接口，元素有放入次序，并且允许重复。
	该接口的主要实现类：ArrayList类、LinkedList类、Stack类、Vector类。
	其中ArrayList类的底层是采用动态数组实现的，增删操作不方便（可能会操作大量的元素），通过下标访问方便。
	其中LinkedList类的底层是采用链表实现的，增删操作方便，访问元素不方便（需要一个一个找元素）。
	其中Stack类的底层是采用动态数组实现的，该结构具有后进先出的特征，简称为LIFO（last  in first out 栈）。	
	其中Vector类的底层是采用动态数组实现的，与ArrayList类相比属于早期提供的类，是属于线程安全的类，因此效率比较低，推荐使用ArrayList类取代。

1.2 常用方法
	void add(int index, E element) 	— 用于将元素element插入到当前集合中的index位置。
	boolean addAll(int index, Collection<? extends E> c) 					
	— 用于将集合c中的所有元素插入当前集合的index位置。
	E remove(int index)	— 用于将当前集合中index位置的元素移除。
					— 成功则返回移除的元素值
	E set(int index, E element) 	— 用于将下标为index位置的元素替换为element
					— 成功则返回被替换的元素值
	E get(int index) 	— 用于获取下标为index位置的元素并返回
	List<E> subList(int fromIndex, int toIndex) 
					— 用于获取当前集合中从fromIndex（含）到toIndex（不含）位置的视图；
					— 视图本质就是指获取到的内容并没有单独保存，依旧是共享之前的数据；

1.3 泛型机制
	通常	情况下集合中允许存放不同类型的数据，是因为都看做Object类型放入的，当需要从集合中取出数据时，只能看做Object类型处理，若希望表达该元素真实的数据类型时，就需要强制类型转换，而强制类型转换可能会引发类型转换异常；
	为了避免上诉问题，从jdk1.5开始提出泛型机制，也就是要求在每个集合名称的右边增加<数据类型>的方式规定集合中可以存放的元素，若放入其他类型数据，则编译报错；
	如：
		List<String>  a1 = new LinkedList<String>();

		泛型的本质就是参数化类型，也就是说传递的参数不再是具体的数据内容，而是一种数据类型，因此在集合的定义中，通常都会有<E>来表示形参的概念，让E进行占位，当真正创建对象时需要传递数据类型作为实参给形参E，从而该类中所有的E都变成了实参类型（原理）。

2.Queue接口（重点）
2.1 基本概念：
	java.util.Queue接口是Collection接口的子接口，与List接口是平级关系。
	该接口的主要实现类：LinkedList类，该类在增删方面有一定优势。
	Queue（队列）是一种具有先进先出特征的数据结构，简称为FIFO（first in first out）。

2.2 常用方法：
	boolean offer(E e) 	— 用于将参数指定的数据 e 插入当前的队列中，相当于入队操作（末尾）。
	E poll() 				— 用于获取并移除队列中的队首元素，若队列为空则返回null，相当于出队操作。
	E peek()	 			— 用于查看队首元素值，并返回。

练习：
	使用Queue类型的引用指向LinkedList类型的对象，将数据10 20 30 40 50 插入到队列中，获取队首元素并打印，然后将队列中的所有元素一个一个进行出队并打印。

package xdl.day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestQueue {

	public static void main(String[] args) {
		// 使用Queue类型的引用指向LinkedList类型的对象
		Queue<Integer> q = new LinkedList<Integer>();
		// 将数据10 20 30 40 50插入到队列中
		for (int i = 1; i <= 5; i++) {
			boolean b1 = q.offer(i * 10);
			System.out.println(b1 ? "队列插入成功！" : "队列插入失败！");
		}
		System.out.println("q当前值为：" + q);
		// 获取队首元素并打印
		System.out.println("当前队首" + q.peek());
		// 然后将队列中的所有元素一个一个进行出队并打印。
		for (int i = q.size(); i >= 0; i--) {
			if (q.peek() != null) {
				Integer j = (Integer) q.poll();
				System.out.println("移除的元素分别是:" + j);
			} else if (q.poll() == null) {
				System.out.println("已经移除了所有元素了！");
			}
		}

		// 使用stack类型的引用指向stack类型的对象
		Stack<Integer> s = new Stack<Integer>();
		// 将数据10 20 30 40 50 插入到栈中
		for (int i = 0; i < 5; i++) {
			Integer num = s.push(i * 10);
			System.out.println("分别插入值后的栈是：" + num);
		}
		System.out.println("当前栈是：" + s);
		// 获取栈顶部元素并打印
		Integer top = s.peek();
		System.out.println("该栈顶部的元素时：" + top);
		// 然后将栈中所有元素一个一个进行出栈并打印
		for (int i = s.size(); i >= 0; i--) {
			if (s.empty()) {
				System.out.println("当前栈中无数据！");
			} else {
				Integer n = s.pop();
				System.out.println("分别移除栈的数据是：" + n);
			}
		}

	}
}

3.set集合（重点）
3.1 基本概念：
	java.util.Set接口是Collection接口的子接口，元素没有先后次序，并且不允许重复。
	该接口的主要实现类： HashSet 类   和  TreeSet类。
	其中HashSet类的底层是采用哈希表进行数据的管理。
	其中TreeSet类的底层是采用二叉树进行数据管理的。

3.2 常用方法：
	iterator<E>  iterrator()  	— 用于获取当前集合的迭代器对象，用于访问集合中的每个元素。
			boolean  hasNext() 	— 用于判断集合中是否有可用访问的元素，有则返回true，否则返回false。
			E next() 	 	— 用于获取一个元素并指向下一个元素。
			void remove() 	— 用于删除刚刚获取到的元素。

注意：
	当使用迭代器去访问集合中的每个元素时，只能使用迭代器自己的remove（）方法去删除元素，若采用集合的remove（）方法去删除元素，则会产生并发修改异常。

3.3 增强版的for循环（for each）（推荐使用）
（1）语法格式
	for（元素类型 变量名 ： 集合/数组名称）{
		循环体；
	}
（2） 执行流程
	不断的从集合/数组中取出一个元素赋值给变量名，然后在循环体使用，直到取出所有元素为止。

总结：
	访问Set集合中的元素的方式有三种：toString()、迭代器、for each结构；
	访问List集合中的元素的方式有四种：除了支持上诉三种方式外，还增加了get()方法；

3.4 元素放入HashSet集合的过程（原理）
	（1）使用元素调用HashCode（）方法得到哈希码值；
	（2）将哈希码值交给哈希算法来生成哈希表的索引位置；
	（3）若该索引位置没有元素，则将新元素直接放入；
	（4）若该索引位置有元素，则使用新元素怕端是否与已有元素相等；
	（5）若相等，则放弃新元素的插入保留旧元素，若不相等，则将新元素放入旧元素的后面；

3.5 TreeSet类
（1）什么是二叉树？
	二叉树就是指每个节点最多只有两个子节点的树形结构。
（2）什么是有序二叉树？
	满足以下三个条件的二叉树叫做有序二叉树，又叫二叉查找树。
	a.要求左子树中任意节点的元素值都小于根节点元素；
	b.要求右子树中任意节点的元素值都大于根节点元素；
	c.左右子树的内部也遵循上述原则；


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
	}
}












