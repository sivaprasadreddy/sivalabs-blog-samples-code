/**
 * 
 */
package com.sivalabs.bookstore.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookstore.entities.Order;
import com.sivalabs.bookstore.entities.OrderStatus;
import com.sivalabs.bookstore.repositories.OrderRepository;
import com.sivalabs.bookstore.web.model.OrderSearchCriteria;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class OrderService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired private OrderRepository orderRepository;
	
	public Order createOrder(Order order) {
		order.setStatus(OrderStatus.NEW);
		Order createdOrder = orderRepository.save(order);
		logger.debug("Order created successfully");
		return createdOrder;
	}
	
	public void cancelOrder(int orderId) {
		updateOrderStatus(orderId, OrderStatus.CANCELLED);
	}
	
	public List<Order> findCustomerOrders(Integer custId) {
		return orderRepository.findByCustomerId(custId);
	}
	
	public Order findOrderById(Integer orderId) {
		return orderRepository.findOne(orderId);
	}
	
	public void updateOrderStatus(int orderId, OrderStatus status) {
		Order order = orderRepository.findOne(orderId);
		if(order != null)
		{
			order.setStatus(status);
		}
	}
	
	public List<Order> findOrders(OrderSearchCriteria searchCriteria) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> c = cb.createQuery(Order.class);
		Root<Order> order = c.from(Order.class);
		c = c.select(order);
		if(searchCriteria.getOrderStatus() != null)
		{
			c.where(cb.equal(order.get("status"), searchCriteria.getOrderStatus()));
		}
		if(searchCriteria.getCustomer() != null)
		{
			c.where(cb.equal(order.get("customer"), searchCriteria.getCustomer()));
		}
		TypedQuery<Order> q = em.createQuery(c);
		return q.getResultList();
	}
}
