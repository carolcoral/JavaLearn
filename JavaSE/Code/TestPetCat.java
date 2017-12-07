package xdl.day10;

public class TestPetCat {
	public static void main(String[] args) {
		//父类的引用指向父类的对象
		Pet pt = new Pet("cat");
		//引用父类的show方法
		pt.show();
		System.out.println("--------------------------------");
		//子类的引用
		Cat ct = new Cat("dog",11);
		ct.show();
		System.out.println("--------------------------------");
		//父类的引用指向子类的对象，形成了多态
		Pet pc = new Cat("mm",12); 
		//从运行的结果看，调用的是子类中的show（）方法，打印了名字和牙齿数量
		//从编译的过程看，调用的是父类中的show（）方法，没有则编译报错
		pc.show();
		
		System.out.println("--------------------------------");
		
		Pet.test();
		
//		int res = (Cat(pt)).getNum();
	}

}

