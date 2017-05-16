package com.pizza.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.pizza.domain.PizzaDomain;

public class PizzaDomainMapper implements RowMapper<PizzaDomain>{

	public PizzaDomain mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int id = resultSet.getInt("id");
		int size = resultSet.getInt("size");
		int price = resultSet.getInt("price");
		
		PizzaDomain pizzaDomain = new PizzaDomain(id, size, price);
		return pizzaDomain;
	}

}
