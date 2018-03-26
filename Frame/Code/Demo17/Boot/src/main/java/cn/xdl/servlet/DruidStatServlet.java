package cn.xdl.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns="/druid/*",initParams={
	@WebInitParam(name="loginUsername",value="xdl"),
	@WebInitParam(name="loginPassword",value="123")
})
public class DruidStatServlet extends StatViewServlet{

}
