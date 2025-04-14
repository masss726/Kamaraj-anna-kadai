package com.example.MasilaMainController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.addProduct;
import com.example.model.purchasingDetailes;
import com.example.repository.addProductRepo;
import com.example.repository.purchaseProductsRepo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@Service
public class MainController {
	
	
	 addProduct ap = new addProduct();
	@Autowired
    addProductRepo repo;  
	@Autowired
	purchaseProductsRepo PRepo;
	
	purchasingDetailes purchase=new purchasingDetailes();

    @GetMapping("/index")
    public String home() {
        return "home";
    }
    
    @GetMapping("/billHistory")
    public String billHistory(Model M) {
    	return "purchaseHistory";
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
    
    //Allmost finished
    @PostMapping("/GoBilling")
    public String GoBilling(HttpServletRequest req) {
        
        String costomerName =req.getParameter("customerName");
    	if(costomerName!=null) {
    		 String Mobile=req.getParameter("customerMobile");
    	        String Items=req.getParameter("cartItems");
    	        //***************************************************
    	        String[] array = Items.split("}");
    	        int ite=array.length-1;
    	        int i;
    	        for(i=0;i<=ite;i++) {
    	        	System.out.println(array[i]);
    	        } 	        																																			        
    	        LocalDate currentDate = LocalDate.now();
    	        LocalTime currentTime = LocalTime.now();
    	        String a=":";
    	        String array1 = array[1].replace(a, "|");
    	        System.out.println("Cart Items Length :"+array1);
    	        purchase.setCostomerName(costomerName);
    	        purchase.setMobile(Mobile);
    	        purchase.setProducts(array);
    	        purchase.setDate(currentDate);
    	        purchase.setTime(currentTime);
    	        purchase.setTotalPrice("1000");
    	        PRepo.save(purchase);
    	        purchase =new purchasingDetailes();
    	}
       
        return "Product_Selection";
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
