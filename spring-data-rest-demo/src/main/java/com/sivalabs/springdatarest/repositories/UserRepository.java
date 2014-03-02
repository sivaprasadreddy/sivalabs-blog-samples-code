package com.sivalabs.springdatarest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springdatarest.entities.User;

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
