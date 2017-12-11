package xdl.day19;

public class Account implements Runnable {
	private int money;
	Test t = new Test();

	public Account() {
		super();
	}

	public Account(int money) {
		super();
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) throws Exception {
		if (money >= 0) {
			this.money = money;
		} else {
			throw AccountException("不对");
		}
	}

	private Exception AccountException(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		synchronized (this) {
			int temp = getMoney();
			if (temp >= 200) {
				System.out.println("正在制作假钞中....");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				temp -= 200;
				System.out.println("请取走你的钞票！");
			} else {
				System.out.println("余额不足");
			}
			try {
				setMoney(temp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Test{};
