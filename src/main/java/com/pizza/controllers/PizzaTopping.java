package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pizza.domain.PizzaToppingDomain;
import com.pizza.service.PizzaToppingService;

@RestController
public class PizzaTopping {

	@Autowired
	PizzaToppingService  pizzaToppingService;
	
	@RequestMapping(value = "/pizzaTopping", method = RequestMethod.GET)
	public List<PizzaToppingDomain> getPizzaDetails(){
		List <PizzaToppingDomain> toppingList=  pizzaToppingService.getToppings();
		return toppingList;
	}
}
