package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xdl.bean.CarProduct;

/**
 * Servlet implementation class UpdateCarProductNumServlet
 */
public class UpdateCarProductNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取需要更改的购物车项的id和修改的数量
		String pid = request.getParameter("pid");
		System.out.println("pid:"+pid);
		int cidNum = Integer.parseInt(pid);
		String num = request.getParameter("num");
		int numNum = Integer.parseInt(num);
		
		//2.session获取购物车清单列表
		HttpSession session= request.getSession();
		List<CarProduct> carList = (List<CarProduct>)session.getAttribute("carlist");
		//3.更新清单操作
		int findCarProductIndex = carList.indexOf(new CarProduct(cidNum));//equal指定的规则查找对象
		CarProduct findProduct = carList.get(findCarProductIndex);//引用传递
		findProduct.setNum(findProduct.getNum()+numNum);
		//将总价格截取小数点后两位
		double perCarProductSumPrice = findProduct.getNum()*findProduct.getPrice();
		String perCarProductSumPriceStr = (perCarProductSumPrice+"").substring(0, (perCarProductSumPrice+"").indexOf(".")+2);
		//更新总价格
		findProduct.setTotal(Double.valueOf(perCarProductSumPriceStr));
		
		//4. 更新总价格
		double sumPrice = 0.0;
		String sumPriceStr = "";
		if(carList.size()>0){
			for (int i = 0; i < carList.size(); i++) {
				sumPrice+=carList.get(i).getTotal();
			}
			//保留两位小数
			sumPriceStr = String.format("%.2f", sumPrice);
			
		}
		
		session.setAttribute("carlist", carList);
		session.setAttribute("sumPrice", sumPriceStr);
		
		//5.页面的跳转
		//response.sendRedirect("product_car.jsp");
		PrintWriter pw = response.getWriter();
		System.out.println("总价格："+sumPriceStr);
		pw.print(sumPriceStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
