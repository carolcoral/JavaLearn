package com.xdl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpUtil {
	private static  DataSource  dataSource;
    static {
    	Properties  pro = new Properties();
    	InputStream   inputStream = DbcpUtil.class.getClassLoader()
    			.getResourceAsStream("db.properties");
    	try {
			pro.load(inputStream);
			dataSource = BasicDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public  static Connection  getConnection(){
    	try {
			return  dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return  null;
    }
    public  static  void  realeaseResource(Connection conn,Statement st,
    		ResultSet rs){
    	if(rs != null){
    		try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
    	}
    	if(st != null){
    		try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				st = null;
			}
    	}
    	if(conn != null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
    	}
    }
}
