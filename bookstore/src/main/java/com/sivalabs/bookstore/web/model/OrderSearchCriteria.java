
package com.sivalabs.bookstore.web.model;

import com.sivalabs.bookstore.entities.Customer;
import com.sivalabs.bookstore.entities.OrderStatus;

/**
 * @author Siva
 *
 */
public class OrderSearchCriteria 
{
	private Customer customer;
	private OrderStatus orderStatus;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
