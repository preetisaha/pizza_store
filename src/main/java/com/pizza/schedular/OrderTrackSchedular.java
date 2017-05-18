package com.pizza.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pizza.service.OrderService;

@Component
public class OrderTrackSchedular {
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	OrderService orderService;

	@Scheduled(cron = "0/5 * * * * *")
	public void CallGetNewOrderCount(){
		int newOrderCount = orderService.getNewOrderCount();
		simpMessagingTemplate.convertAndSend("/topic/newOrders", newOrderCount);
	}
}
