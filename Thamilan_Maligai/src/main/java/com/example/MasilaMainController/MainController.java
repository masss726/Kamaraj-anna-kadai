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

//import com.example.MasilaMainMethods.WhatsappSender;
import com.example.model.Products;
import com.example.model.addProduct;
import com.example.model.purchasingDetailes;
import com.example.repository.addProductRepo;
import com.example.repository.purchaseProductsRepo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@Service
public class MainController {
	
	//WhatsappSender sender=new WhatsappSender();
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
    	
    	List<purchasingDetailes> history=PRepo.findAll();
    	System.out.println(history);
    	M.addAttribute("history", history);
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
    public String GoBilling(HttpServletRequest req,Model m) {
        
        String costomerName =req.getParameter("customerName");
    	if(costomerName!=null) {
    		 String Mobile=req.getParameter("customerMobile");
    	        String Items=req.getParameter("cartItems");
    	        //***************************************************
    	      //total price calculating
    	        System.out.println("\n Slicing************************** Step1  \n");  	        
    	        String[] array = Items.split("}");
    	        int ite=array.length-1;
    	        int i;
    	        for(i=0;i<=ite;i++) {
    	        	System.out.println("items price :"+array[i]);
    	        } 
    	        System.out.println("GetLastIndex**************************** after(:)");
    	        
    	        String a=":";
    	        //total amount
    	        int amount=0 ;
    	        int h;
    	        for(h=0;h<=ite-1;h++) {
    	        	
    	        	 int index =array[h].lastIndexOf(a);
    	    	        String ItemAmount = array[h].substring(index);
    	    	        String ans1= ItemAmount.replace(":", "0");
    	    	        int ans=Integer.parseInt(ans1);
    	    	       amount= amount+ans;
    	    	        System.out.println("Item amount :"+ans1);
    	        }
    	      
    	        System.out.println("\n ************************** Total amount is :"+amount+"\n");
    	        
    	        
    	        LocalDate currentDate = LocalDate.now();
    	        LocalTime currentTime = LocalTime.now();
    	        purchase.setCostomerName(costomerName);
    	        purchase.setMobile(Mobile);
    	        purchase.setProducts(Items);
    	        purchase.setDate(currentDate);
    	        purchase.setTime(currentTime);
    
    	        //total price calculating
    	        String str = String.valueOf(amount);
    	        purchase.setTotalPrice(str);
    	        PRepo.save(purchase);
    	        purchase =new purchasingDetailes();
    	        
    	        try {
					//sender.sendMessage("917708838008", "hi this is masila");
					System.out.println("Sended");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("problem for Whatspp message sender");
				}
    	}
    	//new option
    	List<addProduct> products = repo.findAll();
        m.addAttribute("products", products);        
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
