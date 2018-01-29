package cn.xdl.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		//1.获取页面的环境对象（上下文对象）
		JspContext context = this.getJspContext();
		//2.获取流对象
		JspWriter out = context.getOut();
		//3.编写数据
		out.append("<h1>今天是个好日子</h1>");
		out.append("<h2>心想的事儿都能成</h2>");
		out.append("<h3>明天又是个好日子</h3>");
		out.append("大后天好日子结束了");
	}

}
