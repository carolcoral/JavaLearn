package xdl.day19.student;

import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
	//定义一个集合来存储学生信息
	private List<Student> list;
	
	public ManagerStudent(List<Student> list){
		super();
		this.list = list;
	}
	
	//增加学生信息到集合中
	public void addStudent() throws Exception{
		System.out.println("请输入要增加的学生信息(学号,姓名,年龄)：");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		//按照逗号进行字符串拆分，构造Student对象放入集合中
		String[] ss = str.split(",");
		Student s = new Student(Integer.parseInt(ss[0]), ss[1], Integer.parseInt(ss[2]));
		
		//判断输入的学生信息是否存在，如果存在则放弃加入
		for(Student ts : list){
			if(ts.equals(s)){
				System.out.println("该学生已经存在，增加失败");
				return;
			}
		}
		list.add(s);
		System.out.println("增加学生信息成功");
	}
	
	//从集合中删除学生信息
	public void delStudent(){
		//查找该学生信息是否存在，如果不存在则删除失败
		Student fs = findStudent();
		if(null == fs){
			System.out.println("该学生信息不存在，删除失败");
			return;
		}
		//如果存在则删除成功
		list.remove(fs);
		
	}
	
	//修改学生信息从集合中
	public void modifyStudent() throws Exception{
		//把原来的学生信息从集合中删除掉
		delStudent();
		//增加新的学生信息到集合中
		addStudent();
		
	}
	
	//查找学生信息从集合中
	public Student findStudent(){
		System.out.println("请输入该学生的学号：");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		//使用增强版for循环去查找学生信息
		for(Student s : list){
			if(id == s.getId()){
				System.out.println(s);
				return s;
			}
		}
		//作为查找失败的处理方式
		System.out.println("该学生不存在，查找失败");
		return null;
	}
	
	//显示所有学生信息
	public void printStudent(){
		System.out.println("---------------------------------------------");
		for(Student s : list){
			System.out.println(s);
		}
		System.out.println("---------------------------------------------");
	}
}
