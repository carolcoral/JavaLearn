import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class TestClassConstructor {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		// 1.使用映射的机制实现对象的创建
		// 通过读取文件获取内容
		// BufferedReader reader = new BufferedReader(new InputStreamReader(new
		// FileInputStream("a.txt")));
		// String string = reader.readLine();

		// 2.通过键盘输入获取类型
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入类型：");
		String sc = reader.readLine();
		Class<?> c = Class.forName(sc);
		// 使用 变量名.newInstance() 方法返回类型对象
		System.out.println(c.newInstance());

		// 3.使用传统方式加有参构造来创建对象
		// Person person = new Person("zhangfei",30);
		// System.out.println(person);

		// 4.使用反射机制来构造对象
		// 获取 Class 对象，调用 forName() 方法
		Class<?> c1 = Class.forName("xdl.day13.Person");
		// 获取该 Class 对象的单个构造方法，调用 getConstructor() 方法
		// 方法内的参数需要和 Person 中的变量的类型一一对应
		Constructor t = c1.getConstructor(String.class, int.class, int.class);
		// 调用获取到的构造方法来构造对象
		Object res = t.newInstance("zhangfei", 30, 20);
		// 打印对象
		System.out.println(res);
	}

}
