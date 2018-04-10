package cn.xdl.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		//检查是否登录
		Map<String,Object> session = ActionContext.getContext().getSession(); 
		Object user = session.get("user");
		if(user != null){
			invocation.invoke();//执行Action+Result
			return null;
		}else{
			return "nologin";//返回nologin标识，去找对应result定义
		}
		
	}

}
