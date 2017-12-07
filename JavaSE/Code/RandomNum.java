//随机生成1 - 100之间的随机数
//给用户十次输入机会来猜出生成的数字
//如果输入数字等于随机数就打印“恭喜你猜对了”，并结束循环；
//如果输入数字小于随机数就打印“太小了，再大一点吧”；
//如果输入数字大于随机数就打印“太大了，再小一点吧”；
//如果十次机会用完也没有猜对就打印“太笨了，下次再来吧”。
package xdl.day10;
import java.util.Random;
public class RandomNum {

	public static void main(String[] args) {
			Random rand = new Random();
			int num = rand.nextInt(100);
			System.out.println(num);
	}
}
