package xdl.day10;

public class Cat extends Pet {
	public Cat() {
		super();
	}

	private int num;

	public Cat(String name ,int num) {
		super(name);//必须加上name，才能继承父类的属性
		setNum(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public  void show(){
		super.show();
		System.out.println("牙齿数量是："+getNum());
	}
	public static void test(){
		System.out.println("Cat类中的方法");
	}
}
