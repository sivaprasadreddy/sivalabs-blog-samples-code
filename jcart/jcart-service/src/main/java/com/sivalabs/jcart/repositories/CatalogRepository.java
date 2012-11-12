package com.sivalabs.jcart.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sivalabs.jcart.entities.Product;

/**
 * @author Siva
 *
 */
@Repository
public class CatalogRepository
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void createProduct(Product product)
	{
		entityManager.merge(product);
	}
}
