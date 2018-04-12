package cn.xdl.entity;

import java.io.Serializable;

public class Dept implements Serializable{

	private int no; //DEPTNO
	private String name; //DNAME
	private String loc; //LOC
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
