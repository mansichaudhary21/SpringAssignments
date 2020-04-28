package org.cap.controller;

import org.cap.dto.ProductDTO;
import org.cap.entities.Product;
import org.cap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private IProductService service;

   
    @GetMapping("/register")
    public ResponseEntity<Product> registerProduct(@RequestBody ProductDTO productDto)
    {
    	Product product = convertFromDto(productDto);
    	product = service.add(product);
    	ResponseEntity<Product> response = new ResponseEntity<>(product,HttpStatus.OK);
    	return response;
    }
    
    public Product convertFromDto(ProductDTO dto)
    {
    	Product product = new Product();
    	product.setProductId(dto.getProductId());
    	product.setProductName(dto.getProductName());
    	product.setProductPrice(dto.getProductPrice());
    	return product;
    }
    
    @GetMapping
    public ResponseEntity<List<Product>> fetchAll(){
      List<Product>products =service.fetchAll();
      ResponseEntity<List<Product>>response=new ResponseEntity<>(products, HttpStatus.OK);
      return response;
    }

   

}
