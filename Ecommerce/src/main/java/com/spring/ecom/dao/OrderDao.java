package com.spring.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ecom.entities.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}
