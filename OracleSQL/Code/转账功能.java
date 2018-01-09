/*转账功能看似简单的只是数据的转移，但是其重点需要考虑的是同步问题，即当同一个账号在某时某刻的同时同点的不同地方采用了取款、转账或存款的操作，需要避免对数据库中数据的正确读写，若没有考虑到同步问题则可能出现 A 存入账户，B 取出账户，但该账户的读写结果可能只写入了 A 的操作或只写入了 B 的操作的问题。*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestTC {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/TestJava";
		String name = "root";
		String passwd = "947752894";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 链接 mysql 数据库必须写上该句，不然报错
			connection = DriverManager.getConnection(url, name, passwd);
			connection.setAutoCommit(false);//取消自动提交功能，手动提交
			String sql1 = "update account set money = money -400 where id = 10000";
			String sql2 = "update account set money = money +400 where id = 10002";
			PreparedStatement pre = connection.prepareStatement(sql1);
			PreparedStatement pre2 = connection.prepareStatement(sql2);
			int res1 = pre.executeUpdate();
			int res2 = pre2.executeUpdate();
			if (res1 == 1 && res2 == 1) {
				connection.commit();
				System.out.println("转账成功！");
			} else {
				connection.rollback();
				System.out.println("账户出错，转账失败！");
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
