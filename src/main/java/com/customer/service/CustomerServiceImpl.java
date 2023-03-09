package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerDAO;
import com.customer.entity.Customer;
import com.customer.exceptions.CustomerAlreadyExistsException;
import com.customer.exceptions.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
	private CustomerDAO customerDao;

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		if (customerDao.findById(customer.getCustomerId()).isEmpty()) {
		customerDao.save(customer);
		return customer;
		}
		else {
			throw new CustomerAlreadyExistsException();
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		
		if(customerDao.findById(customer.getCustomerId()).isEmpty()) {
			throw new CustomerNotFoundException();
		}
		else {
		customerDao.save(customer);
		return customer;
		}
		
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
		Customer c;
		if(customerDao.findById(customerId).isEmpty()) {
			throw new CustomerNotFoundException();
		}
		else {
			c=customerDao.findById(customerId).get();
		}
		return c;
	}

	@Override
	public void deleteCustomerById(Integer customerId) throws CustomerNotFoundException{
		if(customerDao.findById(customerId).isEmpty()) {
			throw new CustomerNotFoundException();
		}
		else {
		 customerDao.deleteById(customerId);
		}
		
	}
    

}

