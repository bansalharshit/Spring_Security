package com.masai.services;

import java.util.List;

import com.masai.entities.Customer;
import com.masai.exceptions.CustomerException;

public interface CustomerService {

	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;
}
