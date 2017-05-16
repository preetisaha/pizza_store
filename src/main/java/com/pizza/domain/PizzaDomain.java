package com.pizza.domain;

public class PizzaDomain {

	private int id;
	private int size;
	private int price;
	
	public PizzaDomain(int id, int size, int price){
		this.id = id;
		this.size = size;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public int getPrice() {
		return price;
	}
}
