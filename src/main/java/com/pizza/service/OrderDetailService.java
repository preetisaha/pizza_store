package com.pizza.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pizza.dao.OrderDetailDao;
import com.pizza.domain.OrderDetailDomain;
import com.pizza.domain.OrderToppingDomain;


@Service
public class OrderDetailService {

	@Autowired
	OrderDetailDao orderDetailDao;

	
	public OrderDetailDomain saveOrderDetail(int uid, int pizza_price) {
		return orderDetailDao.saveOrderDetail(uid, pizza_price);
	}
	
	public void saveTopping(int order_no, List<Integer> toppingList){
		int i;
		for(i = 0; i < toppingList.size(); i++){
			Integer topping_id = toppingList.get(i);
			orderDetailDao.saveTopping(order_no, topping_id);
		}
	}
}
