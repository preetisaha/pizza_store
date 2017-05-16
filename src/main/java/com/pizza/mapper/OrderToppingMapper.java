package com.pizza.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pizza.domain.OrderToppingDomain;

public class OrderToppingMapper implements RowMapper<OrderToppingDomain>{

	public OrderToppingDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		int order_no = rs.getInt("order_no");
		int topping_id = rs.getInt("topping_id");
		
		OrderToppingDomain orderToppingDomain = new OrderToppingDomain(order_no, topping_id);
		return orderToppingDomain;
	}

}
