package com.spring.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ecom.dao.CustomerDao;
import com.spring.ecom.entities.Customer;
import com.spring.ecom.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomer(Long customerId) {
		return customerDao.findById(customerId).get();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer, Long customerId) {
		Customer existingCustomer = customerDao.findById(customerId).orElse(null);
		
		if(existingCustomer!=null) {
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setAddress(customer.getAddress());
			existingCustomer.setPhoneNumber(customer.getPhoneNumber());
			
			customerDao.save(existingCustomer);
		}
		return existingCustomer;
	}

	@Override
	public void deleteCustomer(Long customerId) {
		Customer customer= customerDao.findById(customerId).get();
		customerDao.delete(customer);
		
	}

}
