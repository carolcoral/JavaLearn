package cn.xdl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xdl.bean.XdlProduct;
import cn.xdl.util.DbcpUtilsPools;

public class ProductDaoImp implements ProductDao {

	@Override
	public List<XdlProduct> queryAllProduct() {
		//1.获取数据库连接对象
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<XdlProduct> datas = new ArrayList<>();
		XdlProduct product = null;
		try {
			conn = DbcpUtilsPools.getConnection();
			
			//2.执行sql语句
			String queryProductStr = "select * from xdl_product";
			pst = conn.prepareStatement(queryProductStr);
			
			//3.处理结果集
			rs = pst.executeQuery();
			while(rs.next()){
				//封装一个商品对象
				product = new XdlProduct();
				
				product.setName(rs.getString("name"));
				product.setFixed_price(rs.getFloat("fixed_price"));
				product.setBig_picture(rs.getString("big_picture"));
				//把商品对象添加集合中
				datas.add(product);
			}
			//返回商品的集合对象
			for (XdlProduct xdlProduct : datas) {
				System.out.println(xdlProduct);
			}
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		new ProductDaoImp().queryAllProduct();
	}

}
