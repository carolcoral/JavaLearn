package com.xdl.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;
import com.xdl.util.SqlSessionUtil;

public class BankAccountDAOMapperTest {

	public static void main(String[] args) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		// 用接口来自动生成对应的实现类 
		BankAccountDAO  accountDao = sqlSession.getMapper(BankAccountDAO.class);
		System.out.println(accountDao.bankAccountCount());
        BankAccount  account  =  accountDao.bankAccountByAno("110119");
        System.out.println(account);
        /* BankAccount  acc = new BankAccount("000024", "詹姆斯",
        	"123", 123);
        int rows = accountDao.bankAccountAdd(acc);
        System.out.println("rows="+rows);
        sqlSession.commit();  */
    
        int rows = accountDao.bankAccountDeteleByAno("110119");
        System.out.println("rows="+rows);
        sqlSession.commit();
        List<BankAccount>  datas = accountDao.bankAccountList();
        System.out.println(datas);
        sqlSession.close();
	}

}
