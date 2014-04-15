/**
 * 
 */
package com.sivalabs.phonebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.repositories.ContactRepository;
import com.sivalabs.phonebook.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class PhoneBookService 
{
	@Autowired private UserRepository userRepository;
	@Autowired private ContactRepository contactRepository;
	
	public Contact createContact(Integer userId, Contact contact) {
		User user = userRepository.findOne(userId);
		user.getContacts().add(contact);
		return contact;
	}
	
	public List<Contact> findUserContacts(Integer userId) {
		User user = userRepository.findOne(userId);
		return user.getContacts();
	}
	
	public List<Contact> searchUserContacts(Integer userId, String query) {
		User user = userRepository.findOne(userId);
		return user.getContacts();
	}
	
	public Contact findContact(int contactId) {
		return contactRepository.findOne(contactId);
	}
	
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public void deleteContact(int contactId) {
		contactRepository.delete(contactId);
	}
	
	public void deleteAllContacts(int userId) {
		User user = userRepository.findOne(userId);
		user.getContacts().clear();
	}
}
