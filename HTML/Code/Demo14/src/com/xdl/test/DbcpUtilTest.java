package com.xdl.test;

import java.sql.Connection;

import com.xdl.util.DbcpUtil;

public class DbcpUtilTest {

	public static void main(String[] args) {
		
        for(int i=0;i<100;i++){
        	Connection  conn = DbcpUtil.getConnection();
    		System.out.println(i +":"+conn.hashCode());
    		if(i==5){
        		DbcpUtil.realeaseResource(conn, null, null);
        	}
        }
	}

}
