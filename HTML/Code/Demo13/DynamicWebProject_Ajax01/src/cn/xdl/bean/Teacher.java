package cn.xdl.bean;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class Teacher {//---teacher
	private String name;
	private int age;
	private String desc;
	
	public Teacher() {
		super();
	}
	public Teacher(String name, int age, String desc) {
		super();
		this.name = name;
		this.age = age;
		this.desc = desc;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", desc=" + desc + "]";
	}
	
	public static void main(String[] args) {
		//一、一个json对象
		//1.从数据库获取一条数据，封装成java对象
//		Teacher t = new Teacher("橘梨纱老师",26,"偶像团体AKB48的前成员，下海经商");
//		//2.把java对象转换成json对象
//		JSONObject jsonObject = JSONObject.fromObject(t);
//		//3.获取json字符串
//		String jsonObjectStr = jsonObject.toString();
//		System.out.println(jsonObjectStr);
		
		//二、多个多个json对象
		Teacher t = new Teacher("橘梨纱老师",26,"偶像团体AKB48的前成员，下海经商");
		Teacher t2 = new Teacher("Julia",36,"善解人意的好老师");
	
		List<Teacher> ts = new ArrayList<>();
		ts.add(t);
		ts.add(t2);
		
		JSONArray array = JSONArray.fromObject(ts);
		String jsonStr = array.toString();
		
		
	}
	
}







