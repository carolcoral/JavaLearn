package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.xdl.entity.Emp;
import cn.xdl.util.HibernateUtil;

public class TestEmp {
	
	@Test
	public void test1(){
		Emp emp = new Emp();
		emp.setEname("jack");
		emp.setAge(22);
		emp.setSex("ÄÐ");
		emp.setBirthday(Date.valueOf("2000-05-08"));
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Query<Emp> query = session.createQuery("from Emp");
		List<Emp> list = query.getResultList();
		for(Emp emp:list){
			System.out.println(emp.getId()+" "+emp.getEname()+" "+emp.getBirthday());
		}
		session.close();
	}
	
}
