package com.xdl.bean;

import java.io.Serializable;

public class XdlUser implements  Serializable{	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "XdlUser [id=" + id + ", name=" + name + ", password=" + password + ", city=" + city + "]";
	}
	public XdlUser(int id, String name, String password, String city) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.city = city;
	}
	public XdlUser() {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private  int  id;
    private  String name;
    private  String password;
    private  String  city;
}
