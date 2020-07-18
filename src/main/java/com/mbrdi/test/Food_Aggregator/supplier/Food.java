package com.mbrdi.test.Food_Aggregator.supplier;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Food implements Serializable{
	
	@JsonProperty("name")
	@JsonAlias({"productName","itemName"})
	private String name;
	
	@JsonProperty("id")
	@JsonAlias({"productId","itemId"})
	private String id;
	
	private String price;
	private int quantity;
	
	
	public Food() {
		
	}
	public Food(String name, String price, int quantity, String id) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
