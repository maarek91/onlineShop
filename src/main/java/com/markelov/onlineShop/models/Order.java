package com.markelov.onlineShop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ordr")
public class Order {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String price;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Order(String title, String price) {
		this.title = title;
		this.price = price;
	}
	
	public Order() {}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
}