package xdl.day11;

public  abstract class Account {
	private int count;
	public Account(int count) {
		super();
		setCount(count);
	}

	public Account() {
		super();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if(count>=0){
			this.count = count;
		}
	}
	public abstract double getRates();
}
