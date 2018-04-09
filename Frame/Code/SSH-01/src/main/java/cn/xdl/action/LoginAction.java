package cn.xdl.action;


public class LoginAction extends BaseAction{
	
	private String username;//对应<input type="text" name="username">
	private String password;
	private String error;

	public String execute(){
		//检查用户名和密码 
		if("scott".equalsIgnoreCase(username)
			&&"123456".equals(password)){
			//将用户信息写入session
			//使用Map封装的对象
//			ActionContext ac = ActionContext.getContext();
//			Map<String,Object> session = ac.getSession();//HttpSession
//			session.put("user", username);//底层HttpSession.setAttribute("user",username)
//			session.get("user") //HttpSession.getAttribute("user")
//			Map<String,Object> request = ac.get("request");
			//使用原有Servlet类型的
//			HttpServletRequest httpRequest = ServletActionContext.getRequest();
//			HttpSession session = httpRequest.getSession();
//			session.setAttribute("user", username);
			//使用Aware接口方法注入的Session
			session.put("user", username);
			
			return "success";
		}
		error = "用户名或密码错误";
		return "login";
	}

	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
}
