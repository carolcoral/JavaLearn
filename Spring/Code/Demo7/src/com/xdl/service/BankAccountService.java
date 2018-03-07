package com.xdl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;

@Service
public class BankAccountService {
	 @Resource
     private   BankAccountDAO  bankDao;

	public BankAccountDAO getBankDao() {
		return bankDao;
	}

	public void setBankDao(BankAccountDAO bankDao) {
		this.bankDao = bankDao;
	}
	/** 显示银行银行列表 */
	public  List<BankAccount>  listBankAccount(){
		return  bankDao.listBankAccount();
	}
	/** 根据账号 删除账户  */
	public  boolean  removeAccountByAno(String ano){
		return  bankDao.deteleAccountByAno(ano)==1?true:false;
	}
}



