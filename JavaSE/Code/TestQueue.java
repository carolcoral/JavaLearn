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
