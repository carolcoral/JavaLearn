package xdl.day13;

public class Person {
	// 1.自定义Person类实现封装，属性有：姓名和年龄，要求采用姓名作为标准来重写equals()方法、hashCode()方法以及toString()方法。
	private String name;
	private int age;
	private int id;

	public Person() {
		super();
	}

	public Person(String name, int age, int id) {
		super();
		setName(name);
		setAge(age);
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 1)
			this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (this == obj)
			return true;
		else if (obj instanceof Person) {
			Person p = (Person) obj;
			// 判断地址是否相同
			// return p.getName() == this.getName();
			// 判断内容是否相同
			return this.getName().equals(p.getName());
		} else
			return false;
	}

	@Override
	public int hashCode() {
		int type = 12;
		return type*31 +getName().hashCode();
	}

	@Override
	public String toString() {
		return "学号是：" + getId() + "，姓名是：" + getName() + "，年龄是：" + getAge();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
