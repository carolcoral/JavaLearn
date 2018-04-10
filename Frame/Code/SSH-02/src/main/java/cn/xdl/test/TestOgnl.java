package cn.xdl.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.xdl.entity.Dept;
import ognl.Ognl;
import ognl.OgnlException;

public class TestOgnl {
	
	
	
	@Test
	public void test1() throws OgnlException{
//		Ognl.setValue(expression, root, value);//给root对象设置值
//		Ognl.getValue(expression, root);//从root对象中取值
		
		Object dept = new Dept();
		Ognl.setValue("dname", dept, "Java开发");
		Ognl.setValue("deptno", dept, 10);
		Ognl.setValue("loc", dept, "北京");
		
		System.out.println(dept);
	}
	
	@Test
	public void test2() throws OgnlException{	
		Dept dept = new Dept();
		dept.setDeptno(20);
		dept.setDname("PHP");
		dept.setLoc("上海");
		//取值
		Object deptno = Ognl.getValue("deptno", dept);
		System.out.println(deptno);
		Object dname = Ognl.getValue("dname", dept);
		System.out.println(dname);
		Object loc = Ognl.getValue("loc", dept);
		System.out.println(loc);
	}
	
	@Test
	public void test3() throws OgnlException{	
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("dname", "张三");
		context.put("age", 20);
		
		Dept dept = new Dept();
		dept.setDname("JAVA");
		
		//取值
		Object name = Ognl.getValue("dname", context, dept);
		System.out.println(name);
	}
	
}
