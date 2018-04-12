package cn.xdl.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.xdl.entity.Dept;

public class HibernateUtil {
	
	static SessionFactory factory;
	
	static{
		//Configuration
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		//SessionFactory
		factory = conf.buildSessionFactory();
	}
	
	public static Session getSession(){
		//Session
		Session session = factory.openSession();
		return session;
	}
	
	public static void main(String[] args){
		Session session = HibernateUtil.getSession();
		Dept dept = session.get(Dept.class, 1);//∞¥id=1≤È—ØDEPT
		System.out.println(dept.getName()+" "+dept.getLoc());
	}
	
}
