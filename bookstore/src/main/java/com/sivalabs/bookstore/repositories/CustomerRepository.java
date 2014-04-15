/**
 * 
 */
package com.sivalabs.bookstore.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookstore.entities.Customer;

/**
 * @author Siva
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Serializable>{

	Customer findByEmailAndPassword(String email, String password);

	Customer findByEmail(String email);

	
}
