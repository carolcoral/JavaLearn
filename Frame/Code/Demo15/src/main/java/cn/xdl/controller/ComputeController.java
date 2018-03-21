package cn.xdl.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.entity.MyResult;

@RestController
public class ComputeController {

	@RequestMapping("/compute.do")
	public MyResult execute(int n){
		int r = n;
		for(int i=1;i<n;i++){
			r=r*i;
		}
		//返回结果
		MyResult result = new MyResult();
		result.setStatus(1);
		result.setMsg("计算成功");
		result.setData(r);
		return result;
	}
	
	@ExceptionHandler
	public MyResult handlerException(Exception e){
		MyResult result = new MyResult();
		result.setStatus(0);
		result.setMsg("参数有错");
		result.setData(e.getMessage());
		return result;
	}
	
}
