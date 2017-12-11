package xdl.day19;

public class TestAccount {

	public static void main(String[] args) throws InterruptedException {
		Account account = new Account(3000);
		Thread t1 = new Thread(account);
		t1.start();
		t1.join();
		Thread t2 = new Thread(account);
		t2.start();
		t2.join();
		System.out.println("余额是:" + account.getMoney());
	}

}
