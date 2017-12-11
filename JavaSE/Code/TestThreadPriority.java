package xdl.day19;

public class TestThreadPriority extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
			System.out.println("子线程的打印：" + i);
		}
		System.out.println("当前线程优先级：" + getPriority());
	}

	public static void main(String[] args) {
		TestThreadPriority ts = new TestThreadPriority();
		ts.setPriority(MIN_PRIORITY);
		ts.start();
		Thread.currentThread().setPriority(MAX_PRIORITY);
		for (int i = 0; i <= 20; i++) {
			System.out.println("----------主线程" + i);
		}
		System.out.println("主线程的优先级：" + Thread.currentThread().getPriority());
	}

}
