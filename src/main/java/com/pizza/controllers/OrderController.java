package com.pizza.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.domain.OrderDetailDomain;
import com.pizza.dto.request.OrderRequest;
import com.pizza.dto.request.OrderUpdateRequest;
import com.pizza.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public int getOrderNo(@RequestBody OrderRequest orderRequest) {
		int pizza_price = orderRequest.getPizza_price();
		
		int uid = orderRequest.getUid();
		
		OrderDetailDomain odd = orderService.saveOrderDetail(uid, pizza_price);
		int order_no = odd.getOrder_no();
		
		List<Integer> toppingList = orderRequest.getToppingIdList();
		orderService.saveTopping(order_no, toppingList);
		return order_no;

	}
	
	@RequestMapping(value = "/pullOrder/{eid}", method = RequestMethod.GET)
	public OrderDetailDomain pullOrder(@PathVariable int eid){
		return orderService.pullOrder(eid);
	}
	
	@RequestMapping(value = "/orderUpdate", method = RequestMethod.PUT)
	public void updateOrderStatus(@RequestBody OrderUpdateRequest our) {
		orderService.updateOrder(our.getUserId(), our.getOrderNumber(), our.getOrderStatus());
	}
}