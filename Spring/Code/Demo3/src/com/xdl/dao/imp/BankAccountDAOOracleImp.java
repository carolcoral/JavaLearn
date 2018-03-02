package com.xdl.dao.imp;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;
import com.xdl.mapper.BankAccountMapper;

@Repository("bankDao")
public class BankAccountDAOOracleImp implements BankAccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BankAccount getBankAccountByNameAndPassword(String name, String password) {
		String sql = "select * from bank_account where aname= ? and apassword = ?";
		// 由结果集到封装成对象的过程需要通过 RowMapper 处理 ——映射器
		try {
			return jdbcTemplate.queryForObject(sql, new BankAccountMapper(), name, password);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BankAccount> getBankAccountListByMoney(double money) {
		String sql = "select * from bank_account where money < ?";
		return jdbcTemplate.query(sql, new BankAccountMapper(), money);
	}

	@Override
	public int insertBankAccount(BankAccount bankAccount) {
		Random random = new Random();
		String sql = "insert into bank_account(aname,apassword,money) values(?,?,?)";
		return jdbcTemplate.update(sql, bankAccount.getAname()+random.nextInt(10000), bankAccount.getApassword(), bankAccount.getMoney());
	}

	@Override
	public int deleteBankAccountByName(String aname) {
		String sql = "delete from bank_account where aname = ?";
		try {
			return jdbcTemplate.update(sql, aname);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBankAccount(BankAccount bankAccount, String aname) {
		String sql = "update bank_account set aname = ? ,apassword = ?,money = ? where aname = ?";
		return jdbcTemplate.update(sql, bankAccount.getAname(), bankAccount.getApassword(), bankAccount.getMoney(),
				aname);
	}

	@Override
	public int getBankAccountCount() {
		String sql = "select count(*) from bank_account";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	// 转账功能的进钱功能
	@Override
	public int transInBankAccountMoney(BankAccount toAccount,double money) {
		String sql = "update bank_account set money = money + ? where aname = ?";
		return jdbcTemplate.update(sql, money,toAccount.getAname());
	}

	// 转账功能的出钱功能
	@Override
	public int transOutBankAccountMoney(BankAccount fromAccount,double money) {
		String sql = "update bank_account set money = money - ? where aname = ?";
		return jdbcTemplate.update(sql, money,fromAccount.getAname());
	}

}
