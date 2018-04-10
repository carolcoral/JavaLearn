package cn.xdl.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	//如果指定了invoke()方法，返回String值无效;未执行invoke()，返回String值会调用相应Result组件产生输出
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("开始调用拦截器SomeInterceptor");
		
		invocation.invoke();//调用Action+Result
		
		System.out.println("调用拦截器SomeInterceptor结束");
		return null;
	}

}
