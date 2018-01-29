package cn.xdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xdl.bean.CarProduct;

/**
 * Servlet implementation class DeleteCarProductServlet
 */
public class DeleteCarProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求参数（删除的id）
		String cid = request.getParameter("cid");
		int cidNum = Integer.parseInt(cid);
		//2.从session中获取购物车清单
		HttpSession session = request.getSession();
		List<CarProduct> carList  = (List<CarProduct>)session.getAttribute("carlist");
		//3.移除操作
		carList.remove(new CarProduct(cidNum));//查找规则是：equals
		
		
		
		//4.计算商品的总金额
				double sumPrice = 0.0;
				String sumPriceStr = "";
				if(carList.size()>0){
					for (int i = 0; i < carList.size(); i++) {
						sumPrice+=carList.get(i).getTotal();
					}
					//保留两位小数
					sumPriceStr = String.format("%.2f", sumPrice);
					
				}
				
				//5.更新session中数据
				//将数据保存到session
				session.setAttribute("carlist", carList);
				session.setAttribute("sumPrice", sumPriceStr);
				//6.跳转购物车列表
				response.sendRedirect("product_car.jsp");
	}

}
