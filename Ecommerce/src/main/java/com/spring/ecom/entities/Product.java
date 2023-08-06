package com.spring.ecom.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

	@Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stockQuantity;
    
    @ManyToMany
    private List<Order> orders=new ArrayList<>();

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Product(Long productId, String productName, double price, int stockQuantity, List<Order> orders) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.orders = orders;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + ", orders=" + orders + "]";
	}
    
    

}