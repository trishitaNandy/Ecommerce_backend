package com.spring.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ecom.entities.Product;
import com.spring.ecom.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public List<Product> getProduct(){
		return this.productService.getProducts();
	}
	
	@GetMapping("/product/{productId}")
	public Product getCustomer(@PathVariable String productId) {
		return this.productService.getProduct(Long.parseLong(productId));
	}
	//Add course
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return this.productService.addProduct(product);
	}
	//Update course
	@PutMapping("/product/{productId}")
	public Product updateProduct(@RequestBody Product product, @PathVariable String productId) {
		return this.productService.updateProduct(product, Long.parseLong(productId));
	}
	
	//delete Course
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId){
		try {
			this.productService.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
