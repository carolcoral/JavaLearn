package cn.xdl.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-default")//extends="struts-default"
@Namespace("/annotation")//namespace="/annotation"
//@InterceptorRef(value="check")
public class DemoAction {
	
	private String msg;

	@Action(value="demo1",results={
		@Result(name="success",type="dispatcher",location="/WEB-INF/hello.jsp")//<result name="" type="">
	})//<action name="demo1">
	public String execute(){
		msg = "Struts2注解配置";
		System.out.println("执行了DemoAction处理");
		return "success";
	}
	
	@Action(value="demo2",results={
		@Result(name="success",type="json",params={"root","msg"})
	})
	public String someService(){
		msg = "json信息";
		return "success";
	}
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
