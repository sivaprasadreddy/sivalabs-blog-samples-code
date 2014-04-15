package com.sivalabs.discuzz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.discuzz.entities.User;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	User findByUserName(String userName);

	User findByUserNameAndPassword(String userName, String password);

}
