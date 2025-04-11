package com.example.MasilaMainController;

import java.math.BigInteger;
import java.util.List;

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
    public String PurchasingPage(Model model) {
    	try {
            List<addProduct> products = (List<addProduct>) repo.findAll();
            System.out.println("Fetched products: " + products);
            model.addAttribute("products", products);
        } catch (Exception e) {
            System.err.println("Error fetching products: " + e.getMessage());
            e.printStackTrace(); // helpful during development
        }

        return "Product_Selection";
    }

    @PostMapping("/Purchasing")
    public String showProductSelectionPage(Model model) {
        try {
            List<addProduct> products = (List<addProduct>) repo.findAll();
            System.out.println("Fetched products: " + products);
            model.addAttribute("products", products);
        } catch (Exception e) {
            System.err.println("Error fetching products: " + e.getMessage());
            e.printStackTrace(); // helpful during development
        }

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
    	//finished
    @PostMapping("/addingProducts")
    public String addingProducts(HttpServletRequest req, Model m) {    	
        String P_Name = req.getParameter("ProductName");
        int P_Price = Integer.parseInt(req.getParameter("price"));
        int P_Quantity = Integer.parseInt(req.getParameter("productQty"));
        System.out.println("name :" + P_Name + ", Price :" + P_Price + " , Quantity :" + P_Quantity);       
        ap.setProductName(P_Name);
        ap.setPrice(P_Price);
        ap.setProductQty(P_Quantity);
        repo.save(ap);  // This will now work correctly
        ap = new addProduct();
        return "addSuccess";
    }

    @GetMapping("/productList")
    public String productList(Model m) {
    List<addProduct> se=(List<addProduct>)repo.findAll();
    System.out.println(se);
    m.addAttribute("products", se); 
        return "ProductList";
    }
}
