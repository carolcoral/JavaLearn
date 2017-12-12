package xdl.day20;

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
