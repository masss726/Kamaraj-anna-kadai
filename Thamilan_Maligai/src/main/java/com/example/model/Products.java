package com.example.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Products implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ProCount;
	private String product_Name;
	private int price;
	private String CustomerName;
	private int CustumerMobile;
	public Products(int proCount, String product_Name, int price, String customerName, int custumerMobile) {
		super();
		ProCount = proCount;
		this.product_Name = product_Name;
		this.price = price;
		CustomerName = customerName;
		CustumerMobile = custumerMobile;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProCount() {
		return ProCount;
	}
	public void setProCount(int proCount) {
		ProCount = proCount;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public int getCustumerMobile() {
		return CustumerMobile;
	}
	public void setCustumerMobile(int custumerMobile) {
		CustumerMobile = custumerMobile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
