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

	/**
	 * 根据商品的id，查询一个商品信息
	 * @param num
	 * @return
	 */
	XdlProduct queryOneProduct(int num);
	
	/**
	 * 添加商品信息
	 * 
	 * @param product
	 *            需要添加的商品信息
	 * @return 是否添加成功的标记
	 */
	public int add(XdlProduct product);

	/**
	 * 删除商品信息
	 * 
	 * @param num
	 *            需要删除的商品的编号
	 * @return
	 */
	public int del(int num);

	/**
	 * 更新商品数据
	 * 
	 * @param newProduct 新的商品
	 * @return 
	 */
	public int update(XdlProduct newProduct);
	
	
}
