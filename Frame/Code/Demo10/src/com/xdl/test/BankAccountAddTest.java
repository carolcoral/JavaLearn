package com.xdl.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xdl.bean.BankAccount;
import com.xdl.util.SqlSessionUtil;

public class BankAccountAddTest {

	public static void main(String[] args) {
		// ªÒ»°SqlSession
		/* SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		InputStream inputStream = BankAccountTest.class.getClassLoader().getResourceAsStream("sqlmap-config.xml");
		SqlSessionFactory ssf = ssfb.build(inputStream);
		SqlSession sqlSession = ssf.openSession(); */
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		BankAccount  account  =  new  BankAccount("110119", "liweijie",
			"123", 456);
		int  rows = sqlSession.insert("bankAccountAdd", account);
		System.out.println("rows = " + rows);
		sqlSession.commit();
		sqlSession.close();
	}

}
