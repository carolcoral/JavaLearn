package com.xdl.dao;

import java.util.List;

import com.xdl.entity.UserVo;

/**
 * dao接口
 * @author likang
 * @date   2017-10-25 上午8:07:10
 */
public interface UserDAO {

	/**
	 * 查询---读
	 * @return
	 */
	public List<UserVo> findUsers();
	
	
	/**
	 * 增加用户---写
	 * @param userVo
	 * @return
	 */
	public Integer addUser(UserVo userVo);
	
	
	
	
}
