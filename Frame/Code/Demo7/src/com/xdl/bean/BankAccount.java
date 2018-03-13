package com.xdl.bean;

public class BankAccount {
	
    @Override
	public String toString() {
		return "BankAccount [ano=" + ano + ", aname=" + aname + ", apassword=" + apassword + ", money=" + money + "]";
	}
	public BankAccount(String ano, String aname, String apassword, double money) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.apassword = apassword;
		this.money = money;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
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
	private  String  ano;
    private  String  aname;
    private  String  apassword;
    private  double   money;
}
