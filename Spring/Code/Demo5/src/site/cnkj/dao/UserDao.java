package site.cnkj.dao;

import site.cnkj.bean.User;

public interface UserDao {
	// 用户登录功能
	public User UserLogin(String user_name, String user_password);
}
