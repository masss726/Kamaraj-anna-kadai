package com.example.MasilaMainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	 
	
	@GetMapping("/index")
	public String home() {	    
		return "home"; 
	}
	@GetMapping("/Purchasing")
	public String PurchasingPage() {
		return "Product_Selection";
		
	}
	
	@PostMapping("/Purchasing")
	public String PurchasingPagePost() {
		return "Product_Selection";
		
	}
	
	@PostMapping("/GoBilling")
	public String GoBilling() {
		return "billing";
		
	}
	
	@GetMapping("/addProducts")
	public String addProducts() {
		return "addProducts";
		
	}


	

}
