package xdl.day12;

import java.math.BigInteger;

public class TestBigInteger {

	public static void main(String[] args) {
		
		//1.声明两个BigInteger类型的引用对象
		BigInteger bi1 = new BigInteger("100");
		BigInteger bi2 = new BigInteger("13");
		
		//2.实现加减乘除运算
		BigInteger res = bi1.add(bi2);
		System.out.println("计算结果的和是："+res);
		res = bi1.subtract(bi2);
		System.out.println("计算结果的差是："+res);
		res = bi1.multiply(bi2);
		System.out.println("计算结果的积是："+res);
		res = bi1.divide(bi2);
		System.out.println("计算结果的商是："+res);
		
		
		//3.测试同时取出商和余数
		BigInteger bi3 = new BigInteger("70");
		BigInteger bi4 = new BigInteger("13");
		BigInteger[] arr = bi3.divideAndRemainder(bi4);
		for(int i = 0;i<arr.length;i++){
			System.out.println("商是arr[0]="+arr[0]+"余是arr[1]="+arr[1]);
		}
	}

}
