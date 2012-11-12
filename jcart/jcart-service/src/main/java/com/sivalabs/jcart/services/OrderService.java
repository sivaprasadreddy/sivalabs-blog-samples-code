package com.sivalabs.jcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.jcart.entities.Order;
import com.sivalabs.jcart.repositories.OrderRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class OrderService
{
	@Autowired private OrderRepository orderRepository;
	
	public void placeOrder(Order order)
	{
		orderRepository.saveOrder(order);
	}
}
