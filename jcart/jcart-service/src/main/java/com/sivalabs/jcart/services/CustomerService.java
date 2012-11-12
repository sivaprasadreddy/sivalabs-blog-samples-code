package com.sivalabs.jcart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.jcart.entities.Customer;
import com.sivalabs.jcart.repositories.CustomerRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CustomerService
{
	@Autowired private CustomerRepository customerRepository;
	
	public void createCustomer(Customer customer)
	{
		customerRepository.createCustomer(customer);
	}
	
	public List<Customer> findCustomers()
	{
		return customerRepository.findCustomers();
	}
}
