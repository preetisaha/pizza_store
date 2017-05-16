package com.pizza.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.pizza.domain.PizzaToppingDomain;

public class PizzaToppingMapper implements RowMapper<PizzaToppingDomain>{

	public PizzaToppingDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String topping = rs.getString("topping");
		int price = rs.getInt("price");
		String image = rs.getString("image");
		
		PizzaToppingDomain pizzaToppingDomain = new PizzaToppingDomain(id, topping, price, image);
		return pizzaToppingDomain;
	}

}
