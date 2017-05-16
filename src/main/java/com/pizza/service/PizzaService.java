package com.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.dao.PizzaDao;
import com.pizza.domain.PizzaDomain;

@Service
public class PizzaService {

	@Autowired
	PizzaDao pizzaDao;
	
	public List<PizzaDomain> getPizzaDetails(){
		return pizzaDao.getPizzaDetails();
	}
}
