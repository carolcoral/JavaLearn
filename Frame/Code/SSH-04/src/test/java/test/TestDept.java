package test;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.xdl.entity.Dept;
import cn.xdl.util.HibernateUtil;

public class TestDept {
	
	@Test
	public void test1(){
		Dept dept = new Dept();
		dept.setName("xdl");
		dept.setLoc("北京");
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(dept);
		System.out.println(dept.getNo());
		tx.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		//部分更新，先查询，再修改
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Dept dept = session.get(Dept.class, 21);
		dept.setName("研发部");
		session.update(dept);//属于全部更新，根据id做条件更新其他字段值
		tx.commit();
		session.close();
	}
	
	@Test
	public void test3(){
		Dept dept = new Dept();
		dept.setNo(21);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(dept);//根据id做条件删除
		tx.commit();
		session.close();
	}
	
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Dept dept = session.get(Dept.class, 21);
		if(dept != null){
			System.out.println(dept.getName()+" "+dept.getLoc());
		}else{
			System.out.println("未找到记录");
		}
		session.close();
	}
	
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		String hql = "from Dept";
		Query<Dept> query = session.createQuery(hql);
		List<Dept> list = query.list();//执行HQL
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test6(){
		Session session = HibernateUtil.getSession();
		String hql = "from Dept where name like ?";
		Query<Dept> query = session.createQuery(hql);
		query.setParameter(0, "java%");//给第一个?设置参数值
		List<Dept> list = query.list();//执行HQL
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		String hql = "from Dept";
		Query<Dept> query = session.createQuery(hql);
		//设置分页参数
		query.setFirstResult(5);//抓取记录起点
		query.setMaxResults(5);//最大抓取数量
		List<Dept> list = query.list();//执行HQL
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test8(){
		Session session = HibernateUtil.getSession();
		String hql = "select count(*) from Dept";
		Query<Long> query = session.createQuery(hql);
		Long size = query.uniqueResult();
		System.out.println("记录总数:"+size);
		session.close();
	}
	
	@Test
	public void test9(){
		Session session = HibernateUtil.getSession();
		String hql = "update Dept set name=? where no=?";
		Query<Long> query = session.createQuery(hql);
		Transaction tx = session.beginTransaction();
		query.setParameter(0, "JAVA");
		query.setParameter(1, 23);
		query.executeUpdate();//执行update、delete语句
		tx.commit();
		session.close();
	}
	
	@Test
	public void test10(){
		Session session = HibernateUtil.getSession();
		Criteria ct = session.createCriteria(Dept.class);//from Dept
		List<Dept> list = ct.list();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test11(){
		Session session = HibernateUtil.getSession();
		Criteria ct = session.createCriteria(Dept.class);//from Dept
		ct.add(Restrictions.like("name", "%java%"));//where name like ?
		ct.addOrder(Order.desc("no"));//order by no desc
		List<Dept> list = ct.list();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test12(){
		Session session = HibernateUtil.getSession();
		Criteria ct = session.createCriteria(Dept.class);//from Dept
		Criterion where = Restrictions.or(
			Restrictions.eq("loc", "北京"),
			Restrictions.eq("loc", "beijing"));
		ct.add(where);
		List<Dept> list = ct.list();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test13(){
		Session session = HibernateUtil.getSession();
		CriteriaQuery<Dept> ct = session.getCriteriaBuilder().createQuery(Dept.class);
		ct.from(Dept.class);
		Query<Dept> query = session.createQuery(ct);
		List<Dept> list = query.list();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test14(){
		String sql = "select deptno,dname,loc from dept";
		Session session = HibernateUtil.getSession();
		NativeQuery<Dept> query = session.createNativeQuery(sql,Dept.class);
		List<Dept> list = query.getResultList();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
	@Test
	public void test15(){
		String sql = "select deptno,dname,loc from dept where dname like :name";
		Session session = HibernateUtil.getSession();
		NativeQuery<Dept> query = session.createNativeQuery(sql,Dept.class);
		query.setParameter("name", "%java%");
		List<Dept> list = query.getResultList();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
	
}
