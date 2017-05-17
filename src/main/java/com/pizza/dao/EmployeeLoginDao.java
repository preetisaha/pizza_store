package com.pizza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pizza.domain.EmployeeLoginDomain;
import com.pizza.mapper.EmployeeLoginMapper;

@Repository
public class EmployeeLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeLoginDomain getLoginInfo(String email) {
		return jdbcTemplate.queryForObject("SELECT * FROM employee_login WHERE email = ?", new Object[]{email}, new EmployeeLoginMapper());
	}
	
}
