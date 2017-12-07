package xdl.day10;
//用户输入一个随机正整数，系统输出该数的逆序
import java.util.Scanner;

public class BackRes {
	public static String reverse(int a){  
        if (a<0) return "";  
        if(a<10) return Integer.toString(a);  
        int last = a - (a/10)*10;//取得这个整数的最后一位  
        return Integer.toString(last)+reverse(a/10);//递归输出最后一位和前面的倒序数字  
    }  
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个正整数：");
		int num = scanner.nextInt();
		if(num<0){
			System.out.println("输入数据非法，请重新输入!");		 
		}else{
			System.out.println(reverse(num));
		}
		scanner.close();//释放声明扫描的变量scanner
	}
}
