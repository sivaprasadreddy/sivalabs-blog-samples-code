/**
 * 
 */
package com.sivalabs.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sivalabs.springmvc.entities.User;

/**
 * @author skatam
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("select u.userId from User u where u.userName=?1 and u.password=?2")
	Integer login(String userName, String password);
	
	//@Query("update User u set u.password=?2 where u.userId=?1")
	//void changePassword(Integer userId, String newPwd);
}
