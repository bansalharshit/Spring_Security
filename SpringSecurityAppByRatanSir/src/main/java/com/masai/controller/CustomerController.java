package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Customer;
import com.masai.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer registerCustomer=customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(registerCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer/{email}")
	public ResponseEntity<Customer>getCustomerByEmailHandler(@PathVariable("email") String email){
		
		Customer customer=customerService.getCustomerDetailsByEmail(email);
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(){
		List<Customer> customers=customerService.getAllCustomerDetails();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
}
