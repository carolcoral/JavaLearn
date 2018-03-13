package com.xdl.dao;

import java.util.List;

import com.xdl.bean.BankAccount;

public interface BankAccountDAO {
	// 查询bank_account表中数据量
	public int getBankAccountCount();

	// 根据银行账户用户名和密码来查询一个账户信息
	public BankAccount getBankAccountByNameAndPassword(String name, String password);

	// 根据小于某个数值的钱的信息来查询账户列表信息
	public List<BankAccount> getBankAccountListByMoney(double money);

	// 增加银行账户的方法
	public int insertBankAccount(BankAccount bankAccount);

	// 根据账号删除账户信息
	public int deleteBankAccountByName(String aname);

	// 根据银行账户信息更新数据
	public int updateBankAccount(BankAccount bankAccount,String aname);
}
