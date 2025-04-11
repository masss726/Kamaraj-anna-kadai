package com.example.model;

import java.io.Serializable;
import java.math.BigInteger;

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
	private BigInteger mobile;
	private String CostomerName;
	
	

}
