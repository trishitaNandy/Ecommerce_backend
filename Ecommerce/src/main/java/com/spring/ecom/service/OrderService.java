package com.spring.ecom.service;

import java.util.List;

import com.spring.ecom.entities.Order;

public interface OrderService {

	public List<Order> getOrders();
	
	public Order getOrder(Long orderId);
	
	public Order addOrder(Order order);
	
	public Order updateOrder(Order order, Long orderId);
	
	public void deleteOrder(Long orderId);
}
