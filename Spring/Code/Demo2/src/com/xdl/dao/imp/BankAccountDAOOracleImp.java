package com.xdl.dao.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;
import com.xdl.mapper.BankAccountMapper;

@Repository("bankDao")
public class BankAccountDAOOracleImp extends JdbcDaoSupport implements BankAccountDAO {
	/* 先继承后实现 */

	@Resource
	public void setMyDataSource(DataSource dataSource) {
		// 传递给父类
		super.setDataSource(dataSource);

	}

	@Override
	public int getBankAccountCount() {
		// 使用 JdbcDaoSupport 这个类中对应的模版
		String sql = "select count(*) from bank_account";
		return super.getJdbcTemplate().queryForObject(sql, Integer.class);// queryForInt()过时方法
	}

	@Override
	public BankAccount getBankAccountByNameAndPassword(String name, String password) {
		String sql = "select * from bank_account where aname= ? and apassword = ?";
		// 由结果集到封装成对象的过程需要通过 RowMapper 处理 ——映射器
		try {
			return super.getJdbcTemplate().queryForObject(sql, new BankAccountMapper(), name, password);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BankAccount> getBankAccountListByMoney(double money) {
		String sql = "select * from bank_account where money < ?";
		return super.getJdbcTemplate().query(sql, new BankAccountMapper(), money);
	}

	@Override
	public int insertBankAccount(BankAccount bankAccount) {
		String sql = "insert into bank_account(aname,apassword,money) values(?,?,?)";
		return super.getJdbcTemplate().update(sql, bankAccount.getAname(), bankAccount.getApassword(),
				bankAccount.getMoney());
	}

	@Override
	public int deleteBankAccountByName(String aname) {
		String sql = "delete from bank_account where aname = ?";
		try {
			return super.getJdbcTemplate().update(sql, aname);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBankAccount(BankAccount bankAccount,String aname) {
		String sql = "update bank_account set aname = ? ,apassword = ?,money = ? where aname = ?";
		return super.getJdbcTemplate().update(sql, bankAccount.getAname(), bankAccount.getApassword(),
				bankAccount.getMoney(), aname);
	}

}
