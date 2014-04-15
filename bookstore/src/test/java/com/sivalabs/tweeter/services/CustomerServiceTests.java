package com.sivalabs.tweeter.services;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.bookstore.config.AppConfig;
import com.sivalabs.bookstore.entities.Customer;
import com.sivalabs.bookstore.services.CustomerService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CustomerServiceTests {

	@Autowired
	private CustomerService customerService;
	
	@Test
	public void createCustomer() 
	{
		System.out.println("============createCustomer================");
		Customer customer = new Customer();
		customer.setFirstName("Test");
		customer.setLastName(null);
		customer.setEmail("test@gmail.com");
		customer.setPassword("test");
		customer.setPhone("9000510456");
		
		Customer c = customerService.createCustomer(customer);
		customer = customerService.findCustomerById(c.getId());
		assertNotNull(c);;
		System.err.println(c);
	}
	
	@Test
	public void login() 
	{
		System.out.println("============login================");
		Customer customer = customerService.login("sivaprasadreddy.k@gmail.com", "siva");
		assertNotNull(customer);
		System.err.println(customer);
	}
	
	@Test
	public void findCustomer() 
	{
		System.out.println("============findCustomer================");
		Customer customer = customerService.findCustomerById(1);
		assertNotNull(customer);
		System.err.println(customer);
	}

	@Test
	public void updateCustomer() 
	{
		System.out.println("============updateCustomer================");
		Customer customer = customerService.findCustomerById(1);
		assertNotNull(customer);
		customer.setFirstName(customer.getFirstName()+"_"+System.currentTimeMillis());
		customer.setLastName(customer.getLastName()+"_"+System.currentTimeMillis());
		customerService.updateCustomer(customer);
		customer = customerService.findCustomerById(1);
		System.err.println(customer);
	}

}
