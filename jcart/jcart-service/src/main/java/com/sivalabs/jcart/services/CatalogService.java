package com.sivalabs.jcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.jcart.entities.Product;
import com.sivalabs.jcart.repositories.CatalogRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CatalogService
{
	@Autowired private CatalogRepository catalogRepository;
	
	public void createProduct(Product product)
	{
		catalogRepository.createProduct(product);
	}
}
