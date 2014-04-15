/**
 * 
 */
package com.sivalabs.phonebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService 
{
	@Autowired private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(int userId) {
		userRepository.delete(userId);
	}
	
	
}

