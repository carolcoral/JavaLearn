package com.xdl.test;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;
import com.xdl.dao.impl.BankAccountDAOOracleImp;

public class BankAccountDAOTest {

	public static void main(String[] args) {
		BankAccountDAO accountDao = new BankAccountDAOOracleImp();
		System.out.println(accountDao.bankAccountCount());
        BankAccount  bankAccount = accountDao.bankAccountByAno("110119");
        System.out.println(bankAccount);
        BankAccount  account = new BankAccount("000010", "Ã·Î÷",
        	"123", 10);
        int rows = accountDao.bankAccountAdd(account);
        System.out.println(rows);
        
	}

}
