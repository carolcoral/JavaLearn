package cn.xdl.dao;

import java.util.List;

import cn.xdl.bean.XdlProduct;

public interface ProductDao {
	/**
	 * 查询所有商品信息
	 * 
	 * @return
	 */
	List<XdlProduct> queryAllProduct();
}
