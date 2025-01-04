package com.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.model.ProductModel;
import com.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	
	 @PostMapping("/save")
	 public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductModel productModel) {
	        
	       
	        Product product = service.productObject(productModel);
	        System.out.println("this is product application");
	     
	        return ResponseEntity
	                .status(HttpStatus.CREATED) 
	                .header( "Data saved successfully") 
	                .body(product);  
	    }
	 
	 @GetMapping("/getAllProducts")
	 public ResponseEntity<List<Product>> getProducts() 
	 {
	        
	      
	        List<Product> products = service.getAllProducts();
	        
	     
	        return new ResponseEntity<>(products, HttpStatus.OK); 
	    }
	 @GetMapping("/get/{id}")
	 public ResponseEntity<Product> getProduct(@PathVariable("id") int id)
	 {
		 Product product=service.getOneProduct(id);
		 return new ResponseEntity<>(product, HttpStatus.OK); 
	 }
	 
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteOneProduct(@PathVariable("id") int id) {
	    
	        boolean isDeleted = service.deleteById(id);

	        if (isDeleted) {
	           
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else 
	        {
	           
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	 public ResponseEntity<Product> updateProducts(@PathVariable("id") int id,@RequestBody ProductModel productModel)
	 {
		 Product savedProduct=service.updateProduct(id, productModel);
		  if (savedProduct!=null) {
	           
	            return new ResponseEntity<>(savedProduct,HttpStatus.OK);
	        }
	        else 
	        {
	           
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 }
	 
	 @PatchMapping("/patch/{id}")
	    public ResponseEntity<Product> partialUpdateProduct(
	            @PathVariable("id") int id, 
	            @RequestBody Map<String, String> productModel) {

	      
	        Product updatedProduct = service.patchProducts(id, productModel);

	        if (updatedProduct != null) {
	            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);  
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
	        }
	    }
}
  
