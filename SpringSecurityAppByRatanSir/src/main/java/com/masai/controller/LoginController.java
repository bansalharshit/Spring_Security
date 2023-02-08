package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Customer;
import com.masai.repositories.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
	// here this authentication holds the principal objects which has the details of user like username and password
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		System.out.println(auth);
		Customer customer=customerRepository.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException(""));
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
}
