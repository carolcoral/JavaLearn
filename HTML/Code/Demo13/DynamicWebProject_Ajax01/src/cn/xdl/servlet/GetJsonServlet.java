package cn.xdl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.bean.Teacher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetJsonServlet
 */
@WebServlet("/GetJsonServlet")
public class GetJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// // 1.从数据库获取一条数据，封装成java对象
		// Teacher t = new Teacher("橘梨纱老师", 26, "偶像团体AKB48的前成员，下海经商");
		// // 2.把java对象转换成json对象
		// JSONObject jsonObject = JSONObject.fromObject(t);
		// // 3.获取json字符串
		// String jsonObjectStr = jsonObject.toString();
		// System.out.println(jsonObjectStr);
		//

		// 二、多个多个json对象
		Teacher t = new Teacher("橘梨纱老师", 26, "偶像团体AKB48的前成员，下海经商");
		Teacher t2 = new Teacher("Julia", 36, "善解人意的好老师");

		List<Teacher> ts = new ArrayList<>();
		ts.add(t);
		ts.add(t2);

		JSONArray array = JSONArray.fromObject(ts);
		String jsonStr = array.toString();
		response.getWriter().print(jsonStr);
	}

}
