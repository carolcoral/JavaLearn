package xdl.day20;

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
