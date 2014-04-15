/**
 * 
 */
package com.sivalabs.jacksondemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.jacksondemo.entities.Contact;
import com.sivalabs.jacksondemo.repositories.ContactRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class ContactService 
{

	@Autowired
	private ContactRepository contactRepository;
	
	public Contact findContactById(Integer contactId) {
		return contactRepository.findOne(contactId);
	}
	
	public List<Contact> findAllContacts()
	{
		return contactRepository.findAll();
	}
	
	public List<Contact> findUserContacts(Integer userId)
	{
		return contactRepository.findByUserId(userId);
	}
	
	public void createContact(Contact contact) 
	{
		contactRepository.save(contact);
	}
	
	public void updateContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	public void deleteContact(Integer contactId) {
		contactRepository.delete(contactId);
	}
}
