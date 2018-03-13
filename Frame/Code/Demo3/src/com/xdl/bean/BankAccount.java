package com.xdl.bean;


public class BankAccount {
	private int ano;
	private String aname;
	private String apassword;
	private double money;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int ano, String aname, String apassword, double money) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.apassword = apassword;
		this.money = money;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
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
	@Override
	public String toString() {
		return "BankAccount [ano=" + ano + ", aname=" + aname + ", apassword=" + apassword + ", money=" + money + "]";
	}
}
