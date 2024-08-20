package com.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Customer;
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

	 
	 Optional<Customer> findByEmailid(String email);


}

