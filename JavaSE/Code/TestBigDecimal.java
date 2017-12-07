package xdl.day12;

import java.math.BigDecimal;

public class TestBigDecimal {

	public static void main(String[] args) {
		BigDecimal bd1 = new BigDecimal("5.3");
		BigDecimal bd2 = new BigDecimal("1.3");
		
		//2.计算b1和b2的和差积商
		BigDecimal res = bd1.add(bd2);
		System.out.println("计算和res="+res);  //自动调用toString方法
		res = bd1.subtract(bd2);
		System.out.println("计算差res="+res);  //自动调用toString方法
		res = bd1.multiply(bd2);
		System.out.println("计算积res="+res);  //自动调用toString方法
		res = bd1.divide(bd2,BigDecimal.ROUND_FLOOR);//BigDecimal.ROUND_FLOOR接近负无穷大的舍入模式
		System.out.println("计算商res="+res);  //自动调用toString方法
		
		//3.对比double类型的运算精度
		System.out.println(0.1+0.2);
		BigDecimal bd3 = new BigDecimal("5.3");
		BigDecimal bd4 = new BigDecimal("1.3");
		System.out.println(bd3.add(bd4));
		//4.商除不尽的情况处理
		BigDecimal bd5 = new BigDecimal("5");
		BigDecimal bd6 = new BigDecimal("3");
		BigDecimal res2 = bd5.divide(bd6,BigDecimal.ROUND_HALF_UP);
		System.out.println(res2);//使用BigDecimal后面加上ROUND_HALF_UP进行四舍五入
	}

}
