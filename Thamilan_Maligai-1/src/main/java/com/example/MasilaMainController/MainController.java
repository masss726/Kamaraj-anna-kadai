package com.example.MasilaMainController;

import java.math.BigInteger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.addProduct;
import com.example.repository.addProductRepo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@Service
public class MainController {
	
	
	 addProduct ap = new addProduct();
	@Autowired
    addProductRepo repo;  

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

    @PostMapping("/addingProducts")
    public String addingProducts(HttpServletRequest req, Model m) {
    	
        String P_Name = req.getParameter("productName");
        int P_Price = Integer.parseInt(req.getParameter("productPrice"));
        int P_Quantity = Integer.parseInt(req.getParameter("productQuantity"));
        String costomername=req.getParameter("customerName");
        String mobile1=req.getParameter("customerMobile");
        int mobile=Integer.parseInt(mobile1);
        System.out.println("name :" + P_Name + ", Price :" + P_Price + " , Quantity :" + P_Quantity);
        
        ap.setProductName(P_Name);
        ap.setPrice(P_Price);
        ap.setProductQty(P_Quantity);

        repo.save(ap);  // This will now work correctly
        ap = new addProduct();

        return "addSuccess";
    }

    @GetMapping("/productList")
    public String productList() {
        return "ProductList";
    }
}
