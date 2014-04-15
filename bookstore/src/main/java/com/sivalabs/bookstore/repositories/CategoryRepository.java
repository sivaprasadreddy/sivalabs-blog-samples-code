/**
 * 
 */
package com.sivalabs.bookstore.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookstore.entities.Category;

/**
 * @author Siva
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Serializable>{

	
}
