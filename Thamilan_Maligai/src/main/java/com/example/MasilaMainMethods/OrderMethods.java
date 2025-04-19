package com.example.MasilaMainMethods;

import org.springframework.stereotype.Component;

import com.example.model.Products;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderMethods {
	
	public int calculateTotalPriceFromArray(Products products) {
	    int totalPrice = 0;
	    ObjectMapper mapper = new ObjectMapper();

	    if (products != null) {
	        for (String productJson : products) {
	            try {
	                Product product = mapper.readValue(productJson, Product.class);
	                totalPrice += product.getTotal();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return totalPrice;
	}


}
