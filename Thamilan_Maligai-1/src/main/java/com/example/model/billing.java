package com.example.model;

import java.io.Serializable;

public class billing implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public billing(int billingID, String costomerName, String mobileNo, String date, String time, int rate,
			int quantity) {
		super();
		BillingID = billingID;
		CostomerName = costomerName;
		MobileNo = mobileNo;
		Date = date;
		this.time = time;
		this.rate = rate;
		Quantity = quantity;
	}
	public int getBillingID() {
		return BillingID;
	}
	public billing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setBillingID(int billingID) {
		BillingID = billingID;
	}
	public String getCostomerName() {
		return CostomerName;
	}
	public void setCostomerName(String costomerName) {
		CostomerName = costomerName;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int BillingID;
	private String CostomerName;
	private String MobileNo;
	private String Date;
	private String time;
	private int rate;
	private int Quantity;
	
	

}
