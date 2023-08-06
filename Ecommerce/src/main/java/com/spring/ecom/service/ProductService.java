package com.spring.ecom.service;

import java.util.List;

import com.spring.ecom.entities.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	
	public Product getProduct(Long productId);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product, Long productId);
	
	public void deleteProduct(Long productId);
}
