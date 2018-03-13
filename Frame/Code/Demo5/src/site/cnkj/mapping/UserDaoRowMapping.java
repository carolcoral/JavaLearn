package site.cnkj.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import site.cnkj.bean.User;

public class UserDaoRowMapping implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_password"),
				rs.getString("user_email"));
	}

}
