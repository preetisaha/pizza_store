package com.pizza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pizza.domain.UserLoginDomain;
import com.pizza.mapper.UserLoginMapper;

@Repository
public class UserLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserLoginDomain getLoginInfo(String email) {
		return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT * FROM user_login WHERE email = ?", new Object[]{email}, new UserLoginMapper()));
	}
}
