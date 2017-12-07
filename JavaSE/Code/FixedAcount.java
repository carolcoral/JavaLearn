package xdl.day11;

public class FixedAcount extends Account {

	public FixedAcount() {
		super();
	}

	public FixedAcount(int count) {
		super(count);
	}

	@Override
	public double getRates() {
		return getCount()*0.3;
		
	}

}
