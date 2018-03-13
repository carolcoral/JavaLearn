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
}
