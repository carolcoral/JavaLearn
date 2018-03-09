package com.xdl.dao;

import java.util.List;

import com.xdl.bean.BankAccount;

public interface BankAccountDAO {
     List<BankAccount>  listBankAccount();
     /** 根据账号 删除账户 */
     int   deteleAccountByAno(String ano);
     /** 根据账号 查询账户 */
     BankAccount   getAccountByAno(String ano);
     /** 插入银行账户数据 */
     int   insertAccount(BankAccount  account);
     /** 更新方法 */
     int   updateAccount(BankAccount  account);
}
