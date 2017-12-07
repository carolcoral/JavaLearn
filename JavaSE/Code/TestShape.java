package xdl.day11;

public class TestShape {
	//自定义成员方法，根据参数传入的数据来打印对应的特征
	//当需要在方法体中打印矩形的特征时
	/*public static void draw(React r){
		r.show();
	}*/
	//当需要既要能打印矩形又能打印圆形
	//形成了多态
	public static void draw(Shape s){
		//在编译阶段调用shape类自己的show（），在运行阶段调用子类重写的show（）
		s.show();
	}
			
			
	public static void main(String[] args) {
		
		//子类的引用指向子类的对象，不是多态
		React r1 = new React(1,2,3,4);
		r1.show();
		
		Cricle c1 = new Cricle(5,6,7);
		c1.show();

		TestShape.draw(r1);
	}

}
