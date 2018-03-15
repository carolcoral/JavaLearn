package com.xdl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.XdlDept;
import com.xdl.mapper.dao.XdlDeptMapper;

public class XdlDeptMapperTest {

	public static void main(String[] args) {
		ApplicationContext  app = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		XdlDeptMapper   deptMapper = app.getBean("xdlDeptMapper",
			XdlDeptMapper.class);
        System.out.println(deptMapper.findDeptById(2));
        System.out.println("-------------");
        System.out.println(deptMapper.listAll());
        System.out.println("===========");
       /*  XdlDept dept = new XdlDept();
        dept.setId(13);
        dept.setName("1gg");
        dept.setLoc_addr("11loc_addr"); 
        int rows = deptMapper.addDept(dept);
        System.out.println("rows="+rows); */
	}

}
