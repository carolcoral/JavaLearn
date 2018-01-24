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
	ProductDaoImp daoimp = new ProductDaoImp();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String username = request.getParameter("username");
//		String pwd = request.getParameter("pwd");
//		System.out.println("username:"+username);
//		System.out.println("pwd:"+pwd);
		// 1.获取请求的类型  
		String type = request.getParameter("type");   
		System.out.println("type:" + type);
		// 2.处理不同的请求
		if ("login".equals(type)) {
			doLogin(request, response);
		} else if ("queryList".equals(type)) {
			doQueryList(request, response);
		} else if ("add".equals(type)) {
			addProduct(request, response);
		} else if ("del".equals(type)) {
			delProduct(request, response);
		} else if ("findone".equals(type)) {
			findOneProduct(request, response);
		} else if ("update".equals(type)) {
			updateProduct(request, response);
		}

	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取商品信息
		XdlProduct updateProduct = new XdlProduct();
		// 2.封装成商品对象，添加到数据库
		updateProduct.setProduct_id(Integer.parseInt(request.getParameter("num")));
		updateProduct.setName(new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8"));
		updateProduct.setFixed_price(Float.parseFloat(request.getParameter("price")));
		updateProduct.setBig_picture(request.getParameter("img"));

		daoimp.update(updateProduct);

		// 3.跳转商品列表页面(直接跳转product_list.jsp还是其他的方式)
		response.sendRedirect("ProductServlet?type=queryList");
	}

	/**
	 * 商品的查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findOneProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取需要查找的商品信息
		int findProductId = Integer.parseInt(request.getParameter("product_id"));

		// 2.从数据库中查找此商品
		XdlProduct findProduct = daoimp.queryOneProduct(findProductId);
		request.setAttribute("findProduct", findProduct);
		// 3.跳转商品更新页面(直接跳转product_list.jsp还是其他的方式)
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	/**
	 * 删除商品信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取需要删除的商品信息
		int delProductId = Integer.parseInt(request.getParameter("product_id"));

		// 2.从数据库中删除此商品
		daoimp.del(delProductId);

		// 3.跳转商品列表页面(直接跳转product_list.jsp还是其他的方式)
		response.sendRedirect("ProductServlet?type=queryList");
	}

	/**
	 * 添加商品信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取商品信息
		XdlProduct addProduct = new XdlProduct();
		// 2.封装成商品对象，添加到数据库
		addProduct.setName(request.getParameter("name"));
		addProduct.setFixed_price(Float.parseFloat(request.getParameter("price")));
		addProduct.setBig_picture(request.getParameter("img"));

		daoimp.add(addProduct);

		// 3.跳转商品列表页面(直接跳转product_list.jsp还是其他的方式)
		response.sendRedirect("ProductServlet?type=queryList");
	}

	/**
	 * 查询商品信息
	 * 
	 * @param request
	 * @param response
	 */
	private void doQueryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.查询数据库，获取商品信息
		ProductDaoImp productDaoImp = new ProductDaoImp();
		List<XdlProduct> datas = productDaoImp.queryAllProduct();
		// 2.将查询到的数据，发送给jsp
		RequestDispatcher dispather = request.getRequestDispatcher("product_list.jsp");
		request.setAttribute("data", datas);
		dispather.forward(request, response);
	}

	/**
	 * 处理登陆的请求
	 * 
	 * @param request
	 * @param response
	 */
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 获取登陆的请求参数
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println("username:"+username);
		// 2. 验证用户的身份(查询数据库中的user表)
		if ("admin".equals(username) && "666".equals(pwd)) {
			// 3. 响应页面
			// 有效的账户
			// 将用户信息保存到session中
			request.getSession().setAttribute("username", username);

			// 转发或者重定向
			response.sendRedirect("ProductServlet?type=queryList");

		} else {
			// 3. 响应页面
			response.sendRedirect("login.jsp");
		}
	}
}
