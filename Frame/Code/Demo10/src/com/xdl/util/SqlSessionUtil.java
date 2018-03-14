package com.xdl.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xdl.test.BankAccountTest;

public class SqlSessionUtil {
    private  static  SqlSessionFactory sqlSessionFactory;
    static {
    	SqlSessionFactoryBuilder  ssfb = new SqlSessionFactoryBuilder();
		InputStream  inputStream = BankAccountTest.class.getClassLoader()
			.getResourceAsStream("sqlmap-config.xml");
		sqlSessionFactory = ssfb.build(inputStream);
    }
    public  static  SqlSession  getSqlSession(){
    	return  sqlSessionFactory.openSession();
    }
}
