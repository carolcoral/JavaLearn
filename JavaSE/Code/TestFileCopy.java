package xdl.day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFileCopy {

	public static void main(String[] args) throws IOException {
		try {

			Date t1 = new Date();
			SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			System.out.println("复制开始时间是：" + t.format(t1));

			// 1.创建 FileInputStream 类型的对象与 a.txt 文件关联，读取文件中的内容
			FileInputStream fl = new FileInputStream("AgeExcepiton.txt");
			// 2.创建 FileInputStream 类型的对象与 b.txt 文件关联，写入数据到文件中
			FileOutputStream f2 = new FileOutputStream("AgeExcepiton2.txt");
			// 3.不断地读取源文件中的内容并写入到目标文件中
			System.out.println("不断的加载中.....");

			// 1.该方式可以实现文件的拷贝，当文件比较大时效率太低了
			// int res = 0;
			// while((res = fl.read())!=-1){
			// f2.write(res);
			// }

			// 2.一次性申请文件大小的数组讲数据一次性全部读取出纳，再全部写入进去
			// 当文件太大时无法申请对应大小的内存空间，内存不足
			// int len = fl.available();
			// System.out.println("获取的文件大小是：" + len);
			// byte[] arr = new byte[len];
			// int res = fl.read(arr);
			// System.out.println("实际获取的字节大小是：" + res);
			// f2.write(arr);

			// 3.申请一个比较合适的大小数组作为缓存区，以该数组作为基本单位进行读写

			byte[] arr = new byte[1024 * 8];
			int res = 0;
			while ((res = fl.read(arr)) != -1) {
				f2.write(arr, 0, res);// 从0开始读写到 res 返回的字节个数停止
			}

			System.out.println("成功写入数据！");

			Date t2 = new Date();
			long t3 = t2.getTime() - t1.getTime();
			SimpleDateFormat t4 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			System.out.println("复制结束时间是：" + t4.format(t2) + "，共用时" + t3 + "毫秒！");

			// 关闭源文件和目标文件
			fl.close();
			f2.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
