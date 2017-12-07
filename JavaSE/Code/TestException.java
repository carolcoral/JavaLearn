package xdl.day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestException {

	public static void main(String[] args) {
		// 处理异常的方式和流程
		FileInputStream fl = null;
		try {
			fl = new FileInputStream("file.rtf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fl.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		int i=10;
		int j=0;
		try{
			System.out.println("res = "+(i/j));
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("xxoo");
		}
			
	}

}
