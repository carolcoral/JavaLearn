package com.xdl.service;

import java.util.List;

import com.xdl.entity.UserVo;
import com.xdl.util.DataSource;

public interface UserService {

	/**
	 * 查询---读业务----从服务器
	 * @return
	 */
	@DataSource("slave")
	public List<UserVo> findUser();
	
	/**
	 * 增加---写----主服务器进行操作
	 * @param userVo
	 */
	public void addUser(UserVo userVo);
	
}
