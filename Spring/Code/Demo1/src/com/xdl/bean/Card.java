package com.xdl.bean;

public class Card {
	
    @Override
	public String toString() {
		return "Card [suits=" + suits + ", point=" + point + "]";
	}
	public Card(String suits, String point) {
		super();
		this.suits = suits;
		this.point = point;
	}
	public Card() {
		super();
		this.suits="ºÚÌÒ";
		this.point="A";
	}
	public String getSuits() {
		return suits;
	}
	public void setSuits(String suits) {
		this.suits = suits;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	private   String   suits;
    private   String   point;
}
