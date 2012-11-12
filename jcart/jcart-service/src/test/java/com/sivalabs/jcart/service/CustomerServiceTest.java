package com.sivalabs.jcart.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.jcart.config.JCartServicesConfig;
import com.sivalabs.jcart.entities.Address;
import com.sivalabs.jcart.entities.Customer;
import com.sivalabs.jcart.entities.LineItem;
import com.sivalabs.jcart.entities.Order;
import com.sivalabs.jcart.entities.Product;
import com.sivalabs.jcart.services.CatalogService;
import com.sivalabs.jcart.services.CustomerService;
import com.sivalabs.jcart.services.OrderService;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JCartServicesConfig.class})
public class CustomerServiceTest
{
	@Autowired private CustomerService customerService;
	@Autowired private OrderService orderService;
	@Autowired private CatalogService catalogService;
	
	@Test
	@Ignore
	public void testCreateCustomer()
	{
		Customer customer = new Customer();
		Address address = new Address();
		address.setStreet("KPHB");
		address.setCity("Hyd");
		address.setState("AP");
		address.setCountry("INDIA");
		address.setZipCode("500072");
		
		customer.setAddress(address);
		customer.setEmailId("siva@gmail.com");
		customer.setFirstName("Siva");
		customer.setLastName("K");
		customer.setPhoneNumber("9000510456");
		
		customerService.createCustomer(customer);
	}
	
	@Test
	@Ignore
	public void testFindCustomers()
	{
		List<Customer> customers = customerService.findCustomers();
		for (Customer customer : customers)
		{
			System.out.println(customer);
		}
	}
	
	@Test
	@Ignore
	public void testCreateProduct()
	{
		Product book1 = new Product();
		book1.setProductName("HeadFirst Java");
		book1.setDescription("HeadFirst Java");
		book1.setAttribute("ISBN", "B001");
		book1.setAttribute("Author", "KathySierra");
		book1.setPrice(new BigDecimal(500.00));
		
		catalogService.createProduct(book1);
		
		Product book2 = new Product();
		book2.setProductName("HeadFirst Servlets & JSP");
		book2.setDescription("HeadFirst Servlets & JSP");
		book2.setAttribute("ISBN", "B002");
		book2.setAttribute("Author", "KathySierra, Bert Bates");
		book2.setPrice(new BigDecimal(550.00));
		
		catalogService.createProduct(book2);
		
	}
	
	@Test
	@Ignore
	public void testPlaceOrder()
	{
		Customer customer = new Customer();
		Address billingAddress = new Address();
		billingAddress.setStreet("KPHB");
		billingAddress.setCity("Hyd");
		billingAddress.setState("AP");
		billingAddress.setCountry("INDIA");
		billingAddress.setZipCode("500072");
		
		customer.setAddress(billingAddress);
		customer.setEmailId("siva@gmail.com");
		customer.setFirstName("Siva");
		customer.setLastName("K");
		customer.setPhoneNumber("9000510456");
		
		Customer receiver = new Customer();
		Address shippingAddress = new Address();
		shippingAddress.setStreet("Kukatpally");
		shippingAddress.setCity("Hyderabad");
		shippingAddress.setState("AP");
		shippingAddress.setCountry("INDIA");
		shippingAddress.setZipCode("500072");
		
		receiver.setAddress(shippingAddress);
		receiver.setEmailId("sivaprasadreddy@gmail.com");
		receiver.setFirstName("Siva Prasad Reddy");
		receiver.setLastName("K");
		receiver.setPhoneNumber("9000510456");
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setReceiver(receiver);
		order.setCreatedOn(new Date());
		order.setUpdatedOn(new Date());
		order.setStatus("NEW_ORDER");
		
		Set<LineItem> lineItems = new HashSet<LineItem>();
		LineItem linItem1 = new LineItem();
		linItem1.setOrder(order);
		Product book1 = new Product();
		book1.setProductId(1);
		linItem1.setProduct(book1);
		linItem1.setQuantity(2);
		lineItems.add(linItem1);
		
		LineItem linItem2 = new LineItem();
		linItem2.setOrder(order);
		Product book2 = new Product();
		book2.setProductId(2);
		linItem2.setProduct(book2);
		linItem2.setQuantity(3);
		lineItems.add(linItem2);
		
		order.setLineItems(lineItems );
		
		orderService.placeOrder(order);
	}
	
	
}
