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
		// 1.获取数据库连接对象
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<XdlProduct> datas = new ArrayList<>();
		XdlProduct product = null;
		try {
			conn = DbcpUtilsPools.getConnection();

			// 2.执行sql语句
			String queryProductStr = "select * from xdl_product";
			pst = conn.prepareStatement(queryProductStr);

			// 3.处理结果集
			rs = pst.executeQuery();
			while (rs.next()) {
				// 封装一个商品对象
				product = new XdlProduct();
				product.setProduct_id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setFixed_price(rs.getFloat("fixed_price"));
				product.setBig_picture(rs.getString("big_picture"));
				// 把商品对象添加集合中
				datas.add(product);
			}
			// 返回商品的集合对象
			for (XdlProduct xdlProduct : datas) {
				System.out.println(xdlProduct);
			}
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(XdlProduct product) {
		// 1.获取数据库连接对象
		Connection conn = null;
		PreparedStatement pst = null;
		int result = -1;
		try {
			conn = DbcpUtilsPools.getConnection();
			// 2.执行sql语句
			String addProductStr = "insert into   xdl_product(product_id,name,fixed_price,big_picture) values(xdl_product_productid_seq.nextval,?,?,?)";
			pst = conn.prepareStatement(addProductStr);
			pst.setString(1, product.getName());
			pst.setFloat(2, product.getFixed_price());
			pst.setString(3, product.getBig_picture());
			result = pst.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int del(int num) {
		// 1.获取数据库连接对象
		Connection conn = null;
		PreparedStatement pst = null;
		int result = -1;
		try {
			conn = DbcpUtilsPools.getConnection();
			// 2.执行sql语句
			String delProductStr = "delete from  xdl_product where product_id=?";
			pst = conn.prepareStatement(delProductStr);
			pst.setInt(1, num);
			result = pst.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(XdlProduct newProduct) {
		// 1.获取数据库连接对象
		Connection conn = null;
		PreparedStatement pst = null;
		int result = -1;
		try {
			conn = DbcpUtilsPools.getConnection();
			// 2.执行sql语句
			String updateProductStr = "update xdl_product set name=? , fixed_price = ? , big_picture=? where product_id=?";
			pst = conn.prepareStatement(updateProductStr);
			pst.setString(1, newProduct.getName());
			pst.setFloat(2, newProduct.getFixed_price());
			pst.setString(3, newProduct.getBig_picture());
			pst.setInt(4, newProduct.getProduct_id());

			result = pst.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public XdlProduct queryOneProduct(int num) {
		// 1.获取数据库连接对象
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		XdlProduct product = null;
		try {
			conn = DbcpUtilsPools.getConnection();

			// 2.执行sql语句
			String queryProductStr = "select * from xdl_product where product_id=?";
			pst = conn.prepareStatement(queryProductStr);
			pst.setInt(1, num);
			// 3.处理结果集
			rs = pst.executeQuery();
			if (rs.next()) {
				// 封装一个商品对象
				product = new XdlProduct();
				product.setProduct_id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setFixed_price(rs.getFloat("fixed_price"));
				product.setBig_picture(rs.getString("big_picture"));
				// 把商品对象添加集合中
				return product;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ProductDaoImp imp = new ProductDaoImp();
		//List<XdlProduct>datas = imp.queryAllProduct();
		//XdlProduct product = imp.queryOneProduct(12);
		//System.out.println(product);
		//imp.del(12);
//		XdlProduct newProduct = new XdlProduct();
//		newProduct.setProduct_id(11);
//		
//		newProduct.setName("怪诞行为学2");
//		newProduct.setFixed_price(666.6f);
//		imp.update(newProduct);
		
	/*	
		XdlProduct newProduct = new XdlProduct();
		
		newProduct.setName("阿叼");
		newProduct.setFixed_price(888.8f);
		newProduct.setBig_picture("img/big/book12.jpg");
		imp.add(newProduct);
		imp.queryAllProduct();*/
		
	}
	
}








