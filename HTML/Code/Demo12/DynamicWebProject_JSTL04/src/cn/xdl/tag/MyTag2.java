package cn.xdl.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag2 extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.append("end");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		try {
			out.append("start");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
