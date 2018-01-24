package cn.xdl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xdl.bean.CarProduct;

/**
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取商品的信息
		String name = request.getParameter("name");//乱码处理
		String price = request.getParameter("price");
		//封装购物车中的数据对象
		CarProduct product = new CarProduct();
		product.setName(new String(name.getBytes("iso-8859-1"),"utf-8"));
		product.setPrice(Double.parseDouble(price));
		product.setNum(1);
		product.setTotal(product.getPrice()*product.getNum());
		
		
		//2.添加到session
		HttpSession session = request.getSession();
		//获取购物车列表
		List<CarProduct> carList = (List<CarProduct>)session.getAttribute("carlist");
		//判断商品列表是否存在
		if(carList != null){
			//商品列表已经存在
			boolean flag = true;
			
			for (CarProduct carProduct : carList) {
				if(product.getName().equals(carProduct.getName())){
					carProduct.setNum(carProduct.getNum()+1);//数量+1
					carProduct.setTotal(carProduct.getPrice()*carProduct.getNum());//当前商品需要的价格
					flag = false;
					break;
				}
			}
			
			
			if(flag){
				carList.add(product);
			}
			
		}else{//商品列表是不存在
			//第一次添加商品
			carList = new ArrayList<>();
			carList.add(product);
			
		}
		
		session.setAttribute("carlist", carList);
		
		//3.跳转购物车页面（转发，重定向）
		response.sendRedirect("product_car.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
