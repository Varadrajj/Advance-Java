package com.demo.service;

import com.demo.model.MyUser;

public interface LoginService {

	MyUser checkUser(String uname, String password);

}
