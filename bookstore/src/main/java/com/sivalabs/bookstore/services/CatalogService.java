/**
 * 
 */
package com.sivalabs.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookstore.entities.Category;
import com.sivalabs.bookstore.entities.Product;
import com.sivalabs.bookstore.repositories.CategoryRepository;
import com.sivalabs.bookstore.repositories.ProductRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CatalogService {

	@Autowired private CategoryRepository categoryRepository;
	@Autowired private ProductRepository productRepository;
	
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category findCategoryById(int catId) {
		return categoryRepository.findOne(catId);
	}
	
	public Product findProductById(int productId) {
		return productRepository.findOne(productId);
	}
	
	public List<Product> searchProducts(String query) {
		//TODO;
		return productRepository.findAll();
	}
	
	public Category createCategory(Category c) {
		c.setId(0);
		return categoryRepository.saveAndFlush(c);
	}

	public Product createProduct(Product p) {
		p.setId(0);
		return productRepository.saveAndFlush(p);
	}
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> findProductsByCategory(Integer catId) {
		return productRepository.findByCategoryId(catId);
	}
}
