package com.sivalabs.angularcrud.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.angularcrud.entities.Contact;
import com.sivalabs.angularcrud.entities.Role;
import com.sivalabs.angularcrud.entities.User;
import com.sivalabs.angularcrud.repositories.ContactRepository;
import com.sivalabs.angularcrud.repositories.RoleRepository;
import com.sivalabs.angularcrud.repositories.UserRepository;

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
	
	@Autowired
	private ContactRepository contactRepository;

	public void createUser(User user)
	{
		if(checkEmailExists(user.getEmail()))
		{
			throw new RuntimeException("Email ["+user.getEmail()+"] already exist");
		}
		userRepository.save(user);
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

	public User login(String userName, String password)
	{
		return userRepository.findByEmailAndPassword(userName, password);
	}

	public void addRole(Role role) {
		roleRepository.save(role);
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<Contact> findUserContacts(int userId) {
		return new ArrayList<>(findUserById(userId).getContacts());
	}

	public Contact findUserContact(int userId, int contactId) {
		return contactRepository.findOne(contactId);
	}

	public Contact saveUserContact(Contact contact) {
		return contactRepository.save(contact);
	}

	public void deleteUserContact(int userId, int contactId) {
		contactRepository.delete(contactId);
	}
}
