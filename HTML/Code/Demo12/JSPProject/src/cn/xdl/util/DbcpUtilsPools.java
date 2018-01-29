package cn.xdl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DbcpUtilsPools {
	//连接池对象,数据源
	private static DataSource ds;
	static {
		InputStream is = DbcpUtilsPools.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties pps = new Properties();
		try {
			pps.load(is);
			//1.创建连接池的工厂对象(这是一个实例工厂)
			BasicDataSourceFactory bd = new BasicDataSourceFactory();
			//2.	通过工厂类 获取一个连接资源对象(连接池)
			ds = bd.createDataSource(pps);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// 3.释放资源

	public static void close(Connection conn, Statement state, ResultSet result) {
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = null;
		}
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			state = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println(conn);
	}
}
