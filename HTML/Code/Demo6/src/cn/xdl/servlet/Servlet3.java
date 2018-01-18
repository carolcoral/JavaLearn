package cn.xdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s3.do")
public class Servlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("GET请求出现了");
		response.getWriter().append("你真特帅啊~  aiya  让不让活了 ~ ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("POST请求出现了");
		String uname = request.getParameter("uname");
		//更改请求文字的编码格式: 
		//参数1,字节数组 ,参数2编码表
		//uname = new String(uname.getBytes("iso-8859-1"),"UTF-8");
		
		String upass = request.getParameter("upass");
		System.out.println("uname:"+uname);
		if("gaofeifei".equals(uname)) {
			response.getWriter().append("<h1>你已被拉黑, 哈哈哈哈,再见 !~ </h1>");
		}else if("dahonghong".equals(uname)&&"aigaofeifei".equals(upass)) {
			response.getWriter().append("<h1>恭喜你 ! 登录成功了 可以尽情的访问我们的avi rmvb等等的资源了 ~ ~ </h1>");
		}else {
			response.getWriter().append("<h1>恭喜你, 拥有了登录的资格, 请先上传2个T的种子 加入会员 ~ </h1><input type='file'/>");
		}
	}
	
}
