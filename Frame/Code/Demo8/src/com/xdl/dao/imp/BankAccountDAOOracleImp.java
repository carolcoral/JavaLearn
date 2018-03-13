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
	@Override
	public BankAccount getAccountByAno(String ano) {
		String sql = "select * from bank_account where ano = ?";
		List<BankAccount>  accounts = jdbcTemplate.query(sql,
				new BankAccountMapper(), ano);
		return accounts.isEmpty()?null:accounts.get(0);
	}
	@Override
	public int insertAccount(BankAccount account) {
		String sql = "insert into bank_account values(?,?,?,?)";
		try {
			return jdbcTemplate.update(sql, account.getAno(),
				account.getAname(),account.getApassword(),account.getMoney());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  0;
	}
	@Override
	public int updateAccount(BankAccount account) {
		String sql = "update  bank_account set aname=?,apassword=?,"
				+ "money=? where ano=?";
		try {
			return jdbcTemplate.update(sql, account.getAname(),account.getApassword()
					,account.getMoney(),account.getAno());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  0;
	}

}
