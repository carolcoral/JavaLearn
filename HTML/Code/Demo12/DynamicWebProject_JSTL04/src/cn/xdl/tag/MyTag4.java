package cn.xdl.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag4 extends SimpleTagSupport {
	private int pageLength;//每页显示的条数
	
	public int getPageLength() {
		return pageLength;
	}


	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		
		out.append("<button onclick='btnclick(-1)'>上一页</button>");
		out.append("<button onclick='btnclick(1)'>下一页</button>");
		out.append("<button onclick='btnclick(0)'>首页</button>");
		out.append("<button onclick='btnclick(2)'>尾页</button>");
		out.append("当前共有："+pageLength+"条记录！");
	}
}
