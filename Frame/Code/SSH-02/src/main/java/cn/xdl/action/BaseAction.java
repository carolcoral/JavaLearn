package cn.xdl.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware,ServletRequestAware{

	protected Map<String,Object> session;
	protected HttpServletRequest httpRequest;
	
	//创建Action对象时，底层会自动调用setSession方法，注入session
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		httpRequest = request;
	}
}
