package com.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFound(CustomerNotFoundException e) {
		return new ResponseEntity<>("Customer Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CustomerAlreadyExistsException.class)
	public ResponseEntity<String> customerAlreadyExists(CustomerAlreadyExistsException e) {
		return new ResponseEntity<>("Customer Already Exists", HttpStatus.FOUND);
	}
}

