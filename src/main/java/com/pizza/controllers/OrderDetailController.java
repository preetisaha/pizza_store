package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.domain.OrderDetailDomain;
import com.pizza.domain.OrderToppingDomain;
import com.pizza.dto.request.OrderRequest;
import com.pizza.service.OrderDetailService;

@RestController
public class OrderDetailController {

	@Autowired
	OrderDetailService orderDetailService;

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public int getOrderNo(@RequestBody OrderRequest orderRequest) {
		int pizza_price = orderRequest.getPizza_price();
		
		System.out.println("pizza price - " + pizza_price);
		
		int uid = orderRequest.getUid();
		
		System.out.println("uid - " + uid);
		
		OrderDetailDomain odd = orderDetailService.saveOrderDetail(uid, pizza_price);
		int order_no = odd.getOrder_no();
		
		System.out.println("order_no - " + order_no);
		
		List<Integer> toppingList = orderRequest.getToppingIdList();
		
		System.out.println("toppingList - " + toppingList);
		
		orderDetailService.saveTopping(order_no, toppingList);
		
		return order_no;

	}
}