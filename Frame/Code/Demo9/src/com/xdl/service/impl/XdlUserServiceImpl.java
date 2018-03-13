package com.xdl.service.impl;

import org.springframework.stereotype.Service;

import com.xdl.service.XdlUserService;

@Service("userService")
public class XdlUserServiceImpl implements XdlUserService {

	@Override
	public void login() {
		System.out.println("login service  impl ....");
	}

}
