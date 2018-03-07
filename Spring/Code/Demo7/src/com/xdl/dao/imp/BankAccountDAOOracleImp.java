package com.xdl.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;
import com.xdl.mapper.BankAccountMapper;

@Repository("bankDao")
public class BankAccountDAOOracleImp implements BankAccountDAO {
    @Resource
    private  JdbcTemplate  jdbcTemplate;
	@Override
	public List<BankAccount> listBankAccount() {
		String  sql = "select * from bank_account";
		return jdbcTemplate.query(sql, new BankAccountMapper());
	}
	@Override
	public int deteleAccountByAno(String ano) {
		String  sql = "delete from bank_account where ano = ?";
		try {
			return jdbcTemplate.update(sql, ano);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return  0;
	}

}
