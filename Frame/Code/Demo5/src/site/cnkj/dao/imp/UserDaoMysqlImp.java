package site.cnkj.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import site.cnkj.bean.User;
import site.cnkj.dao.UserDao;
import site.cnkj.mapping.UserDaoRowMapping;

@Repository("userDao")
public class UserDaoMysqlImp implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User UserLogin(String user_name, String user_password) {
		String sql = "select * from user where user_name = ? and user_password = ?";
		List<User> user = jdbcTemplate.query(sql, new UserDaoRowMapping(), user_name, user_password);
		return user.isEmpty() ? null : user.get(0);
	}

}
