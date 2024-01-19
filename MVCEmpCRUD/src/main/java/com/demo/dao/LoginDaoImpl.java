package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private JdbcTemplate jdTemplate;

	@Override
	public MyUser validateUser(String uname, String password) {
		try {
		String str="select username,password from myuser where username=? and password=?";
		return jdTemplate.queryForObject(str, new Object[] {uname,password}, BeanPropertyRowMapper.newInstance(MyUser.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}
