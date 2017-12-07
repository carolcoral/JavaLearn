package xdl.day10;

import java.util.Scanner;

//根据输入的成绩判断结果并输出
public class CjSelect {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数值：");
		int cj = scanner.nextInt();
		if(cj>89&&cj<101){
			System.out.println("A");
		}else if(cj>79&&cj<90){
			System.out.println("B");
		}else if(cj>69&&cj<80){
			System.out.println("C");
		}else if(cj>59&&cj<70){ 
			System.out.println("D");
		}else if(cj>0&&cj<60){
			System.out.println("E");
		}else{
			System.out.println("成绩不合理："+cj);
		}
		scanner.close();//释放声明扫描的变量scanner
	}
}