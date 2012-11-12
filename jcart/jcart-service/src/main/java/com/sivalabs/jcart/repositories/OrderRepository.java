package com.sivalabs.jcart.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sivalabs.jcart.entities.Order;

/**
 * @author Siva
 *
 */
@Repository
public class OrderRepository
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveOrder(Order order)
	{
		entityManager.merge(order);
	}
	
}
