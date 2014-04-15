package com.sivalabs.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.User;
import com.sivalabs.forum.models.ChangePasswordBean;
import com.sivalabs.forum.repositories.RoleRepository;
import com.sivalabs.forum.repositories.UserRepository;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public void createUser(User user)
	{
		if(checkEmailExists(user.getEmail())){
			throw new RuntimeException("Email ["+user.getEmail()+"] already exist");
		}
		userRepository.save(user);
	}
	
	public void updateUser(User user)
	{
		User existingUser = findUserByEmail(user.getEmail());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setDob(user.getDob());
		//userRepository.save(user);
	}
	
	public void deleteUser(Integer userId)
	{
		userRepository.delete(userId);
	}

	public User findUserById(Integer userId)
	{
		return userRepository.findOne(userId);
	}

	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}

	public boolean checkEmailExists(String email)
	{
		return userRepository.findByEmail(email) != null;
	}

	public User login(String email, String password)
	{
		return userRepository.login(email, password);
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void changePwd(ChangePasswordBean changePwdBean) {
		User user = findUserByEmail(changePwdBean.getEmail());
		if(!user.getPassword().equals(changePwdBean.getOldPwd())){
			throw new RuntimeException("Old Password did not match");
		}
		
		userRepository.changePwd(changePwdBean.getEmail(), changePwdBean.getOldPwd(), changePwdBean.getNewPwd());
	}

}
