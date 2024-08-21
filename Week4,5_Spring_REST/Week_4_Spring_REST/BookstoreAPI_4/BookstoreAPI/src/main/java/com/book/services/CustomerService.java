package com.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Customer;
import com.book.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

		@Autowired
		CustomerRepository customerRepository;
		 
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}

public List<Customer> getAllCustomer()
{
	return customerRepository.findAll();
}
}

