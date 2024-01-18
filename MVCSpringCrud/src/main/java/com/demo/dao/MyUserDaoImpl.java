package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUSer;

@Repository
public class MyUserDaoImpl implements MyUserDao{
	
	@Autowired
	private JdbcTemplate jd;

	@Override
	public MyUSer verifyUser(String uname, String passwd) {
		try {
			String str = "select username, password from myuser1 where username=? and password = ?";
			return jd.queryForObject(str, new Object[] {uname, passwd}, BeanPropertyRowMapper.newInstance(MyUSer.class));
		}catch(EmptyResultDataAccessException e) {
			System.out.println("not found"+e.getMessage());
			return null;
		}
		
	}
	
}
