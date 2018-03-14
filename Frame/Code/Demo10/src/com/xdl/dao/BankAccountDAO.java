package com.xdl.dao;

import java.util.List;

import com.xdl.bean.BankAccount;
import com.xdl.bean.BankAccount2;

public interface BankAccountDAO {
    int   bankAccountCount();
    BankAccount  bankAccountByAno(String ano);
    int  bankAccountAdd(BankAccount account); 
    int  bankAccountDeteleByAno(String ano);
    List<BankAccount> bankAccountList();
    BankAccount2  bankAccount2ByAno(String ano);
}
