package com.demo.dao;

import com.demo.model.MyUSer;

public interface MyUserDao {

	MyUSer verifyUser(String uname, String passwd);

}
