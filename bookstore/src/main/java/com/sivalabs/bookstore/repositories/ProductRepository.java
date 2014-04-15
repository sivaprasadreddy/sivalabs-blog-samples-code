/**
 * 
 */
package com.sivalabs.bookstore.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookstore.entities.Product;

/**
 * @author Siva
 *
 */
public interface ProductRepository extends JpaRepository<Product, Serializable>{

	List<Product> findByCategoryId(Integer catId);

	
}
