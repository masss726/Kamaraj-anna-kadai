package com.example.model;

import java.io.Serializable;

import org.aspectj.lang.annotation.RequiredTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class addProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String productName;
    private double price;
    private int productQty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public addProduct(int id, String productName, double price, int productQty) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.productQty = productQty;
	}
	public addProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


}
