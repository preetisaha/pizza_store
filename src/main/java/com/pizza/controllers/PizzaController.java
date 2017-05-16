package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.domain.PizzaDomain;
import com.pizza.service.PizzaService;

@RestController
public class PizzaController {

	@Autowired
	PizzaService pizzaService;
	
	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public List<PizzaDomain> getPizzaDetails(){
		List <PizzaDomain> pizzaDomain=  pizzaService.getPizzaDetails();
		return pizzaDomain;
	}
}
