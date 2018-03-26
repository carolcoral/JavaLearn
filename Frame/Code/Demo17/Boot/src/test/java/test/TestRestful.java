package test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.xdl.MyBootApplication;
import cn.xdl.controller.DeptController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MyBootApplication.class})
public class TestRestful {

	@Autowired
	private DeptController controller;
	
	@Test
	public void test1() throws Exception{
		//发送http请求调用resuful服务
		MockMvc mock = MockMvcBuilders.standaloneSetup(controller).build();
		//创建一个/dept/10 GET类型请求
		RequestBuilder getRequest = MockMvcRequestBuilders.get("/dept/10");
		//发送请求,获取返回结果信息
		MvcResult result = mock.perform(getRequest).andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
}
