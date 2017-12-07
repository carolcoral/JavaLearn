package xdl.day10;

public class Pet {
	private String name;
	public Pet() {
		super();
	}
	public Pet(String name){
		setName(name);
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void show(){
		System.out.println("动物类型是："+getName());
	}
	public static void test(){
		System.out.println("Pet类中的方法");
	}
}
