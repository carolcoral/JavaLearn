import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSortArith {

	// 自定义成员方法实现冒泡排序算法，将参数指定数组中的所有元素从小到大排序
	public static void bubble(int[] brr) {
		// 1.使用外层循环来控制比较的轮数
		for (int i = 1; i < brr.length; i++) {
			// 使用标志位表示数组时候发生了交换
			boolean flag = true;
			// 2.使用内层循环来控制比较的元素下标范围，也就是比较的次数
			for (int j = 0; j < brr.length - i; j++) {
				// 3.若左边的元素大于右边的元素则交换两个元素的位置
				if (brr[j] > brr[j + 1]) {
					int temp = brr[j];
					brr[j] = brr[j + 1];
					brr[j + 1] = temp;
					flag = false;

					// 不使用第三者变量实现两个元素的交换
					int a = 2;
					int b = 3;
					a = a + b; // a=5
					b = a - b; // b=2
					a = a - b; // a=3

					// 使用抑或运算符
					a = a ^ b;
					b = a ^ b;
					a = a ^ b;

				}
			}
			// 根据 flag 判断整个循环时候发生交换
			if (flag) {
				System.out.println(brr);
			}

		}
	}

	// 插入排序算法
	public static void insertSort(int[] irr) {
		int j;
		for (int i = 1; i < irr.length; i++) {
			int temp = irr[i];
			for (j = i - 1; j >= 0 && irr[j] > temp; j--) {
				irr[j + 1] = irr[j];
			}
			irr[j + 1] = temp;
		}
	}

	// 选择排序算法
	public static void selectSort(int[] srr) {
		int min = 0;
		for (int i = 0; i < srr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < srr.length; j++) {
				if (srr[min] > srr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = srr[i];
				srr[i] = srr[min];
				srr[min] = temp;
			}
		}
	}

	// 快速排序算法
	public static void fastSort(int[] frr, int left, int right) {
		int p = (left + right) / 2;
		int pivot = frr[p];
		// 2.分别使用左右两边的元素依次与基准值比较大小，将所有比基准值小的元素放在左边，将所有比基准值大的或者相等的元素放在右边
		int i = left;
		int j = right;
		for (; i < j;) {
			// 先使用左边的元素与基准值比较，若左边的元素小于基准值并且确实在左边，则使用下一个左边的元素继续与基准值大或者相等的元素放在右边
			while (frr[i] < pivot && i < p) {
				i++;
			}
			// 直到左边有元素并且左边元素不在小于基准值，此时将左边元素移动到 p 指向的位置，p 指向该元素原来的位置
			if (i < p) {
				frr[p] = frr[i];
				p = i;
			}
			// 再使用右边的元素与基准值比较，若右边的元素大于基准值并且确实在右边，则使用下一个右边的元素继续与基准值大或者相等的元素放在左边
			while (frr[j] >= pivot && j > p) {
				j--;
			}
			// 直到右边有元素并且右边元素不在大于基准值，此时将右边元素移动到 p 指向的位置，p 指向该元素原来的位置
			if (j > p) {
				frr[p] = frr[j]; 
				p = j;
			}
		}
		// 当左边元素的下标等于右边元素的下标时，把取出来的中间值重新赋值回去
		frr[p] = pivot;
		if ((p - i) > 1) {
			fastSort(frr, left, p - 1);
		}
		if ((j - p) > 1) {
			fastSort(frr, p + 1, right);
		}

	}

	public static void main(String[] args) {
		int[] brr = { 20, 10, 15, 5, 25, 30, 1, 8, 11, 26, 20, 3, 1 };
		int len = brr.length - 1;
		// System.out.println(len);
		Date time = new Date();
		SimpleDateFormat stFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("开始运行时间：" + stFormat.format(time));

		// 冒泡排序算法
		// TestSortArith.bubble(brr);
		// 插入排序算法
		// TestSortArith.insertSort(brr);
		// 选择排序算法
		// TestSortArith.selectSort(brr);
		TestSortArith.fastSort(brr, 0, len);
		System.out.print("排序后的数组是：");
		for (int i = 0; i < brr.length; i++) {
			System.out.print(brr[i] + " ");
		}

		Date time3 = new Date();
		long time2 = time.getTime();
		long time4 = time3.getTime();
		long res = time4 - time2;
		System.out.println("\n 一共运行的时间是：" + res + "毫秒");
	}

}
