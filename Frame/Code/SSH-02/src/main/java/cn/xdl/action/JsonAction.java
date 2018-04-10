package cn.xdl.action;

import cn.xdl.entity.Dept;

public class JsonAction {
	private int no;
	private String name;
	private Dept dept;
	
	public String execute(){
		no = 10;
		name = "JAVA";
		dept = new Dept();
		dept.setDeptno(1);
		dept.setDname("开发部");
		dept.setLoc("北京");
		return "success";
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
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
