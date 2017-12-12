package xdl.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TestStringClient {

	public static void main(String[] args) {
		try {
			// 1.创建 Socket
			Socket s = new Socket("192.168.2.1", 8888);
			// 2.创建输入信息
			BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
			PrintStream ps = new PrintStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			while (true) {

				System.out.println("请输入您的信息：");
				String msg = bri.readLine();
				// ps.println("hello");
				ps.println(msg);
				System.out.println("");

				if ("bye".equalsIgnoreCase(msg)) {
					System.out.println("结束对话！");
					break;
				}
				System.out.println("等待对方输入.....");
				String str = br.readLine();
				System.out.println("对方输入的信息：" + str);
			}

			// 3.关闭 Socket
			br.close();
			ps.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
