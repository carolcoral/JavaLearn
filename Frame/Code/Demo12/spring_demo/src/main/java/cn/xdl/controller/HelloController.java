package cn.xdl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	@ResponseBody
	public Map<String, Object> execute(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("msg", "ÄãºÃ");
		return data;
	}
	
}
