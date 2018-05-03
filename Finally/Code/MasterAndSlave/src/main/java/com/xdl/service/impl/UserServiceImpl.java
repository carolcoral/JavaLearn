package com.xdl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xdl.dao.UserDAO;
import com.xdl.entity.UserVo;
import com.xdl.service.UserService;

/**
 * 
 * @author likang
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	
	
	public List<UserVo> findUser() {
		List<UserVo> list = userDAO.findUsers();
		System.out.println("用户个数："+list.size());
		return list;
	}

	@Transactional
	public void addUser(UserVo userVo) {
		userDAO.addUser(userVo);
	}

	
	
	
	
}
