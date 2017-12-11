package xdl.day18;

public class TestThreadName {

	public static void main(String[] args) {
		Thread tr = new Thread() { // 父类内部类
			@Override
			public void run() {
				for (int i = 1; i < 21; i++) {
					System.out.println("我是子线程 " + i);
				}
			}
		};
		tr.start();

		System.out.println("======================================");

		Runnable r1 = new Runnable() { // 接口内部类
			@Override
			public void run() {
				for (int i = 1; i < 21; i++) {
					System.out.println("我不是主线程 " + i);
				}
			}
		};
		Thread t2 = new Thread(r1);
		t2.start();
		System.out.println("======================================");

		new Thread(new Runnable() { // 父类接口内部类
			@Override
			public void run() {
				for (int i = 1; i < 21; i++) {
					System.out.println("非主流线程 " + i);
				}
			}
		}).start();

		for (int i = 1; i < 21; i++) {
			System.out.println("我是主线程：" + i);
		}

	}

}
