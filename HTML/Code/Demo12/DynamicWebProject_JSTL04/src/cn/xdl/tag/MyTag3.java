package cn.xdl.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag3 extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		//当前站点的访问量
		int countNum = 0;
		//从application中获取数据
		if(pageContext.getAttribute("count", PageContext.APPLICATION_SCOPE)!=null){
			//增加访问量
			countNum = (int) pageContext.getAttribute("count", PageContext.APPLICATION_SCOPE);
			countNum++;
		}else{
			countNum = 1;
		}
		//3.刷新访问量数据
		pageContext.setAttribute("count", countNum,PageContext.APPLICATION_SCOPE);
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}
	
}
