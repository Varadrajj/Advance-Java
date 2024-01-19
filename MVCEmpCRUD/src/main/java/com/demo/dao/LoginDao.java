package com.demo.dao;

import com.demo.model.MyUser;

public interface LoginDao {

	MyUser validateUser(String uname, String password);

}
