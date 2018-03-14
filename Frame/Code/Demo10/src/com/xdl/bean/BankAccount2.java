package com.xdl.bean;

public class BankAccount2 {
	
    
	
    @Override
	public String toString() {
		return "BankAccount2 [uid=" + uid + ", aname=" + aname + ", apassword=" + apassword + ", money=" + money + "]";
	}
	public BankAccount2(String uid, String aname, String apassword, double money) {
		super();
		this.uid = uid;
		this.aname = aname;
		this.apassword = apassword;
		this.money = money;
	}
	public BankAccount2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	private  String  uid;
	private  String  aname;
    private  String  apassword;
    private  double   money;
}
