package com.pizza.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.pizza.domain.PizzaToppingDomain;
import com.pizza.mapper.PizzaToppingMapper;

@Repository
public class PizzaToppingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<PizzaToppingDomain> getToppingDetails() {
			return jdbcTemplate.query("SELECT * from toppings", new PizzaToppingMapper());
		}
	}

