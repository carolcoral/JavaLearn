package xdl.day20;

import java.io.DataOutputStream;
import java.net.Socket;

public class TestDataClient {

	public static void main(String[] args) {
		// 1.创建 Socket 类型的对象并提供服务器的 IP 地址和端口号
		try {
			Socket s = new Socket("192.168.2.1", 1898);
			// 2.使用输入输出流进行通信
			// Thread.sleep(10000);
			// 3.让客户端想服务器发送整数数据66，处理基本数据类型使用 data 开头的流
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(66);
			System.out.println("成功发送数据到服务器!");
			// 4.关闭 Socket 并释放有关资源
			s.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
