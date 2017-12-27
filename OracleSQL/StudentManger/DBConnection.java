package day07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBConnection {
	public static Connection connection = null;
	public static Properties properties = new Properties();

	public static Connection connection() {
		// public static void mian(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// BufferedReader bufferedReader = new BufferedReader(new
			// InputStreamReader(System.in));

			FileInputStream fis = new FileInputStream("/Users/carol/Learn/Java培训/OracleSql/OracleSQL/src/day07/DB.properties");
			properties.load(fis);
			fis.close();
			String url = properties.getProperty("url");
			String name = properties.getProperty("name");
			String passwd = properties.getProperty("passwd");
			String maxActive = properties.getProperty("maxActive");
			String maxIdle = properties.getProperty("maxIdle");
			String maxWait = properties.getProperty("maxWait");
			String maxMinIdle = properties.getProperty("maxMinIdle");
			BasicDataSource bds = new BasicDataSource();// 建立连接池
			bds.setUrl(url);// 设置地址
			bds.setUsername(name);// 设置数据库名称
			bds.setPassword(passwd);// 设置数据库密码
			bds.setMaxActive(Integer.valueOf(maxActive));// 最大活动连接数
			bds.setMaxIdle(Integer.valueOf(maxIdle));// 最大空闲连接数
			bds.setMaxWait(Integer.valueOf(maxWait));// 最多等待时间
			bds.setMinIdle(Integer.valueOf(maxMinIdle));// 最少连接数
			// connection = bds.getConnection();
			connection = DriverManager.getConnection(url, name, passwd);
			// System.out.println("数据库链接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}
