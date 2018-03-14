package com.xdl.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xdl.bean.BankAccount;
import com.xdl.bean.BankAccount2;
import com.xdl.dao.BankAccountDAO;
import com.xdl.util.SqlSessionUtil;

public class BankAccountDAOOracleImp implements BankAccountDAO {

	@Override
	public int bankAccountCount() {
		SqlSession  sqlSession = SqlSessionUtil.getSqlSession();
		int c =  sqlSession.selectOne("bankAccountCount");
		sqlSession.close();
		return c;
	}

	@Override
	public BankAccount bankAccountByAno(String ano) {
		SqlSession  sqlSession = SqlSessionUtil.getSqlSession();
		BankAccount account = sqlSession.selectOne("bankAccountByAno", ano);
		sqlSession.close();
		return   account;
	}

	@Override
	public int bankAccountAdd(BankAccount account) {
		SqlSession  sqlSession = SqlSessionUtil.getSqlSession();
		int rows =  sqlSession.insert("bankAccountAdd", account);
		sqlSession.commit();
		sqlSession.close();
		return  rows;
	}

	@Override
	public int bankAccountDeteleByAno(String ano) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BankAccount> bankAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount2 bankAccount2ByAno(String ano) {
		// TODO Auto-generated method stub
		return null;
	}

}
