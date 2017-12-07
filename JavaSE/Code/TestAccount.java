package xdl.day11;

public class TestAccount {

	public static void main(String[] args) {
		Account rate = new FixedAcount(2000);
		double res = rate.getRates();
		System.out.println("Rate:"+res);

	}

}
