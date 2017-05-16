package com.pizza.domain;

public class OrderDetailDomain {

	private int order_no;
	private int uid;
	private int pizza_price;
	
	public OrderDetailDomain(int order_no, int uid, int pizza_price){
		this.order_no = order_no;
		this.uid = uid;
		this.pizza_price = pizza_price;
	}

	public int getOrder_no() {
		return order_no;
	}

	public int getUid() {
		return uid;
	}

	public int getPizza_price() {
		return pizza_price;
	}
	
	
}
