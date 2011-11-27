/**
 * 
 */
package com.sivalabs.contacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author siva
 *
 */
public interface ContactsRepository extends JpaRepository<Contact, Integer>{

	List<Contact> findByName(String name);

}
