package com.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.dao.PizzaToppingDao;
import com.pizza.domain.PizzaToppingDomain;

@Service
public class PizzaToppingService {

	@Autowired
	PizzaToppingDao pizzaToppingDao;
	
	public List<PizzaToppingDomain> getToppings(){
		List<PizzaToppingDomain> toppingList = pizzaToppingDao.getToppingDetails();
		return toppingList;
	}
}
