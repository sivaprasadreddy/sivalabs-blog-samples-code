/**
 * 
 */
package com.sivalabs.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springmvc.model.User;
import com.sivalabs.springmvc.repositories.UserRepository;

/**
 * @author siva
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void delete(Long id) {
		userRepository.delete(id);
	}

	public void update(User user) {
		userRepository.save(user);
	}

	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	public void save(User user) {
		userRepository.save(user);
		
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public List<User> searchUsers(String name) {
		return userRepository.searchUsers(name+"%");
	}

}
