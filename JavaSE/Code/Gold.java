package xdl.day11;

public class Gold implements Money, Metal {

	@Override
	public void shine() {
		System.out.println("10000000");

	}

	@Override
	public void buy() {
		System.out.println("333333333");

	}

	public static void main(String[] args) {
		//接口类型的引用指向了实现类的对象，一样实现了多态
		Metal mt = new Gold();
		mt.shine();
		Money my = new Gold();
		my.buy();

	}

}
