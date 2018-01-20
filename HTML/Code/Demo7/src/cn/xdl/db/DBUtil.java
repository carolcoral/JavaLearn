package cn.xdl.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库的连接池工具!
 */
public class DBUtil {

	/**
	 * 连接池
	 */
	private static DataSource source;

	static {
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties ppt = new Properties();
		try {
			ppt.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
		source = BasicDataSourceFactory.createDataSource(ppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 通过数据库的连接池 ,得到一个数据库的连接对象<br>
	 * 在调用时, 有可能存在一些异常<b>SQLException</b><br>
	 * 当发生异常时, 会返回null ,如果出现此情况 , 请检查properties文件是否存在 或 配置是否正确
	 * @return 连接对象 or null
	 */
	public static Connection getConnection() {
		try {
			return source.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * 用来释放资源操作的方法
	 * @param conn  数据库连接对象
	 * @param state 数据库执行环境
	 * @param result 结果集对象
	 */
	public static void close(Connection conn,Statement state,ResultSet result) throws SQLException {
		if(result!=null) {
			result.close();
			result=null;
		}
		if(state!=null) {
			state.close();
			state=null;
		}
		if(conn!=null) {
			conn.close();
			conn=null;
		}
		
		
		
		
			
	}
	
	
	
}
