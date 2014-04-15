
package com.sivalabs.tweeter.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.bookstore.config.AppConfig;
import com.sivalabs.bookstore.entities.Category;
import com.sivalabs.bookstore.entities.Product;
import com.sivalabs.bookstore.services.CatalogService;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CatalogServiceTest {

	@Autowired
	private CatalogService catalogService;
	
	@Test
	public void getCategories() {
		System.out.println("============getCategories================");
		List<Category> categories = catalogService.findAllCategories();
		for (Category category : categories) {
			System.err.println(category);
		}
	}
	
	@Test
	public void getCategory() {
		System.out.println("============getCategory================");
		Integer catId = 1;
		Category category = catalogService.findCategoryById(catId);
		assertNotNull(category);
		System.err.println(category);
	}
	
	@Test
	public void getAllProducts() {
		System.out.println("============getAllProducts================");
		List<Product> products = catalogService.findAllProducts();
		assertNotNull(products);
		for (Product product : products) {
			System.err.println(product);
		}
		
	}
	
	@Test
	public void getProductsByCategory() {
		System.out.println("============getProductsByCategory================");
		Integer catId = 1;
		List<Product> products = catalogService.findProductsByCategory(catId);
		assertNotNull(products);
		for (Product product : products) {
			System.err.println(product);
		}
	}

	@Test
	public void getProduct() {
		System.out.println("============getProduct================");
		Integer productId = 1;
		Product product = catalogService.findProductById(productId);
		assertNotNull(product);
		System.err.println(product);
	}
	
}
