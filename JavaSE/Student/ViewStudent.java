package xdl.day19.student;

import java.util.Scanner;

public class ViewStudent {
	
	private ManagerStudent ms;
	
	public ViewStudent(ManagerStudent ms){
		this.ms = ms;
	}
	
	//实现打印主界面的方法
	public void show() throws Exception{
		
		while(true){
			System.out.println("\n\n\t       学生信息管理系统");
			System.out.println("-------------------------------------------");
			System.out.print("   [1] 增加学生信息");
			System.out.println("         [2] 删除学生信息");
			System.out.print("   [3] 修改学生信息");
			System.out.println("         [4] 查找学生信息");
			System.out.print("   [5] 显示学生信息");
			System.out.println("         [0] 退出学生系统");
			System.out.println("-------------------------------------------");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("请选择具体的业务编号:");
			int choose = sc.nextInt();
			
			switch(choose){
				case 1: ms.addStudent(); break;
				case 2: ms.delStudent(); break;
				case 3: ms.modifyStudent(); break;
				case 4: ms.findStudent(); break;
				case 5: ms.printStudent(); break;
				case 0: return;
				default:System.out.println("输入错误，请重新输入");
			}
		}
	}
}
