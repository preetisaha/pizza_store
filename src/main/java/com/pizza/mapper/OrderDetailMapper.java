package com.pizza.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.pizza.domain.OrderDetailDomain;

public class OrderDetailMapper implements RowMapper<OrderDetailDomain>{

	public OrderDetailDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		int order_no = rs.getInt("order_no");
		int uid = rs.getInt("uid");
		int pizza_price = rs.getInt("pizza_price");
		
		OrderDetailDomain orderDetailDomain = new OrderDetailDomain(order_no, uid, pizza_price);
		
		return orderDetailDomain;
	}

}
