package cn.xdl.action;

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
		System.out.println("进入HelloAction处理");
		msg = "Hello World";
		return "success";//与<result>配置对应
	}
	
}
