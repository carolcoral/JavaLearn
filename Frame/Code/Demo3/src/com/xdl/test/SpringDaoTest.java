package com.xdl.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;
import com.xdl.service.BankService;

public class SpringDaoTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		BankAccountDAO bankAccountDAO = applicationContext.getBean("bankDao", BankAccountDAO.class);
		// System.out.println(bankAccountDAO.getBankAccountCount());
		// System.out.println("————————————————————————");
		// BankAccount bankAccount =
		// bankAccountDAO.getBankAccountByNameAndPassword("xiaoma", "123");
		// System.out.println(bankAccount);
		// System.out.println("————————————————————————");
		// List<BankAccount> datas = bankAccountDAO.getBankAccountListByMoney(5000);
		// System.out.println(datas);
		System.out.println("————————————————————————");
		BankAccount bankAccount2 = new BankAccount(1, "xiaoma", "123", 10000);
		int rows = bankAccountDAO.insertBankAccount(bankAccount2);
		System.out.println(rows);
		// System.out.println("————————————————————————");
		// int rows2 = bankAccountDAO.deleteBankAccountByName("xiaoming");
		// System.out.println(rows2);
		// System.out.println("————————————————————————");
		// int res = bankAccountDAO.getBankAccountByNameAndPassword("guanyu",
		// "123").getAno();
		// BankAccount bankAccount3 = new BankAccount(res, "xiaoxiaofei", "999",
		// 123400);
		// int rows3 = bankAccountDAO.updateBankAccount(bankAccount3, "guanyu");
		// System.out.println(rows3);

		BankService bankService = applicationContext.getBean("bankService", BankService.class);
		BankAccount fromAccount = new BankAccount(1, "mengge", "123", 2000);
		BankAccount toAccount = new BankAccount(1, "xiaoma", "123", 100);
		bankService.transfer(fromAccount, toAccount, 100);

	}

}
