package xdl.day11;

public  abstract class TestAbstract {

	private int cnt;
	
	
	public TestAbstract() {
		super();
	}


	public TestAbstract(int cnt) {
		super();
		setCnt(cnt);
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	//自定义抽象方法
	public abstract void show();

//	public static void main(String[] args) {
////		TestAbstract ta = new TestAbstract();
////		System.out.println("ta="+ta.getCnt());
//	}

}
