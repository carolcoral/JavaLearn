package cn.xdl;

import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {

	@Test
	public void test1(){
		Jedis jedis = new Jedis("localhost",6379);
		System.out.println(jedis.ping());
		jedis.close();
	}
	
	@Test
	public void test2(){
		Jedis jedis = new Jedis("localhost",6379);
		
		Set<String> keys = jedis.keys("*");//keys *
		for(String s:keys){
			System.out.println(s);
		}
		
		jedis.close();
	}
	
	@Test
	public void test3(){
		Jedis jedis = new Jedis("localhost",6379);
		jedis.set("java", "hello redis");
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();
	}
	
	@Test
	public void test4(){
		Jedis jedis = new Jedis("localhost",6379);
		String name = jedis.hget("myhash1", "name");
		System.out.println("name:"+name);
		String no = jedis.hget("myhash1", "no");
		System.out.println("no:"+no);
		jedis.close();
	}
	
	@Test
	public void test5() throws Exception{
		Dept dept = new Dept();
		dept.setNo(10);
		dept.setName("Java¿ª·¢");
		
		Jedis jedis = new Jedis("localhost",6379);
		byte[] bytes = SerializableUtil.toSerialize(dept);
		jedis.set("dept".getBytes(), bytes);
		jedis.close();
	}
	
	@Test
	public void test6() throws Exception{
		Jedis jedis = new Jedis("localhost",6379);
		byte[] bytes = jedis.get("dept".getBytes());
		Dept dept = (Dept)SerializableUtil.toObject(bytes);
		System.out.println(dept.getNo()+" "+dept.getName());
		jedis.close();
	}
	
}
