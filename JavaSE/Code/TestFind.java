package xdl.day22;

public class TestFind {

	// 自定义成员方法来描述线性查找，要求在指定的数组中查找指定的元素并返回下标
	public static int findOut(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (data == arr[i]) {
				return i;
			} else {
				System.out.println("查找失败！没有该元素！");
			}
		}
		return -1;
	}

	// 自定义成员方法来描述二分查找算法，要求在指定的数组中查找指定的元素并返回下标
	public static int findBinary(int[] arr, int left, int right, int data) {
		// 数组中至少有一个元素时才需要查找
		if (left <= right) {
			// 1.计算中间元素的下标并记录
			int p = (left + right) / 2;
			// 2.使用目标元素与中间元素比较大小，若相等则直接返回当前下标表示查找成功
			if (data == arr[p]) {
				return p;
			}
			// 3.若目标元素小于中间元素，则去中间元素的左边查找，重复上述过程，使用递归
			else if (data < arr[p]) {
				return findBinary(arr, left, p - 1, data);
			}
			// 4.若目标元素大于中间元素，则去中间元素的右边查找，重复上述过程，使用递归
			else {
				return findBinary(arr, p + 1, right, data);
			}
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		int num = 50;
		int len = arr.length;
		int p = findBinary(arr, 0, len, num);
		System.out.println("当前元素的下标在数组中的位置是：" + p);
	}

}
