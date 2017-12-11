package xdl.day19;

public class TestThreadDaemon extends Thread {

	@Override
	public void run() {
		System.out.println(isDaemon() ? "守护线程" : "非守护线程");
		for (int i = 0; i <= 50; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TestThreadDaemon ts = new TestThreadDaemon();
		ts.setDaemon(true);
		ts.start();
		try {
			ts.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i <= 10; i++) {
			System.out.println("___________主线程" + i);
		}

	}

}
