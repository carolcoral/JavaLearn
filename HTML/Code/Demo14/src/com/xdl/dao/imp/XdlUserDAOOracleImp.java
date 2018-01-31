package com.xdl.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xdl.dao.XdlUserDAO;
import com.xdl.util.DbcpUtil;

public class XdlUserDAOOracleImp implements XdlUserDAO {

	@Override
	public boolean checkName(String name) {
		Connection  conn = null;
		PreparedStatement   ps = null;
        ResultSet  rs = null;
        conn = DbcpUtil.getConnection();
        String  sql = "select name from xdl_user where name=?";
        try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcpUtil.realeaseResource(conn, ps, rs);
		}
		return false;
	}

}


