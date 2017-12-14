public class singerton {// 单例模式的两种使用方式
	// 饿汉式
	// 2.提供本类类型的引用作为本类的成员变量
	private static singerton sin = new singerton();

	// 1.私有化构造方法，使用private关键字修饰
	// static关键字不能修饰构造方法，因此构造方法用于给每个对象初始化独立的成员变量
	private singerton() {
	}

	// 3.提供公有的get方法/静态的方法负责将私有的成员变量返回出去
	public static singerton getInstance() {
		return sin;
	}

	// // 懒汉式
	// private static singerton sin = null;
	// private singerton() {}
	// public static singerton getInstance() {
	// if(sin == null) {
	// sin = new singerton();
	// }
	// return sin;
	// }
	
}
