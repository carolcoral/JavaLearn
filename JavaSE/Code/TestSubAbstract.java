package xdl.day11;

public class TestSubAbstract extends TestAbstract {
	
	public static  void mian(String[] args){
		TestSubAbstract tsa = new TestSubAbstract();
		//调用子类重写以后的show（）方法
		tsa.show();
	}

	@Override
	public void show() {
		System.out.println("xxxxxxxxxxxxxxx");
		
	}
}