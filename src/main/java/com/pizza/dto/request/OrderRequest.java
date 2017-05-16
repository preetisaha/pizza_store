package com.pizza.dto.request;

import java.util.List;

public class OrderRequest {
	int uid;
	int pizza_price;
	List<Integer> toppingIdList;
	
	public int getUid() {
		return uid;
	}
	public int getPizza_price() {
		return pizza_price;
	}
	public List<Integer> getToppingIdList() {
		return toppingIdList;
	}
	
	
}
