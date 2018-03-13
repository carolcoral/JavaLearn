package com.xdl.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.BankAccount;
import com.xdl.service.BankAccountService;

public class BankAccountServiceTest {
	@Test
    public  void  testList(){
    	ApplicationContext  app  = 
    		new ClassPathXmlApplicationContext("spring-dao.xml");
    	BankAccountService  bankService = app.getBean("bankAccountService",
    		 BankAccountService.class);
    	List<BankAccount>  datas = bankService.listBankAccount();
    	System.out.println(datas);
    }
	@Test
	public  void  testSystem(){
		System.out.println("hello world");
	}
	@Test
    public  void  testRemove(){
    	ApplicationContext  app  = 
    		new ClassPathXmlApplicationContext("spring-dao.xml");
    	BankAccountService  bankService = app.getBean("bankAccountService",
    		 BankAccountService.class);
    	
    	System.out.println(bankService.removeAccountByAno("0002"));
    }
	@Test
    public  void  testGet(){
    	ApplicationContext  app  = 
    		new ClassPathXmlApplicationContext("spring-dao.xml");
    	BankAccountService  bankService = app.getBean("bankAccountService",
    		 BankAccountService.class);
    	
    	System.out.println(bankService.accountInfoByAno("0024"));
    }
	@Test 
    public void  testCreate(){
		ApplicationContext  app  = 
	    	new ClassPathXmlApplicationContext("spring-dao.xml");
	    BankAccountService  bankService = app.getBean("bankAccountService",
	    	BankAccountService.class);
	    BankAccount  account = new BankAccount("0001", "guoge", "123456",
	    	20000);
	    System.out.println(bankService.createAccount(account));
	}	
	@Test 
    public void  testUpdate(){
		ApplicationContext  app  = 
	    	new ClassPathXmlApplicationContext("spring-dao.xml");
	    BankAccountService  bankService = app.getBean("bankAccountService",
	    	BankAccountService.class);
	    BankAccount  account = new BankAccount("0001", "weijie1", "123456",
	    	20000);
	    System.out.println(bankService.updateAccount(account));
	}	
}



