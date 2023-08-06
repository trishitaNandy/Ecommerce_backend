package com.spring.ecom.service;

import java.util.List;

import com.spring.ecom.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(Long customerId);
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer, Long customerId);
	
	public void deleteCustomer(Long customerId);
}
