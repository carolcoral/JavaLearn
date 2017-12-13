package xdl.day19.student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DaoStudent {
	//定义一个集合类型的引用，通过构造方法将整个集合传入
	private List<Student> list;
	
	public DaoStudent(List<Student> list){
		this.list = list;
	}
	
	//自定义方法实现将整个集合写入到文件中
	public void write() throws IOException{
		//1.创建/清空文件
		FileOutputStream fos = new FileOutputStream("./student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//2.将整个集合的学生信息都写入到文件中
		oos.writeObject(list);
		System.out.println("写入数据到文件成功！");
		//3.关闭相关的流和文件
		oos.flush();
		oos.close();
		fos.close();
	}
	
	//自定义方法实现读取文件中的所有学生信息
	@SuppressWarnings("unchecked")
	public List<Student> read() throws IOException, ClassNotFoundException{
		//1.打开文件
		FileInputStream fis = new FileInputStream("./student.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		//2.将文件中的所有学生信息都读取出来
		list = (List<Student>) ois.readObject();
		for(Student s : list){
			System.out.println(s);
		}
		System.out.println("读取文件中的数据成功！");
		//3.关闭相关的流和文件
		ois.close();
		return list;
	}
}
