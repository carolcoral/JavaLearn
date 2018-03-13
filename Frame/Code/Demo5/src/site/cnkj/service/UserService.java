package site.cnkj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.cnkj.bean.User;
import site.cnkj.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	// 用户登录功能
	public User UserLogin(String user_name, String user_password) {
		return userDao.UserLogin(user_name, user_password);
	}

}
