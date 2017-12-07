package xdl.day11;

public class React extends Shape {
	private int len;
	private int wid;
	public React() {
		super();
		// TODO Auto-generated constructor stub
	}
	public React(int x, int y,int len,int wid) {
		super(x, y);
		setLen(len);
		setWid(wid);
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	@Override
	public void show(){
		super.show();
		System.out.println("长："+getLen()+"，宽："+getWid());
	}
}
