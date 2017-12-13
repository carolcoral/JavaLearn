package xdl.day19.student;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class TestStudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//创建一个集合用于存储所有学生信息
			List<Student> list = new LinkedList<Student>();
			
			//创建DaoStudent类型的对象，负责将文件中的所有数据读取到集合中
			DaoStudent ds = new DaoStudent(list);
			try{	
				list = ds.read();
			}catch(FileNotFoundException e){
				//e.printStackTrace();
			}
			
			ManagerStudent ms = new ManagerStudent(list);
			ViewStudent vs = new ViewStudent(ms);
			vs.show();
			
			ds.write();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
