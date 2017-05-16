package com.pizza.domain;

public class OrderToppingDomain {

	private int order_no;
	private int topping_id;
	
	public OrderToppingDomain(int order_no, int topping_id){
		this.order_no = order_no;
		this.topping_id = topping_id;
	}

	public int getOrder_no() {
		return order_no;
	}

	public int getTopping_id() {
		return topping_id;
	}
}
