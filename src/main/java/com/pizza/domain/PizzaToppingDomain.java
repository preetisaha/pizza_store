package com.pizza.domain;

public class PizzaToppingDomain {

	private int id;
	private String topping;
	private int price;
	private String image;
	
	public PizzaToppingDomain (int id, String topping, int price, String image){
		this.id = id;
		this.topping = topping;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getTopping() {
		return topping;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}
	
	
}
