package test;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import cn.xdl.MyBootApplication;
import cn.xdl.entity.Dept;

public class TestRedis {
	
	@Test
	public void test1(){
		ApplicationContext ac = 
			SpringApplication.run(MyBootApplication.class);
		RedisTemplate template = 
			ac.getBean("redisTemplate",RedisTemplate.class);
		System.out.println(template);
		template.opsForValue().set("boot", "SpringBoot");
		String boot = (String)template.opsForValue().get("boot");
		System.out.println("----"+boot);
	}
	
	@Test
	public void test2(){
		ApplicationContext ac = 
			SpringApplication.run(MyBootApplication.class);
		RedisTemplate template = 
			ac.getBean("redisTemplate",RedisTemplate.class);
		
		Dept dept = new Dept();
		dept.setDeptno(1);
		dept.setDname("SpringBoot");
		
		template.opsForValue().set("spring", dept);
		
	}
	
	@Test
	public void test3(){
		ApplicationContext ac = 
			SpringApplication.run(MyBootApplication.class);
		RedisTemplate template = 
			ac.getBean("redisTemplate",RedisTemplate.class);
		Dept dept = (Dept)template.opsForValue().get("spring");
		System.out.println(dept.getDeptno()+" "+dept.getDname());
	}
	
}
