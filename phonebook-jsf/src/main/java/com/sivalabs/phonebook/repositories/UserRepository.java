package com.sivalabs.phonebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.phonebook.entities.User;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

}
