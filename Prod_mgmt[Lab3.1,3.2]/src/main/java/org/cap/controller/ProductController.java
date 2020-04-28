package org.cap.controller;

import java.util.List;


import org.cap.entities.*;
import org.cap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	private IProductService service;
    
    
    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("registerproduct");
    }
    
    @GetMapping("/processregister")
    public ModelAndView registerProduct(@RequestParam("id") int prodId, @RequestParam("name") String prodName, @RequestParam("price") double prodPrice) {
        Product product = new Product();
        product.setProductId(prodId);
        product.setProductName(prodName);
        product.setProductPrice(prodPrice);
        product=service.add(product);
        return new ModelAndView("details", "product", product);
    }
    
    
       
    
    @GetMapping("/displayall")
    public ModelAndView displayAllProducts(){
    	
        List<Product> products=service.fetchAll();
        ModelAndView modelAndView=new ModelAndView("allproducts","products",products);
        return modelAndView;
    }
}
