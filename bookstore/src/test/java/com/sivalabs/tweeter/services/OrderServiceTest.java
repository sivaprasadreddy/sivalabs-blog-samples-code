
package com.sivalabs.tweeter.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.bookstore.config.AppConfig;
import com.sivalabs.bookstore.entities.Address;
import com.sivalabs.bookstore.entities.Customer;
import com.sivalabs.bookstore.entities.Order;
import com.sivalabs.bookstore.entities.OrderItem;
import com.sivalabs.bookstore.entities.OrderStatus;
import com.sivalabs.bookstore.entities.Payment;
import com.sivalabs.bookstore.services.CatalogService;
import com.sivalabs.bookstore.services.OrderService;
import com.sivalabs.bookstore.web.model.OrderSearchCriteria;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class OrderServiceTest {

	@Autowired private CatalogService catalogService;
	@Autowired private OrderService orderService;
	
	@Test
	public void createOrder() {
		System.out.println("============================");
		Order order = new Order();
		
		Customer customer = new Customer();
		customer.setFirstName("Siva");
		customer.setLastName("K");
		customer.setEmail("siva@gmail.com");
		customer.setPassword("siva");
		customer.setPhone("90000510456");
		
		Address shippingAddress = new Address();
		shippingAddress.setAddrLine1("KP");
		shippingAddress.setAddrLine2("BalajiNagar");
		shippingAddress.setCity("Hyd");
		shippingAddress.setState("AP");
		shippingAddress.setCountry("India");
		shippingAddress.setZipCode("500072");
		
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		OrderItem item1 = new OrderItem();
		item1.setProduct(catalogService.findProductById(1));
		item1.setQuantity(1);
		//item1.setOrder(order);
		
		
		OrderItem item2 = new OrderItem();
		item2.setProduct(catalogService.findProductById(2));
		item2.setQuantity(2);
		//item2.setOrder(order);
		
		orderItems.add(item1);
		orderItems.add(item2);
		
		Payment payment = new Payment();
		payment.setCreditCardNumber("123-456-789");
		payment.setCvv("123");
		payment.setExpiryDate(new Date());
		
		
		order.setCustomer(customer);
		order.setShippingAddress(shippingAddress);
		order.setOrderItems(orderItems);
		order.setPayment(payment );
		order.setStatus(OrderStatus.VALIDATED);
		
		Order createdOrder = orderService.createOrder(order);
		assertNotNull(createdOrder);
	}
	
	@Test
	public void cancelOrder()
	{
		Order o = orderService.findOrderById(1);
		assertNotNull(o);
		orderService.cancelOrder(o.getId());
		o = orderService.findOrderById(1);
		assertEquals(OrderStatus.CANCELLED, o.getStatus());
	}
	
	@Test
	public void updateOrderStatus()
	{
		Order o = orderService.findOrderById(1);
		assertNotNull(o);
		orderService.updateOrderStatus(o.getId(), OrderStatus.ERROR);
		o = orderService.findOrderById(1);
		assertEquals(OrderStatus.ERROR, o.getStatus());
	}
	
	@Test
	public void findOrder()
	{
		Order o = orderService.findOrderById(1);
		assertNotNull(o);
	}
	
		
	@Test
	public void findOrders()
	{
		System.out.println("===============findOrders========================");
		Integer custId = 5;
		OrderStatus orderStatus = OrderStatus.VALIDATED;
		
		OrderSearchCriteria searchCriteria = new OrderSearchCriteria();
		searchCriteria.setCustomer(new Customer(custId));
		searchCriteria.setOrderStatus(orderStatus);
		
		List<Order> orders = orderService.findOrders(searchCriteria);
		assertNotNull(orders);
		System.err.println(orders);
		for (Order order : orders) {
			System.err.println(order);
		}
	}
}
