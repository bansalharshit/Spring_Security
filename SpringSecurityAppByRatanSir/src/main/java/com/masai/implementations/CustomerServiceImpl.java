package com.masai.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Customer;
import com.masai.exceptions.CustomerException;
import com.masai.repositories.CustomerRepository;
import com.masai.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		return customerRepository.findByEmail(email).orElseThrow(()->new CustomerException("Customer Not Found With The Email"));
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		List<Customer> customer=customerRepository.findAll();
		if(customer.isEmpty())
			throw new CustomerException("No Customer Found inside the database");
		return customer;
	}
	
}
