package cn.xdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.bean.XdlProduct;
import cn.xdl.dao.ProductDaoImp;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.查询数据库，获取商品信息
		ProductDaoImp productDaoImp = new ProductDaoImp();
		List<XdlProduct> datas = productDaoImp.queryAllProduct();
		// 2.将查询到的数据，发送给jsp
		RequestDispatcher dispather = request.getRequestDispatcher("product_list.jsp");
		request.setAttribute("data", datas);
		dispather.forward(request, response);
	}

}
