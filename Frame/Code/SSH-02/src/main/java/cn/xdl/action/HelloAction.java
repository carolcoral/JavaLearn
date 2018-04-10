package cn.xdl.action;

import org.apache.struts2.ServletActionContext;

public class HelloAction {

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//默认方法名为execute,无参
	public String execute(){
		ServletActionContext.getRequest().setAttribute("msg", "Request内容");
		System.out.println("进入HelloAction处理");
		msg = "Hello World";
		return "success";//与<result>配置对应
	}
	
}
