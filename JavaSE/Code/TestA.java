package xdl.day11;

public class TestA {
	//自定义成员方法，根据参数指定的引用来调用show（）方法
	//A a = sa = new SubA();接口类型的引用指向了实现类的对象，产生了多态
	public void show(A a){
		//编译阶段调用A接口的show（）方法，在运行阶段调用实现类中的show（）方法
		a.show();
	}
	
	public static void main(String[] args) {
		TestA ta = new TestA();
		//获取A类型的引用作为实参传递过去
		//A  a = new A();接口类型是不能实例化对象的
		SubA sa = new SubA();
		ta.show(sa);
		
		//使用匿名内部类的方式解决test方法调用
		A a = new A(){
			@Override
			public void show() {
				System.out.println("0000000000");
			}
		};
		ta.show(a);
	}
}
