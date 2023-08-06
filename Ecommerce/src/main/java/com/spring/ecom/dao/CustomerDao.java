package com.spring.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ecom.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer,Long> {

}
