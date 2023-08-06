package com.spring.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ecom.dao.OrderDao;
import com.spring.ecom.entities.Order;
import com.spring.ecom.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> getOrders() {
		return orderDao.findAll();
	}

	@Override
	public Order getOrder(Long orderId) {
		return orderDao.findById(orderId).get();
	}

	@Override
	public Order addOrder(Order order) {
		orderDao.save(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order, Long orderId) {
		Order existingOrder=orderDao.findById(orderId).orElse(null);
		
		if(existingOrder!=null) {
			existingOrder.setProductList(order.getProductList());
			existingOrder.setOrderDate(order.getOrderDate());
			
			
			orderDao.save(existingOrder);
		}
		return existingOrder;
	}

	@Override
	public void deleteOrder(Long orderId) {
		Order order=orderDao.findById(orderId).get();
		orderDao.delete(order);
		
	}

}
