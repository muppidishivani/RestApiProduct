package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String pname;
	private double price;
	private int quantity;
	private String brand;
	private double discountPrice;
	private double discountRate;
	private double taxRate;
	private double taxPrice;
	private double finalPrice;
	public Product() {
		super();
	}
	public Product(int id, String pname, double price, int quantity, String brand, double discountPrice,
			double discountRate, double taxRate, double taxPrice, double finalPrice) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.discountPrice = discountPrice;
		this.discountRate = discountRate;
		this.taxRate = taxRate;
		this.taxPrice = taxPrice;
		this.finalPrice = finalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
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
	public double getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + ", brand="
				+ brand + ", discountPrice=" + discountPrice + ", discountRate=" + discountRate + ", taxRate=" + taxRate
				+ ", taxPrice=" + taxPrice + ", finalPrice=" + finalPrice + "]";
	}
}
