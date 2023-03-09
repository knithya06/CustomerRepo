package com.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {

}

