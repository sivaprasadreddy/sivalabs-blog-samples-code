/**
 * 
 */
package com.sivalabs.bookstore.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookstore.entities.Order;

/**
 * @author Siva
 *
 */
public interface OrderRepository extends JpaRepository<Order, Serializable>{

	List<Order> findByCustomerId(Integer custId);
	
}
