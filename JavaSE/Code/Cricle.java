package xdl.day11;

public class Cricle extends Shape {
	private int ir;

	public Cricle() {
		super();
	}

	public Cricle(int x, int y,int ir) {
		super(x, y);
		setIr(ir);
	}

	public int getIr() {
		return ir;
	}

	public void setIr(int ir) {
		this.ir = ir;
	}
	@Override
	public void show(){
		super.show();
		System.out.println("半径："+getIr());
	}
}
