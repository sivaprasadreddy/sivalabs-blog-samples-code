/**
 * 
 */
package com.sivalabs.springmvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sivalabs.springmvc.model.User;

/**
 * @author siva
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.firstname like :name or u.lastname like :name")
	List<User> searchUsers(@Param("name") String name);

}
