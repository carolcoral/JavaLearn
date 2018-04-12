package cn.xdl.entity;

import java.io.Serializable;
import java.util.Set;

public class Dept implements Serializable{

	private int no; //DEPTNO
	private String name; //DNAME
	private String loc; //LOC
	
	private Set<Emp> emps;//通过关联映射加载emp员工
	
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
