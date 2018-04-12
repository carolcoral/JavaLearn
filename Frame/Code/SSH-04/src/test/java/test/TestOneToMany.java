package test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.xdl.entity.Dept;
import cn.xdl.entity.Emp;
import cn.xdl.util.HibernateUtil;

public class TestOneToMany {
	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Dept dept = session.get(Dept.class, 22);
		System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
//		Set<Emp> emps = dept.getEmps();
//		for(Emp emp:emps){
//			System.out.println(emp.getId()+" "+emp.getEname());
//		}
		session.close();
	}
	
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		//join fetch
		Query<Dept> query = session.createQuery(
			"from Dept d join fetch d.emps where d.no=?");
		query.setParameter(0, 20);
		Dept dept = query.uniqueResult();
		System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		Set<Emp> emps = dept.getEmps();
		for(Emp emp:emps){
			System.out.println(emp.getId()+" "+emp.getEname());
		}
		session.close();
	}
	
}
