package cn.xdl.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//实体
@Table(name="EMP")//对应EMP表
public class Emp implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ENAME")
	private String ename;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="BIRTHDAY")
	private Date birthday;
	
	@Column(name="DEPTNO")
	private int deptno;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
