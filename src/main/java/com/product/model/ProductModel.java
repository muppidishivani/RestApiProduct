package com.product.model;

import java.util.Map;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductModel {

	@NotBlank(message="Product name must be required")
	private String pname;
	@NotNull(message="product must be required")
	@Positive(message="Price must be greater than zero")
	private double price;
	@NotNull(message="Quantity must be required")
	@Min(value=1,message="product quantity should not be empty")
	private int quantity;
	@NotBlank(message="Product brand must be required")
	private String brand;
	@NotNull(message="Discountrate must be required")
	@Min(value=0, message="DiscountRate should not be negative")
	private double discountRate;
	@NotNull(message="TaxRate must be required")
	@Min(value=0, message="DiscountRate should not be negative")
	private double taxRate;
	
	private Map<String, String> productModel;

	public ProductModel() {
		super();
	}

	public ProductModel(String pname, double price, int quantity, String brand, double discountRate, double taxRate,
			Map<String, String> productModel) {
		super();
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.discountRate = discountRate;
		this.taxRate = taxRate;
		this.productModel = productModel;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public Map<String, String> getProductModel() {
		return productModel;
	}

	public void setProductModel(Map<String, String> productModel) {
		this.productModel = productModel;
	}

	@Override
	public String toString() {
		return "ProductModel [pname=" + pname + ", price=" + price + ", quantity=" + quantity + ", brand=" + brand
				+ ", discountRate=" + discountRate + ", taxRate=" + taxRate + ", productModel=" + productModel + "]";
	}
	
}