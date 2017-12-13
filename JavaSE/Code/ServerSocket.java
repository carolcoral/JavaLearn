//1.服务器端

import java.net.ServerSocket;
import java.net.Socket;

public class TestStringServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			// 1.创建 ServerSocket 类型的对象，并提供端口号
			ServerSocket ss = new ServerSocket(8888);
			// 等待客户端的连接请求，使用 accept 方法
			while (true) {
				System.out.println("等待客户端连接...");
				Socket s = ss.accept();
				System.out.println("客户端" + s.getInetAddress() + "连接成功!");
				new ServerThread(s).start();
			}
			// ss.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

//2.线程接口内容

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread {

	private Socket s;

	public ServerThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream ps = new PrintStream(s.getOutputStream());

			while (true) {
				
				String str = br.readLine();
				
				if ("bye".equalsIgnoreCase(str)) {
					System.out.println("客户端" + s.getInetAddress() + "结束连接！");
					break;
				}
				Date d1 = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(sdf.format(d1) + " 客户端" + s.getInetAddress() + "说：" + str);
				//  连接成功发送"I Received!"
				ps.println("I Received!");
				System.out.println("成功发送数据！");
			}

			// 4.关闭 Socket
			ps.close();
			br.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//3.客户端内容

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
