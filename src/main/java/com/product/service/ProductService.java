package com.product.service;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ProductIdNotFoundException;
import com.product.model.ProductModel;
import com.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	//post Data
	public Product productObject(ProductModel productModel)
	{
		double price=productModel.getPrice()*productModel.getQuantity();
		double discount=productModel.getPrice()*productModel.getDiscountRate()/100;
		double discountPrice=price-discount;
		double taxPrice=productModel.getTaxRate()/100;
		double finalPrice=discountPrice-taxPrice;
		
		Product product=new Product();
		product.setPname(productModel.getPname());
		product.setPrice(productModel.getPrice());
		product.setBrand(productModel.getBrand());
		product.setDiscountPrice(discountPrice);
		
		product.setDiscountRate(productModel.getDiscountRate());
		product.setQuantity(productModel.getQuantity());
		product.setTaxRate(productModel.getTaxRate());
		product.setTaxPrice(taxPrice);
		product.setFinalPrice(finalPrice);
		
		return repository.save(product);
	}
	
	//Get the List of Products
	public List<Product> getAllProducts()
	{
		List<Product> product=repository.findAll();
		return product;
	}
	
	public Product getOneProduct(int id)
	{
		boolean product=repository.existsById(id);
		
		if(product)
		{
			return repository.findById(id).get();
		}
		else
		{
		 throw new ProductIdNotFoundException("Product with ID"+ id+" Not Found");
		}
		
	}
	
	 public boolean deleteById(int id) 
	 {
	        if (repository.existsById(id))
	        {
	            repository.deleteById(id); 
	            return true;
	        }
	        return false;  
	    }
	 
	 
	 
	 public Product updateProduct(int id,ProductModel productModel)
	 {

	        if (repository.existsById(id))
	        {
	        	
	        Product product=repository.findById(id).get();
	        
		 
		 double price=productModel.getPrice()*productModel.getQuantity();
			double discount=productModel.getPrice()*productModel.getDiscountRate()/100;
			double discountPrice=price-discount;
			double taxPrice=productModel.getTaxRate()/100;
			double finalPrice=discountPrice-taxPrice;
			
			
			product.setPname(productModel.getPname());
			product.setPrice(productModel.getPrice());
			product.setBrand(productModel.getBrand());
			product.setDiscountPrice(discountPrice);
			
			product.setDiscountRate(productModel.getDiscountRate());
			product.setQuantity(productModel.getQuantity());
			product.setTaxRate(productModel.getTaxRate());
			product.setTaxPrice(taxPrice);
			product.setFinalPrice(finalPrice);
			
			return repository.save(product);
	        }
			return null;
		 
	 }
	 
	 public Product patchProducts(int id ,Map<String,String> productModel)
	 {
		 Optional<Product> existingProduct=repository.findById(id);
		 
		 if(existingProduct.isPresent())
		 {
			 Product product= existingProduct.get();
			 productModel.forEach((key,value)->{
				 
			 switch(key)
			 {
			 case "pname":
				 product.setPname(value);
				 break;
			 case "price":
				 product.setPrice(Double.valueOf(value));
				 double price=(Double.valueOf(value))*product.getQuantity();
				 double discount=(Double.valueOf(value))*product.getDiscountRate()/100;
					double discountPrice=(Double.valueOf(value))-discount;
					double taxPrice=product.getTaxRate()/100;
					double finalPrice=discountPrice-taxPrice;
					product.setDiscountPrice(discountPrice);
					product.setTaxPrice(taxPrice);
					product.setFinalPrice(finalPrice);
				    break;
			 case "discountRate":
				 
				product.setDiscountRate(Double.valueOf(value));
				double existingprice=product.getPrice();
				double taxrate=product.getTaxRate();
				
				double discount1=existingprice*(Double.valueOf(value))/100;
				double discountPrice1=existingprice-discount1;
				double tax=product.getTaxRate()/100;
				double finalPrice1=discountPrice1-tax;
				
				product.setDiscountPrice(discountPrice1);
				product.setFinalPrice(finalPrice1);
				
				break;
			 case "taxRate":
				 product.setTaxRate(Double.valueOf(value));
				 double price1=product.getPrice();
				 double discountPrice2=product.getDiscountPrice();
				 double finalprice2=discountPrice2-(Double.valueOf(value));
				 
				 product.setFinalPrice(finalprice2);
				 break;
			 case "quantity":
				 product.setQuantity(Integer.valueOf(value));
				 double price3=product.getPrice()*(Integer.valueOf(value));
					
					double discountPrice4=price3-product.getDiscountPrice();
				
					double finalPrice3=discountPrice4-product.getTaxPrice();
					
				product.setDiscountPrice(discountPrice4);
				product.setFinalPrice(finalPrice3);
				break;
			 case "brand":
				 product.setBrand(value);
				 break;
				 
				 
			 }
		 
	 });
			 return repository.save(product);
	 }
		return null;
		
	 }
}
