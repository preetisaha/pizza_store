package com.pizza.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pizza.domain.OrderDetailDomain;
import com.pizza.mapper.OrderDetailMapper;

@Repository
public class OrderDetailDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public OrderDetailDomain saveOrderDetail(int uid, int pizza_price) {
		jdbcTemplate.update("insert into order_detail (uid, pizza_price, status) values (?, ?, 0)",
				new Object[] { uid, pizza_price });
		return jdbcTemplate.queryForObject("select * from order_detail where order_no = (select last_insert_id())",
				new OrderDetailMapper());
	}

	public void saveTopping(int order_no, Integer topping_id) {
		jdbcTemplate.update("insert into order_topping values (?,?)", new Object[] { order_no, topping_id});
	}
}
