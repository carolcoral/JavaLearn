package com.xdl.test;

import com.xdl.dao.XdlUserDAO;
import com.xdl.dao.imp.XdlUserDAOOracleImp;

public class XdlUserDAOTest {

	public static void main(String[] args) {
		XdlUserDAO   userDao = new XdlUserDAOOracleImp();
		System.out.println(userDao.checkName("zhangsan"));

	}

}
