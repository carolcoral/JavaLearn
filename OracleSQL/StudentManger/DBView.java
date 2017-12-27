package day07;

import java.util.Scanner;

public class DBView {

	public void menu() {
		System.out.println("----------------------------------------------");
		System.out.println("|      菜单（输入下列功能对应的数字选择功能）      |");
		System.out.println("|            1.    增加用户                   |");
		System.out.println("|            2.    修改用户                   |");
		System.out.println("|            3.    删除用户                   |");
		System.out.println("|            4.    查找用户                   |");
		System.out.println("|            5.    退   出                    |");
		System.out.println("————————————————————————————————————————————-—");

	}

	public void show() {
		DBModel db = new DBModel();
		menu();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入选项：");
		int res = sc.nextInt();
		try {
			// while (true) {
			switch (res) {
			case 1:
				db.InsertAction();
				break;
			case 2:
				db.UpdateAction();
				break;
			case 3:
				db.DeleteAction();
				break;
			case 4:
				db.SelectAction();
				break;
			case 5:
				break;
			default:
				System.out.println("选项错误，没有该选项！");
			}
			// }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sc.close();
	}

	public static void main(String[] args) {
		DBView td = new DBView();

		td.show();
	}

}
