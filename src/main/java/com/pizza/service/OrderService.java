package com.pizza.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.pizza.dao.OrderDao;
import com.pizza.domain.OrderDetailDomain;


@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	
	public OrderDetailDomain saveOrderDetail(int uid, int pizza_price) {
		return orderDao.saveOrderDetail(uid, pizza_price);
	}
	
	public void saveTopping(int order_no, List<Integer> toppingList){
		int i;
		for(i = 0; i < toppingList.size(); i++){
			Integer topping_id = toppingList.get(i);
			orderDao.saveTopping(order_no, topping_id);
		}
	}
	
	public int getNewOrderCount(){
		int newOrderCount = orderDao.getNewOrderCount();
		return newOrderCount;
	}
	
	public OrderDetailDomain pullOrder(int eid){
		return orderDao.pullOrder(eid);
	}
	
	public void updateOrder(int userId, int orderNumber, int orderStatus) {
		orderDao.updateOrder(orderNumber, orderStatus);
		simpMessagingTemplate.convertAndSend("/topic/orderStatus-" + userId, orderStatus);
	}
}
