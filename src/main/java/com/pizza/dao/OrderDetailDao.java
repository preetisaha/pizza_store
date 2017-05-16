package com.pizza.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public int getNewOrderCount(){
		return jdbcTemplate.queryForObject("select COUNT(status) from order_detail where status = 0", Integer.class);
		
	}
	
	@Transactional
	public OrderDetailDomain pullOrder(int eid){
		OrderDetailDomain odd = jdbcTemplate.queryForObject("select * from order_detail order by order_no asc limit 1 for update", new OrderDetailMapper());
		int order_no = odd.getOrder_no();
		
		jdbcTemplate.update("update order_detail set status = 1, eid = ? where order_no = ?", new Object[]{eid, order_no});
		
		return jdbcTemplate.queryForObject("SELECT * FROM order_detail where order_no = ?", new Object[]{order_no}, new OrderDetailMapper());
	}
}
