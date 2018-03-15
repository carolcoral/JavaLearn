package com.xdl.bean;

public class XdlDept {
	 
     @Override
	public String toString() {
		return "XdlDept [id=" + id + ", name=" + name + ", loc_addr=" + loc_addr + "]";
	}
	public XdlDept(int id, String name, String loc_addr) {
		super();
		this.id = id;
		this.name = name;
		this.loc_addr = loc_addr;
	}
	public XdlDept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc_addr() {
		return loc_addr;
	}
	public void setLoc_addr(String loc_addr) {
		this.loc_addr = loc_addr;
	}
	private   int   id;
     private   String  name;
     private   String  loc_addr;
     
}
