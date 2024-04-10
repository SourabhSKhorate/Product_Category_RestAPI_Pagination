package com.nimap.java.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String product;
	private double price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonBackReference
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@JsonIgnore
	public Category getCategory() {
		return category;
	}

	@JsonProperty
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
