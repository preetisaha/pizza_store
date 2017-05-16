package com.pizza.domain;

public class OrderDetailDomain {

	private int order_no;
	private int uid;
	private int pizza_price;
	private int status;
	private int eid;
	
	public OrderDetailDomain(int order_no, int uid, int pizza_price, int status, int eid){
		this.order_no = order_no;
		this.uid = uid;
		this.pizza_price = pizza_price;
		this.status = status;
		this.eid = eid;
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

	public int getStatus() {
		return status;
	}

	public int getEid() {
		return eid;
	}
	
	
}
