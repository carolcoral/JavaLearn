package cn.xdl.factory;

import java.util.ResourceBundle;

import cn.xdl.dao.XdlProductDao;

public class XdlProductDaoFactory {
	
	public static XdlProductDao getProductDaoInstance() {
		
		XdlProductDao dao = null;
		try {
			//读取配置文件，获取类全称：包名+类名
			ResourceBundle rb = ResourceBundle.getBundle("cn.xdl.factory.productdao_config");
			String str = rb.getString("productDaoClassInfo");
			//通过反射的方式，创建对象
			Class< XdlProductDao> cls =  (Class<XdlProductDao>) Class.forName(str);
			
			dao  = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dao;
	}
}
