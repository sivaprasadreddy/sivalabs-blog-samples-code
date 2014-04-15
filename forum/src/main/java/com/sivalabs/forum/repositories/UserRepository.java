package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sivalabs.forum.entities.User;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	@Query("select u from User u where u.email=?1 and u.password=?2")
	User login(String email, String password);
	
	@Query("update User set password=?3 where email=?1 and password=?2")
	@Modifying
	void changePwd(String email, String oldPwd, String newPwd);

}
