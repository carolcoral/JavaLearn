package cn.xdl.entity;

import java.io.Serializable;

public class MyResult implements Serializable{
	
	private int status;//处理结果状态
	private String msg;//提示信息
	private Object data;//返回的数据
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
