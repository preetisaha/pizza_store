package com.pizza.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pizza.domain.EmployeeLoginDomain;

public class EmployeeLoginMapper implements RowMapper<EmployeeLoginDomain>{

	public EmployeeLoginDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		int employee_id = rs.getInt("employee_id");
		String name = rs.getString("name");
		String last_name = rs.getString("last_name");
		String address = rs.getString("address");
		String email = rs.getString("email");
		String password = rs.getString("password");
		
		return new EmployeeLoginDomain(employee_id, name, last_name, address, email, password);
	}

}
