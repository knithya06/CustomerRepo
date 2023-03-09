package com.customer.service;
import java.util.List;

import com.customer.entity.Customer;
import com.customer.exceptions.CustomerAlreadyExistsException;
import com.customer.exceptions.CustomerNotFoundException;

public interface CustomerService {
	
	public List<Customer> getAllCustomer();

	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException;

	public void deleteCustomerById(Integer customerId) throws CustomerNotFoundException;
}

