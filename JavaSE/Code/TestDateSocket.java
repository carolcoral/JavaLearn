package xdl.day20;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestDateSocket {

	public static void main(String[] args) {
		// 1.创建 ServerSocket 类型的对象，并提供端口号
		ServerSocket ss;
		try {
			ss = new ServerSocket(1898);
			// 2.等待客户端的连接请求，使用 accept() 方法
			System.out.println("等待客户端的请求......");
			Socket s = ss.accept();
			System.out.println("成功连接客户端！");
			// 3.使用输入输出流进行通信
			DataInputStream dd = new DataInputStream(s.getInputStream());
			int res = dd.readInt();
			System.out.println(res);
			// 4.关闭 Socket 并释放有关资源
			s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
