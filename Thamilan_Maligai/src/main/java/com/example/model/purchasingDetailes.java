package com.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Table
@Entity
public class purchasingDetailes implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String costomerName;
	private String mobile;
	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String products;
	private String totalPrice;
	private LocalDate date;
	private LocalTime time;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCostomerName() {
		return costomerName;
	}
	public void setCostomerName(String costomerName) {
		this.costomerName = costomerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProducts() {
		return products;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate currentDate) {
		this.date = currentDate;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime currentTime) {
		this.time = currentTime;
	}
	public purchasingDetailes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public purchasingDetailes(long id, String costomerName, String mobile, String products, String totalPrice,
			LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.costomerName = costomerName;
		this.mobile = mobile;
		this.products = products;
		this.totalPrice = totalPrice;
		this.date = date;
		this.time = time;
	}
	
	public void setProducts(String array) {
		this.products=array;		
	}
	
	


}
