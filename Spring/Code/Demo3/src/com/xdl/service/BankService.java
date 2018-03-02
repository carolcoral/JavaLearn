package com.xdl.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;
import com.xdl.exception.BankAccountException;

@Service
public class BankService {
	// 转账的方法
	// @throws BankAccountException
	/*
	 * rollbackfor: 遇到某些异常回滚 norollbackfor：遇到某些异常时候不会滚
	 */
	@Transactional(rollbackFor = {
			BankAccountException.class }, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void transfer(BankAccount fromAccount, BankAccount toAccount, double money) {
		bankDAO.transOutBankAccountMoney(fromAccount, money);
		if (1 == 1) {
			try {
				throw new BankAccountException();
			} catch (BankAccountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bankDAO.transInBankAccountMoney(toAccount, money);
	}

	@Resource
	private BankAccountDAO bankDAO;

	public BankAccountDAO getBankDAO() {
		return bankDAO;
	}

	public void setBankDAO(BankAccountDAO bankDAO) {
		this.bankDAO = bankDAO;
	}
}
