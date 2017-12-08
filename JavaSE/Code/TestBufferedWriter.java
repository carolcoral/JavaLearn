package xdl.day17;

import java.io.*;

public class TestBufferedWriter {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("AgeException.txt")));
			for (int i = 0; i <= 10; i++) {
				bw.write("hello world" + "\n");
			}
			for (int i = 0; i <= 10; i++) {
				bw.write("hello" + "\n");
			}
			for (int i = 0; i <= 10; i++) {
				bw.write("world" + "\n");
			}
			System.out.println("ok");
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			BufferedReader re = new BufferedReader(new InputStreamReader(new FileInputStream("AgeException.txt")));
			// 读取目标文件中所有的内容
			// int res = 0;
			// char[] arr = new char[1024*8];
			// while ((res = re.read()) != -1) {
			// // System.out.println(re.read(arr, 0, res));
			// System.out.print((char) res);
			// }
			// 读取目标文件中一行的内容
			String str = re.readLine();
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
