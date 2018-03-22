package cn.xdl;

import java.io.Serializable;

public class Dept implements Serializable{
	private int no;
	private String name;

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
	
}
