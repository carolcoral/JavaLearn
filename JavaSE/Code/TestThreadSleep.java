package xdl.day19;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThreadSleep extends Thread {
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			Date d = new Date();
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdt.format(d));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args){
		TestThreadSleep tSleep = new TestThreadSleep();
		tSleep.start();
		try {
			tSleep.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tSleep.flag = false;
		System.out.println("————————————over——————————");
	}

}
