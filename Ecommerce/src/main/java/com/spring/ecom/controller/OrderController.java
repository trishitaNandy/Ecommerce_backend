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

import com.spring.ecom.entities.Order;
import com.spring.ecom.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/order")
	public List<Order> getOrder(){
		return this.orderService.getOrders();
	}
	
	@GetMapping("/order/{orderId}")
	public Order getOrder(@PathVariable String orderId) {
		return this.orderService.getOrder(Long.parseLong(orderId));
	}
	//Add course
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return this.orderService.addOrder(order);
	}
	//Update course
	@PutMapping("/order/{orderId}")
	public Order updateOrder(@RequestBody Order order, @PathVariable String orderId) {
		return this.orderService.updateOrder(order, Long.parseLong(orderId));
	}
	
	//delete Course
	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String orderId){
		try {
			this.orderService.deleteOrder(Long.parseLong(orderId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
