package com.sivalabs.jcart.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sivalabs.jcart.entities.Customer;

/**
 * @author Siva
 *
 */
@Repository
public class CustomerRepository
{
	@PersistenceContext 
	private EntityManager entityManager;
	
	public Customer	createCustomer(Customer customer)
	{
		return entityManager.merge(customer);
	}
	
	public List<Customer> findCustomers()
	{
		return entityManager.createQuery("from Customer", Customer.class).getResultList();
	}
}
