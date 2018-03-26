package cn.xdl.servlet;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(urlPatterns="/*",initParams={
	@WebInitParam(name="exclusions",value="*.js,*.jpg,*.css,/druid/*")
})
public class DruidStatFilter extends WebStatFilter{

}
