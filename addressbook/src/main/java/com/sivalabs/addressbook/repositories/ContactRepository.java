/**
 * 
 */
package com.sivalabs.addressbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sivalabs.addressbook.model.Contact;

/**
 * @author siva
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Long>{

	//@Query("select * from contact where firstname like ?1 or lastname like ?2")
	//public List<Contact> findByFirstnameLikeOrLastnameLike(String firstname, String lastname);
	
	@Query("select c from Contact c where c.firstname like :firstname or c.lastname like :lastname")
	List<Contact> findByFirstnameOrLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
}
