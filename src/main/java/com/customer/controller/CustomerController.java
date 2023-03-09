package com.customer.controller;

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

import com.customer.entity.Customer;
import com.customer.exceptions.CustomerAlreadyExistsException;
import com.customer.exceptions.CustomerNotFoundException;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
    
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return this.customerService.getAllCustomer();
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) throws CustomerNotFoundException{
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException{
		 this.customerService.addCustomer(customer);
		 return new ResponseEntity<>("Customer Added Successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException{
		 this.customerService.updateCustomer(customer);
		 return new ResponseEntity<>("Customer Updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Integer customerId) throws CustomerNotFoundException {
		customerService.deleteCustomerById(customerId);
		return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
	}
}
