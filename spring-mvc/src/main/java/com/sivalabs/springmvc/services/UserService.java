/**
 * 
 */
package com.sivalabs.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springmvc.entities.User;
import com.sivalabs.springmvc.repositories.UserRepository;
import com.sivalabs.springmvc.web.forms.ChangePwdForm;

/**
 * @author skatam
 *
 */
@Service
@Transactional
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers()
	{
		return this.userRepository.findAll();
	}

	public Integer createUser(User user) {
		return this.userRepository.save(user).getUserId();
	}

	public User login(User user) {
		Integer userId = this.userRepository.login(user.getUserName(), user.getPassword());
		if(userId != null){
			return this.userRepository.findOne(userId);
		}
		return null;
	}

	public Integer updateUser(User user) {
		return this.userRepository.save(user).getUserId();
	}

	public void changePassword(ChangePwdForm changePwdForm) {
		User user = this.userRepository.findOne(changePwdForm.getUserId());
		user.setPassword(changePwdForm.getNewPwd());
		this.userRepository.save(user);
	}

	public User findUser(Integer userId) {
		return this.userRepository.findOne(userId);
	}
}
