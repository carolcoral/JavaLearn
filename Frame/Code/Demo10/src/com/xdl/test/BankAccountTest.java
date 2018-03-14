package com.xdl.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xdl.bean.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// 获取SqlSession
		SqlSessionFactoryBuilder  ssfb = new SqlSessionFactoryBuilder();
		InputStream  inputStream = BankAccountTest.class.getClassLoader()
			.getResourceAsStream("sqlmap-config.xml");
		SqlSessionFactory ssf = ssfb.build(inputStream);
        SqlSession  sqlSession = ssf.openSession();
        // 根据sql定义文件中的id 查询 
        int  count = sqlSession.selectOne("bankAccountCount");
        System.out.println("count = "+ count);
        String  aname = sqlSession.selectOne("bankAccountName", "0002");
        System.out.println("aname = " +aname);
        // 根据账号  查询一个账户信息 
        BankAccount  account = sqlSession.selectOne("bankAccountByAno", "0002");
        System.out.println("account:"+account);
        // 查询所有的银行账户 
        List<BankAccount>  datas = sqlSession.selectList("bankAccountList");
        System.out.println("datas="+datas);
        // 删除银行账户  根据银行账号 
        int rows = sqlSession.delete("bankAccountDeteleByAno", "0002");
        System.out.println("rows = " +rows);
        sqlSession.commit();
        sqlSession.close();
	}

}
