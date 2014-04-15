/**
 * 
 */
package com.sivalabs.bookstore.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookstore.entities.Customer;
import com.sivalabs.bookstore.repositories.CustomerRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer findCustomerById(Integer custId) {
		return customerRepository.findOne(custId);
	}
	
	public Customer login(String email, String password) {
		return customerRepository.findByEmailAndPassword(email, password);
	}
	
	public Customer findCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	public void updateCustomer(Customer customer) 
	{
		Customer c = findCustomerById(customer.getId());
		if(c != null)
		{
			customer.setUpdatedOn(new Date());
			customerRepository.save(customer);
		}
	}
}
