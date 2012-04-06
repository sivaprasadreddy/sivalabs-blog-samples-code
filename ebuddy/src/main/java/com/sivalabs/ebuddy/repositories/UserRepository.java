/**
 * 
 */
package com.sivalabs.ebuddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sivalabs.ebuddy.entities.User;

/**
 * @author skatam
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	@Query("select u from User u where u.userName=?1 and u.password=?2")
	User login(String userName, String password);

}
