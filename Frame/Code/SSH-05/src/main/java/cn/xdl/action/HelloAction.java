package cn.xdl.action;


import org.springframework.stereotype.Controller;

@Controller//默认id名为helloAction
public class HelloAction {
	
	public String execute(){
		System.out.println("进入HelloAction");
		return "success";
	}
	
}
