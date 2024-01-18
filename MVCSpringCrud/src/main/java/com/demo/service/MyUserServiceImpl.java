package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MyUserDao;
import com.demo.model.MyUSer;

@Service
public class MyUserServiceImpl implements MyUserService{
	
	@Autowired
	private MyUserDao udao;

	@Override
	public MyUSer checkUser(String uname, String passwd) {
		return udao.verifyUser(uname, passwd);
	}

}
