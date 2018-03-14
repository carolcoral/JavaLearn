package com.xdl.test;

import org.apache.ibatis.session.SqlSession;

import com.xdl.bean.BankAccount;
import com.xdl.bean.BankAccount2;
import com.xdl.dao.BankAccountDAO;
import com.xdl.util.SqlSessionUtil;

public class BankAccount2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SqlSession  sqlSession = SqlSessionUtil.getSqlSession();
        BankAccountDAO  bankDao = sqlSession.getMapper(BankAccountDAO.class);
	    BankAccount2  account = bankDao.bankAccount2ByAno("000010");
	    System.out.println(account);
	}

}
