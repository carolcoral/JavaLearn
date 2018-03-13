package com.xdl.bean;

public class Player {
	
    public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String name, int age, double money, Card card) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
		this.card = card;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", money=" + money + ", card=" + card + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Card getCard() {
		return card;
	}
	public void setMyCard(Card card) {
		this.card = card;
	}
	private  String  name;
    private  int     age;
    private  double  money;
    private  Card    card;
}
