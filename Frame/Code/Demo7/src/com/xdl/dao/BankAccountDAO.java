package com.xdl.dao;

import java.util.List;

import com.xdl.bean.BankAccount;

public interface BankAccountDAO {
     List<BankAccount>  listBankAccount();
     /** ¸ù¾İÕËºÅ É¾³ıÕË»§ */
     int   deteleAccountByAno(String ano);
}
