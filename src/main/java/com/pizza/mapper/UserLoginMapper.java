package com.pizza.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.pizza.domain.UserLoginDomain;

public class UserLoginMapper implements RowMapper<UserLoginDomain>{

	public UserLoginDomain mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int userId = resultSet.getInt("user_id");
		String name = resultSet.getString("name");
		String lastname = resultSet.getString("last_name");
		String address = resultSet.getString("address");
		String email = resultSet.getString("email");
		String password = resultSet.getString("password");
		
		return new UserLoginDomain(userId, name, lastname, address, email, password);
	}
}
