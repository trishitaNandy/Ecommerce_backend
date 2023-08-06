package com.spring.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ecom.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

}
