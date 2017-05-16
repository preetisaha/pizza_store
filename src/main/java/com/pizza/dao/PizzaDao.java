package com.pizza.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pizza.domain.PizzaDomain;
import com.pizza.mapper.PizzaDomainMapper;

@Repository
public class PizzaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<PizzaDomain> getPizzaDetails(){
		return jdbcTemplate.query("SELECT * from pizza", new PizzaDomainMapper());
	}
	
}
