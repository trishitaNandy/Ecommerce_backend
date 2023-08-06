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

import com.spring.ecom.entities.Customer;
import com.spring.ecom.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getCustomers(){
		return this.customerService.getCustomers();
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomer(@PathVariable String customerId) {
		return this.customerService.getCustomer(Long.parseLong(customerId));
	}
	//Add course
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
	}
	//Update course
	@PutMapping("/customer/{customerId}")
	public Customer updateLoad(@RequestBody Customer customer, @PathVariable String customerId) {
		return this.customerService.updateCustomer(customer, Long.parseLong(customerId));
	}
	
	//delete Course
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String customerId){
		try {
			this.customerService.deleteCustomer(Long.parseLong(customerId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
