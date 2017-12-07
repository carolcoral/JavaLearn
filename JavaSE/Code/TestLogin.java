package xdl.day13;

import java.util.Scanner;

public class TestLogin {

	public static void main(String[] args) {
		//模拟用户登录的过程，提示用户输入用户名和密码，若用户输入的用户名和密码为“admin”和“123456”，则提示成功，否则提示“用户名或密码错误”，直到3次输入都失败，则提示“账号已冻结，请联系客服人员！”
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		int i =0;
		for(i = 1;i<=3;i++){
			System.out.println("请输入用户名：");
			String name = scanner.next();
			System.out.println("请输入密码：");
			String passwd = scanner.next();
			if("admin".equalsIgnoreCase(name) && "123456".equals(passwd)){
				System.out.println("验证通过");
				flag = false;
				break;
			}else{
				System.out.println("用户名或密码错误!您还有"+(3-i)+"次机会！");
				continue;
			}
		}
		if(flag){
			System.out.println("账号已冻结，请联系客服人员！");
		}
		scanner.close();
	}
}
